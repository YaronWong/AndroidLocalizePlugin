package com.airsaid.localization.translate.services;

import com.airsaid.localization.translate.util.GsonUtil;
import com.airsaid.localization.translate.util.LRUCache;
import com.google.gson.reflect.TypeToken;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.Converter;
import com.intellij.util.xmlb.XmlSerializerUtil;
import com.intellij.util.xmlb.annotations.OptionTag;
import com.intellij.util.xmlb.annotations.Transient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Cache the translated text to local disk.
 * <p>
 * Cache up to {@link #CACHE_ITEM_SIZE} data, after which the old text is removed according to the LRU algorithm..
 *
 * @author airsaid
 */
@State(
    name = "com.airsaid.localization.translate.services.TranslationCacheService",
    storages = {@Storage("androidLocalizeTranslationCaches.xml")}
)
@Service
public final class TranslationCacheService implements PersistentStateComponent<TranslationCacheService>, Disposable {

  @Transient
  private static final int CACHE_ITEM_SIZE = 100;

  @OptionTag(converter = LruCacheConverter.class)
  private final LRUCache<String, String> lruCache = new LRUCache<>(CACHE_ITEM_SIZE);

  public static TranslationCacheService getInstance() {
    return ServiceManager.getService(TranslationCacheService.class);
  }

  public void put(@NotNull String key, @NotNull String value) {
    lruCache.put(key, value);
  }

  @NotNull
  public String get(String key) {
    String value = lruCache.get(key);
    return value != null ? value : "";
  }

  @Override
  public @NotNull TranslationCacheService getState() {
    return this;
  }

  @Override
  public void loadState(@NotNull TranslationCacheService state) {
    XmlSerializerUtil.copyBean(state, this);
  }

  @Override
  public void dispose() {
    lruCache.clear();
  }

  static class LruCacheConverter extends Converter<LRUCache<String, String>> {
    @Override
    public @Nullable LRUCache<String, String> fromString(@NotNull String value) {
      Type type = new TypeToken<Map<String, String>>() {}.getType();
      Map<String, String> map = GsonUtil.getInstance().getGson().fromJson(value, type);
      LRUCache<String, String> lruCache = new LRUCache<>(CACHE_ITEM_SIZE);
      for (Map.Entry<String, String> entry : map.entrySet()) {
        lruCache.put(entry.getKey(), entry.getValue());
      }
      return lruCache;
    }

    @Override
    public @Nullable String toString(@NotNull LRUCache<String, String> lruCache) {
      Map<String, String> values = new LinkedHashMap<>();
      lruCache.forEach(values::put);
      return GsonUtil.getInstance().getGson().toJson(values);
    }
  }
}
