package com.ruoyi.system.service.utils;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.mapper.ArticleMapper;
import com.ruoyi.system.mapper.CommentMapper;
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
    @Autowired
    private CommentMapper commentMapper;
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
    //评论点赞量自增1
    public void incrementCommentLikeCount(Long commentId) {
        String key = "comment:like:" + commentId;
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
    //得到评论点赞量
    public Integer getCommentLikeCount(Long commentId) {
        String key = "comment:like:" + commentId;
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
    //设置评论点赞量
    public void setCommentLikeCount(Long commentId, Integer like) {
        String key = "comment:like:" + commentId;
        redisTemplate.opsForValue().set(key, like);
    }
    //把sessionKey存入redis
    public void setSessionKey(String sessionKey){
        String key = "session:key"+ SecurityUtils.getUserId();
        redisTemplate.opsForValue().set(key,sessionKey);
    }
    //得到sessionKey
    public void getSessionKey(){
        String key = "session:key" + SecurityUtils.getUserId();
        redisTemplate.opsForValue().get(key);
    }

    public void saveToArticleDatabase(Long articleId, Integer articlelike, Integer viewCount) {
        // 这里可以调用相应的数据库服务，将缓存的点赞量和浏览量保存到数据库中
        if(articlelike != null || viewCount != null){
            articleMapper.renewArticle(articleId,articlelike,viewCount);
        }
    }

    public void saveToCommentDatabase(Long commentId,Integer commentlike) {
        // 这里可以调用相应的数据库服务，将缓存的点赞量和浏览量保存到数据库中
        if(commentlike != null){
            commentMapper.renewComment(commentId,commentlike);
        }
    }
}
