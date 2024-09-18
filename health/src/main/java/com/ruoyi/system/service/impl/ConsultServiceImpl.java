package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ConsultMapper;
import com.ruoyi.system.domain.Consult;
import com.ruoyi.system.service.IConsultService;

/**
 * 咨询Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-18
 */
@Service
public class ConsultServiceImpl implements IConsultService 
{
    @Autowired
    private ConsultMapper consultMapper;

    /**
     * 查询咨询
     * 
     * @param consultId 咨询主键
     * @return 咨询
     */
    @Override
    public Consult selectConsultByConsultId(Long consultId)
    {
        return consultMapper.selectConsultByConsultId(consultId);
    }

    /**
     * 查询咨询列表
     * 
     * @param consult 咨询
     * @return 咨询
     */
    @Override
    public List<Consult> selectConsultList(Consult consult)
    {
        return consultMapper.selectConsultList(consult);
    }

    /**
     * 新增咨询
     * 
     * @param consult 咨询
     * @return 结果
     */
    @Override
    public int insertConsult(Consult consult)
    {
        consult.setCreateTime(DateUtils.getNowDate());
        return consultMapper.insertConsult(consult);
    }

    /**
     * 修改咨询
     * 
     * @param consult 咨询
     * @return 结果
     */
    @Override
    public int updateConsult(Consult consult)
    {
        return consultMapper.updateConsult(consult);
    }

    /**
     * 批量删除咨询
     * 
     * @param consultIds 需要删除的咨询主键
     * @return 结果
     */
    @Override
    public int deleteConsultByConsultIds(Long[] consultIds)
    {
        return consultMapper.deleteConsultByConsultIds(consultIds);
    }

    /**
     * 删除咨询信息
     * 
     * @param consultId 咨询主键
     * @return 结果
     */
    @Override
    public int deleteConsultByConsultId(Long consultId)
    {
        return consultMapper.deleteConsultByConsultId(consultId);
    }
}
