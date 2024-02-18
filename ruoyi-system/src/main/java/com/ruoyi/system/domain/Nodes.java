package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 对象 nodes
 * 
 * @author cl
 * @date 2024-02-16
 */
public class Nodes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 节点ID */
    private Long nodeId;

    /** 节点名称 */
    @Excel(name = "节点名称")
    private String nodeName;

    /** 节点状态 */
    @Excel(name = "节点状态")
    private Long nodeStatus;

    public void setNodeId(Long nodeId) 
    {
        this.nodeId = nodeId;
    }

    public Long getNodeId() 
    {
        return nodeId;
    }
    public void setNodeName(String nodeName) 
    {
        this.nodeName = nodeName;
    }

    public String getNodeName() 
    {
        return nodeName;
    }
    public void setNodeStatus(Long nodeStatus) 
    {
        this.nodeStatus = nodeStatus;
    }

    public Long getNodeStatus() 
    {
        return nodeStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("nodeId", getNodeId())
            .append("nodeName", getNodeName())
            .append("nodeStatus", getNodeStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
