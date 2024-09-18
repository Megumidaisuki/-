package com.ruoyi.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private String username;
    private String avatar;

}
