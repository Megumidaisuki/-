package com.ruoyi.system.service.utils;

import com.ruoyi.system.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
//
@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ArticleMapper articleMapper;
    //文章点赞量自增1
    public void incrementLikeCount(Long articleId) {
        String key = "article:like:" + articleId;
        redisTemplate.opsForValue().increment(key);
    }
    //文章浏览量自增1
    public void incrementViewCount(Long articleId) {
        String key = "article:view:" + articleId;
        redisTemplate.opsForValue().increment(key);
    }
    //得到文章点赞量
    public Integer getLikeCount(Long articleId) {
        String key = "article:like:" + articleId;
        return (Integer) redisTemplate.opsForValue().get(key);
    }
    //得到文章浏览量
    public Integer getViewCount(Long articleId) {
        String key = "article:view:" + articleId;
        return (Integer) redisTemplate.opsForValue().get(key);
    }
    //设置文章点赞量
    public void setLikeCount(Long articleId, Integer like) {
        String key = "article:like:" + articleId;
        redisTemplate.opsForValue().set(key, like);
    }
    //设置文章浏览量
    public void setViewCount(Long articleId, Integer viewCount) {
        String key = "article:view:" + articleId;
        redisTemplate.opsForValue().set(key, viewCount);
    }

    public void saveToDatabase(Long articleId, Integer like, Integer viewCount) {
        // 这里可以调用相应的数据库服务，将缓存的点赞量和浏览量保存到数据库中
        articleMapper.renewArticle(articleId,like,viewCount);
    }
}
