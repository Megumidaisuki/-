package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RecordMapper;
import com.ruoyi.system.domain.Record;
import com.ruoyi.system.service.IRecordService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
@Service
public class RecordServiceImpl implements IRecordService 
{
    @Autowired
    private RecordMapper recordMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param recordId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Record selectRecordByRecordId(Long recordId)
    {
        return recordMapper.selectRecordByRecordId(recordId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param record 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Record> selectRecordList(Record record)
    {
        return recordMapper.selectRecordList(record);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param record 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRecord(Record record)
    {
        record.setCreateTime(DateUtils.getNowDate());
        return recordMapper.insertRecord(record);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param record 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRecord(Record record)
    {
        return recordMapper.updateRecord(record);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param recordIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRecordByRecordIds(Long[] recordIds)
    {
        return recordMapper.deleteRecordByRecordIds(recordIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param recordId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRecordByRecordId(Long recordId)
    {
        return recordMapper.deleteRecordByRecordId(recordId);
    }
}
