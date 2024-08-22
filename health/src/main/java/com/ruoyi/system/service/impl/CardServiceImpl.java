package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CardMapper;
import com.ruoyi.system.domain.Card;
import com.ruoyi.system.service.ICardService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-22
 */
@Service
public class CardServiceImpl implements ICardService
{
    @Autowired
    private CardMapper cardMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param cardId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Card selectCardByCardId(Long cardId)
    {
        return cardMapper.selectCardByCardId(cardId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param card 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Card> selectCardList(Card card)
    {
        return cardMapper.selectCardList(card);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param card 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCard(Card card)
    {
        card.setCreateTime(DateUtils.getNowDate());
        Long userId = SecurityUtils.getUserId();
        card.setUserId(userId);
        return cardMapper.insertCard(card);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param card 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCard(Card card)
    {
        return cardMapper.updateCard(card);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param cardIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCardByCardIds(Long[] cardIds)
    {
        return cardMapper.deleteCardByCardIds(cardIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param cardId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCardByCardId(Long cardId)
    {
        return cardMapper.deleteCardByCardId(cardId);
    }
}
