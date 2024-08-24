package com.ruoyi.system.service.utils;

import com.ruoyi.system.domain.Article;
import com.ruoyi.system.domain.Comment;
import com.ruoyi.system.mapper.ArticleMapper;
import com.ruoyi.system.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
//commandLineRunner实现热点数据初始化到redis
@Component
public class StartupRunner {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CommentMapper commentMapper;
    @Bean
    public ApplicationRunner init(RedisService redisService) {
        return args -> {
            // 从数据库中加载所有文章的点赞量和浏览量
            List<Article> articles = articleMapper.selectArticleList(new Article());
            for (Article article : articles) {
                redisService.setLikeCount(article.getArticleId(), Math.toIntExact(article.getLike()));
                redisService.setViewCount(article.getArticleId(), Math.toIntExact(article.getViewCount()));
            }
            // 从数据库中加载评论得点赞量
            List<Comment> comments = commentMapper.selectCommentList(new Comment());
            for (Comment comment : comments) {
                redisService.setCommentLikeCount(comment.getCommentId(), Math.toIntExact(comment.getLike()));
            }
        };
    }
}
