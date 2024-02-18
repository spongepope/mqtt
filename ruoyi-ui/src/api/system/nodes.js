import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listNodes(query) {
    return request({
        url: '/system/nodes/list',
        method: 'get',
        params: query
    })
}

// 查询【请填写功能名称】详细
export function getNodes(nodeId) {
    return request({
        url: '/system/nodes/' + nodeId,
        method: 'get'
    })
}

// 新增【请填写功能名称】
export function addNodes(data) {
    return request({
        url: '/system/nodes',
        method: 'post',
        data: data
    })
}

// 修改【请填写功能名称】
export function updateNodes(data) {
    return request({
        url: '/system/nodes',
        method: 'put',
        data: data
    })
}

// 删除【请填写功能名称】
export function delNodes(nodeId) {
    return request({
        url: '/system/nodes/' + nodeId,
        method: 'delete'
    })
}
