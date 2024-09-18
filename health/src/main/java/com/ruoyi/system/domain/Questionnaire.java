package com.ruoyi.system.domain;

import io.lettuce.core.protocol.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 【请填写功能名称】对象 questionnaire
 *
 * @author ruoyi
 * @date 2024-08-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questionnaire extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long questionnaireId;

    /** 介绍 */
    @Excel(name = "介绍")
    private String content;


    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long isDeleted;

    private List<Question> questionList;

    private Long userId;


}
