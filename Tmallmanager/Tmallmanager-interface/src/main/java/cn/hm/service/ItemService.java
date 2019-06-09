package cn.hm.service;

import cn.hm.common.pojo.EasyUIDataGridResult;
import cn.hm.model.Item;

/**
 * @author lbc
 * @description: TODO
 * @date 2019/6/7 19:34
 */
public interface ItemService {

    // 通过id查找商品
    Item getItemById(Long itemId);

    EasyUIDataGridResult getItemList(int page, int rows);
}
