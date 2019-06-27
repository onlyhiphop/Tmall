package cn.hm.service.impl;

import cn.hm.common.pojo.EasyUITreeNode;
import cn.hm.dao.Item_catMapper;
import cn.hm.model.Item_cat;
import cn.hm.model.Item_catExample;
import cn.hm.model.Item_catExample.Criteria;
import cn.hm.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lbc
 * @description: 商品分类管理
 * @date 2019/6/9 16:24
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private Item_catMapper item_catMapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {
        //根据parentId查询子节点列表
        Item_catExample example = new Item_catExample();
        Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<Item_cat> item_cats = item_catMapper.selectByExample(example);
        //将列表转换成EasyUITreeNode列表
        List<EasyUITreeNode> lists = new ArrayList<>();
        for (Item_cat item_cat : item_cats) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(item_cat.getId());
            node.setText(item_cat.getName());
            node.setState(item_cat.getIsParent()?"closed":"open");
            lists.add(node);
        }

        return lists;
    }


}
