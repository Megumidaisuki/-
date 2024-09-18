package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Questionnaire;
import com.ruoyi.system.service.IQuestionnaireService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2024-08-22
 */
@RestController
@RequestMapping("/system/questionnaire")
public class QuestionnaireController extends BaseController
{
    @Autowired
    private IQuestionnaireService questionnaireService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:questionnaire:list')")
    @GetMapping("/list")
    public TableDataInfo list(Questionnaire questionnaire)
    {
        startPage();
        List<Questionnaire> list = questionnaireService.selectQuestionnaireList(questionnaire);
        return getDataTable(list);
    }

    /**
     * 查询问卷的详细信息
     */
    @PreAuthorize(value = "@ss.hasPermi('system:questionnaire:list')")
    @GetMapping("/getQuestionnaireMessage")
    public AjaxResult getQuestionnaieMessage(Questionnaire questionnaire)
    {
        return success(questionnaireService.selectQuestionnaireMessage(questionnaire));
    }

    /**
     * 查询用户没有做过的问卷
     */

    @PreAuthorize("@ss.hasPermi('system:questionnaire:list')")
    @GetMapping("/getUserQuestionnaire")
    public AjaxResult getUserQuestionnaire()
    {
        return success(questionnaireService.selectUserQuestionnaire());
    }


    /**
     * 提交问卷
     */
    @PreAuthorize("@ss.hasPermi('system:questionnaire:list')")
    @PostMapping("/submitQuestionnaire")
    public AjaxResult submitQuestionnaire(@RequestBody Questionnaire questionnaire, String text){
        questionnaireService.submitQuestionnaire(questionnaire,text);
        return success();
    }

    /**
     * 新增问卷
     */
    @PreAuthorize("@ss.hasPermi('system:questionnaire:list')")
    @Log(title = "新增问卷", businessType = BusinessType.INSERT)
    @PostMapping("/addQuestionnaire")
    public AjaxResult addQuestionnaire(@RequestBody Questionnaire questionnaire)
    {
        return toAjax(questionnaireService.addQuestionnaire(questionnaire));
    }

    /**
     * 删除问卷
     */

    @Log(title = "删除问卷", businessType = BusinessType.DELETE)
    @DeleteMapping("/deleteQuestionnaire/{questionnaireId}")
    public AjaxResult deleteQuestionnaire(@PathVariable Long questionnaireId)
    {
        return toAjax(questionnaireService.deleteQuestionnaire(questionnaireId));
    }


    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:questionnaire:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Questionnaire questionnaire)
    {
        List<Questionnaire> list = questionnaireService.selectQuestionnaireList(questionnaire);
        ExcelUtil<Questionnaire> util = new ExcelUtil<Questionnaire>(Questionnaire.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:questionnaire:query')")
    @GetMapping(value = "/{questionnaireId}")
    public AjaxResult getInfo(@PathVariable("questionnaireId") Long questionnaireId)
    {
        return success(questionnaireService.selectQuestionnaireByQuestionnaireId(questionnaireId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:questionnaire:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Questionnaire questionnaire)
    {
        return toAjax(questionnaireService.insertQuestionnaire(questionnaire));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:questionnaire:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Questionnaire questionnaire)
    {
        return toAjax(questionnaireService.updateQuestionnaire(questionnaire));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:questionnaire:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{questionnaireIds}")
    public AjaxResult remove(@PathVariable Long[] questionnaireIds)
    {
        return toAjax(questionnaireService.deleteQuestionnaireByQuestionnaireIds(questionnaireIds));
    }
}
