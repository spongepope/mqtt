package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Nodes;
import com.ruoyi.system.service.INodesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * Controller
 * 
 * @author cl
 * @date 2024-02-16
 */
@RestController
@RequestMapping("/system/nodes")
public class NodesController extends BaseController
{
    @Autowired
    private INodesService nodesService;

    /**
     * 查询
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:list')")
    @GetMapping("/list")
    public TableDataInfo list(Nodes nodes)
    {
        startPage();
        List<Nodes> list = nodesService.selectNodesList(nodes);
        return getDataTable(list);
    }

    /**
     * 导出
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Nodes nodes)
    {
        List<Nodes> list = nodesService.selectNodesList(nodes);
        ExcelUtil<Nodes> util = new ExcelUtil<Nodes>(Nodes.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:query')")
    @GetMapping(value = "/{nodeId}")
    public AjaxResult getInfo(@PathVariable("nodeId") Long nodeId)
    {
        return success(nodesService.selectNodesByNodeId(nodeId));
    }

    /**
     * 新增
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Nodes nodes)
    {
        return toAjax(nodesService.insertNodes(nodes));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Nodes nodes)
    {
        return toAjax(nodesService.updateNodes(nodes));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{nodeIds}")
    public AjaxResult remove(@PathVariable Long[] nodeIds)
    {
        return toAjax(nodesService.deleteNodesByNodeIds(nodeIds));
    }
}
