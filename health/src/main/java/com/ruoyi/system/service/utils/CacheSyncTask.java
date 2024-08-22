package com.ruoyi.system.service.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CacheSyncTask {

    private final RedisService redisService;

    public CacheSyncTask(RedisService redisService) {
        this.redisService = redisService;
    }

    @Scheduled(fixedRate = 1000) // 每秒执行一次
    public void syncCacheToDatabase() {
        // 假设你有一系列文章ID可以循环遍历
        for (Long articleId : getAllArticleIds()) {
            Integer likeCount = redisService.getLikeCount(articleId);
            Integer viewCount = redisService.getViewCount(articleId);
            redisService.saveToDatabase(articleId, likeCount, viewCount);
        }
    }

    private List<Long> getAllArticleIds() {
        // 从数据库或其他来源获取所有文章ID
        return Arrays.asList(1L, 2L, 3L);
    }
}
