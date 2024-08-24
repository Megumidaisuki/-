package com.ruoyi.system.service.utils;

import com.ruoyi.system.domain.Comment;
import com.ruoyi.system.domain.CommentWithReplies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentConverter {

    public static List<CommentWithReplies> convertToCommentWithReplies(List<Comment> comments) {
        Map<Long, CommentWithReplies> commentMap = new HashMap<>();
        List<CommentWithReplies> result = new ArrayList<>();

        // 初始化所有的评论对象
        for (Comment comment : comments) {
            CommentWithReplies commentWithReplies = BeanCopyUtils.copyBean(comment, CommentWithReplies.class);
            commentWithReplies.setReplies(new ArrayList<>()); // 初始化子评论列表

            commentMap.put(comment.getCommentId(), commentWithReplies);

            if (comment.getParentId() == 0) {
                result.add(commentWithReplies);
            }
        }

        // 将子评论添加到相应的父评论中
        for (Comment comment : comments) {
            if (comment.getParentId() != 0) {
                CommentWithReplies parent = commentMap.get(comment.getParentId());
                if (parent != null) {
                    parent.getReplies().add(comment);
                }
            }
        }

        return result;
    }
}
