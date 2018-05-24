package com.wujianbo.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.Weigher;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by wujianbo on 2018/5/4.
 */
public class GuavaCacheTest {

    @Test
    public void testCache(){
        // 创建1个cache,最多能存放5个缓存条目
        Cache cache = CacheBuilder.newBuilder().recordStats().maximumSize(5).build();
        for (int i = 0; i < 10; i++) {
            cache.put(i, i);
        }
        // {6=6, 5=5, 9=9, 7=7, 8=8}
        System.out.println(cache.asMap());
    }

    @Test
    public void testWeigher(){
        // 创建1个cache,最大权重是100,如果缓存值是偶数占20个权重,奇数占5个权重
        Cache<Integer, Integer> cache = CacheBuilder.newBuilder().recordStats().
                maximumWeight(100).weigher(new Weigher<Integer, Integer>() {
            @Override
            public int weigh(Integer key, Integer value) {
                if (value % 2 == 0) {
                    return 20;
                } else {
                    return 5;
                }
            }
        }).build();

        // 放偶数
        for (int i = 0; i < 10; i += 2) {
            cache.put(i, i);
        }
        // {6=6, 8=8, 2=2, 4=4}
        System.out.println(cache.asMap());
        // 清空所有缓存
        cache.invalidateAll();
        // 放奇数
        for (int i = 1; i < 10; i += 1) {
            cache.put(i, i);
        }
        // {6=6, 5=5, 8=8, 7=7, 2=2, 9=9, 3=3, 4=4}
        System.out.println(cache.asMap());
    }

    @Test
    public void testTimeCache(){
        // 缓存5s内没有访问(包括读和写),则缓存会被移除
        Cache<Integer, Integer> cache = CacheBuilder.newBuilder().recordStats()
                .expireAfterAccess(5, TimeUnit.SECONDS).build();

        cache.put(1, 1);
        System.out.println(cache.getIfPresent(1));//not null

        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }

        System.out.println(cache.getIfPresent(1));//null
    }

    @Test
    public void testTimeandSizeCache(){
        // 缓存5s内没有访问(包括读和写),则缓存会被移除
        Cache<Integer, Integer> cache = CacheBuilder.newBuilder().recordStats().maximumSize(100)
                .expireAfterAccess(5, TimeUnit.SECONDS).build();
        for (int i = 1; i < 10000; i++) {
            cache.put(i,1);
        }
    }


}
