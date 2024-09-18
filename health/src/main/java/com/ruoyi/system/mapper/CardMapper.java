package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-08-22
 */
@Mapper
public interface CardMapper
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
     * 删除【请填写功能名称】
     *
     * @param cardId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteCardByCardId(Long cardId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param cardIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCardByCardIds(Long[] cardIds);

    List<Card> getCardScoreRankings(@Param("formattedDate") String formattedDate, @Param("status") Integer status);
}
