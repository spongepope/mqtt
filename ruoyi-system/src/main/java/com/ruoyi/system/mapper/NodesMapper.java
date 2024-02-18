package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Nodes;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-16
 */
public interface NodesMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param nodeId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Nodes selectNodesByNodeId(Long nodeId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param nodes 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Nodes> selectNodesList(Nodes nodes);

    /**
     * 新增【请填写功能名称】
     * 
     * @param nodes 【请填写功能名称】
     * @return 结果
     */
    public int insertNodes(Nodes nodes);

    /**
     * 修改【请填写功能名称】
     * 
     * @param nodes 【请填写功能名称】
     * @return 结果
     */
    public int updateNodes(Nodes nodes);

    /**
     * 删除【请填写功能名称】
     * 
     * @param nodeId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteNodesByNodeId(Long nodeId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param nodeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNodesByNodeIds(Long[] nodeIds);
}
