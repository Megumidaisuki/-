package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Consult;

/**
 * 咨询Service接口
 * 
 * @author ruoyi
 * @date 2024-09-18
 */
public interface IConsultService 
{
    /**
     * 查询咨询
     * 
     * @param consultId 咨询主键
     * @return 咨询
     */
    public Consult selectConsultByConsultId(Long consultId);

    /**
     * 查询咨询列表
     * 
     * @param consult 咨询
     * @return 咨询集合
     */
    public List<Consult> selectConsultList(Consult consult);

    /**
     * 新增咨询
     * 
     * @param consult 咨询
     * @return 结果
     */
    public int insertConsult(Consult consult);

    /**
     * 修改咨询
     * 
     * @param consult 咨询
     * @return 结果
     */
    public int updateConsult(Consult consult);

    /**
     * 批量删除咨询
     * 
     * @param consultIds 需要删除的咨询主键集合
     * @return 结果
     */
    public int deleteConsultByConsultIds(Long[] consultIds);

    /**
     * 删除咨询信息
     * 
     * @param consultId 咨询主键
     * @return 结果
     */
    public int deleteConsultByConsultId(Long consultId);
}
