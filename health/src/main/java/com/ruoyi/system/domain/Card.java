package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 card
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public class Card extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 打卡id */
    private Long cardId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 评分 */
    @Excel(name = "评分")
    private Long score;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long isDeleted;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String path;

    public void setCardId(Long cardId) 
    {
        this.cardId = cardId;
    }

    public Long getCardId() 
    {
        return cardId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cardId", getCardId())
            .append("userId", getUserId())
            .append("score", getScore())
            .append("createTime", getCreateTime())
            .append("isDeleted", getIsDeleted())
            .append("path", getPath())
            .toString();
    }
}
