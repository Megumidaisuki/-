package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 article
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public class Article extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long articleId;

    /** 标题 */
    @Excel(name = "标题")
    private String titile;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 封面（做成缩略图） */
    @Excel(name = "封面", readConverterExp = "做=成缩略图")
    private String cover;

    /** 作者 */
    @Excel(name = "作者")
    private Long author;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long viewCount;

    /** 点赞量 */
    @Excel(name = "点赞量")
    private Long like;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long isDeleted;

    /** 0代表科普，1代表交流分享 */
    @Excel(name = "0代表科普，1代表交流分享")
    private Long status;

    public void setArticleId(Long articleId) 
    {
        this.articleId = articleId;
    }

    public Long getArticleId() 
    {
        return articleId;
    }
    public void setTitile(String titile) 
    {
        this.titile = titile;
    }

    public String getTitile() 
    {
        return titile;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setCover(String cover) 
    {
        this.cover = cover;
    }

    public String getCover() 
    {
        return cover;
    }
    public void setAuthor(Long author) 
    {
        this.author = author;
    }

    public Long getAuthor() 
    {
        return author;
    }
    public void setViewCount(Long viewCount) 
    {
        this.viewCount = viewCount;
    }

    public Long getViewCount() 
    {
        return viewCount;
    }
    public void setLike(Long like) 
    {
        this.like = like;
    }

    public Long getLike() 
    {
        return like;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("articleId", getArticleId())
            .append("titile", getTitile())
            .append("content", getContent())
            .append("cover", getCover())
            .append("author", getAuthor())
            .append("viewCount", getViewCount())
            .append("createTime", getCreateTime())
            .append("like", getLike())
            .append("isDeleted", getIsDeleted())
            .append("status", getStatus())
            .toString();
    }
}
