package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Record;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public interface IRecordService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param recordId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Record selectRecordByRecordId(Long recordId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param record 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Record> selectRecordList(Record record);

    /**
     * 新增【请填写功能名称】
     * 
     * @param record 【请填写功能名称】
     * @return 结果
     */
    public int insertRecord(Record record);

    /**
     * 修改【请填写功能名称】
     * 
     * @param record 【请填写功能名称】
     * @return 结果
     */
    public int updateRecord(Record record);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param recordIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteRecordByRecordIds(Long[] recordIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param recordId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteRecordByRecordId(Long recordId);
}
