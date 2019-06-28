package cn.hm.service;

import cn.hm.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * @author lbc
 * @description: TODO
 * @date 2019/6/9 16:21
 */
public interface ItemCatService {
    //得到商品分类列表
    List<EasyUITreeNode> getItemCatList(long parentId);
}
