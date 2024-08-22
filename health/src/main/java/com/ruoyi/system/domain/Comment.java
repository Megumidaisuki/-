package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 comment
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public class Comment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long commentId;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 父评论id（没有的话就是0） */
    @Excel(name = "父评论id", readConverterExp = "没=有的话就是0")
    private Long parentId;

    /** 点赞量 */
    @Excel(name = "点赞量")
    private Long like;

    /** 用户 */
    @Excel(name = "用户")
    private Long userId;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long isDeleted;

    /** 文章id */
    @Excel(name = "文章id")
    private Long articleId;

    public void setCommentId(Long commentId) 
    {
        this.commentId = commentId;
    }

    public Long getCommentId() 
    {
        return commentId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setLike(Long like) 
    {
        this.like = like;
    }

    public Long getLike() 
    {
        return like;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }
    public void setArticleId(Long articleId) 
    {
        this.articleId = articleId;
    }

    public Long getArticleId() 
    {
        return articleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("commentId", getCommentId())
            .append("content", getContent())
            .append("parentId", getParentId())
            .append("like", getLike())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .append("isDeleted", getIsDeleted())
            .append("articleId", getArticleId())
            .toString();
    }
}
