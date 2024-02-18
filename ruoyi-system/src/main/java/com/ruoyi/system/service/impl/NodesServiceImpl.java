package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.NodesMapper;
import com.ruoyi.system.domain.Nodes;
import com.ruoyi.system.service.INodesService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-16
 */
@Service
public class NodesServiceImpl implements INodesService 
{
    @Autowired
    private NodesMapper nodesMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param nodeId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Nodes selectNodesByNodeId(Long nodeId)
    {
        return nodesMapper.selectNodesByNodeId(nodeId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param nodes 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Nodes> selectNodesList(Nodes nodes)
    {
        return nodesMapper.selectNodesList(nodes);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param nodes 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertNodes(Nodes nodes)
    {
        nodes.setCreateTime(DateUtils.getNowDate());
        return nodesMapper.insertNodes(nodes);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param nodes 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateNodes(Nodes nodes)
    {
        nodes.setUpdateTime(DateUtils.getNowDate());
        return nodesMapper.updateNodes(nodes);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param nodeIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteNodesByNodeIds(Long[] nodeIds)
    {
        return nodesMapper.deleteNodesByNodeIds(nodeIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param nodeId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteNodesByNodeId(Long nodeId)
    {
        return nodesMapper.deleteNodesByNodeId(nodeId);
    }
}
