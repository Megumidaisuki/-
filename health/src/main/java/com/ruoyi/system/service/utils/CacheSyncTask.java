package com.ruoyi.system.service.utils;

import com.ruoyi.system.service.utils.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

//定时任务
@Component
public class CacheSyncTask {

    private final RedisService redisService;
    private final RedisTemplate redisTemplate;

    @Autowired
    public CacheSyncTask(RedisService redisService, RedisTemplate redisTemplate) {
        this.redisService = redisService;
        this.redisTemplate = redisTemplate;
    }

    @Scheduled(fixedRate = 5000) // 每秒执行一次
    public void syncCacheToDatabase() {
        // 使用 SCAN 而不是 KEYS 来获取所有键，避免性能问题
        Set<String> keys = redisTemplate.keys("article:*");
        if (keys != null) {
            for (String key : keys) {
                // 从键名中解析出文章 ID 和类型
                String[] parts = key.split(":");
                Long articleId = Long.valueOf(parts[2]); // 例如 "article:like:1" 中的 1

                if (parts[1].equals("like")) {
                    Integer likeCount = redisService.getLikeCount(articleId);
                    redisService.saveToArticleDatabase(articleId, likeCount, null);
                } else if (parts[1].equals("view")) {
                    Integer viewCount = redisService.getViewCount(articleId);
                    redisService.saveToArticleDatabase(articleId, null, viewCount);
                }
            }
        }
        //评论的定时任务
        Set<String> commentKeys = redisTemplate.keys("comment:*");
        if (commentKeys != null) {
            for (String commentKey : commentKeys) {
                // 从键名中解析出评论 ID 和类型
                String[] parts = commentKey.split(":");
                Long commentId = Long.valueOf(parts[2]); // 例如 "comment:like:1" 中的 1

                if (parts[1].equals("like")) {
                    Integer likeCount = redisService.getCommentLikeCount(commentId);
                    redisService.saveToCommentDatabase(commentId, likeCount);
                }
            }
        }
    }
}
