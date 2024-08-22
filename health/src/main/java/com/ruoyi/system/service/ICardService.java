package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Card;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public interface ICardService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param cardId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Card selectCardByCardId(Long cardId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param card 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Card> selectCardList(Card card);

    /**
     * 新增【请填写功能名称】
     * 
     * @param card 【请填写功能名称】
     * @return 结果
     */
    public int insertCard(Card card);

    /**
     * 修改【请填写功能名称】
     * 
     * @param card 【请填写功能名称】
     * @return 结果
     */
    public int updateCard(Card card);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param cardIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteCardByCardIds(Long[] cardIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param cardId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteCardByCardId(Long cardId);
}
