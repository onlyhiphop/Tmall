package cn.hm.service.impl;

import cn.hm.common.pojo.EasyUIDataGridResult;
import cn.hm.common.pojo.ItemAddResult;
import cn.hm.common.utils.IDUtils;
import cn.hm.dao.ItemMapper;
import cn.hm.dao.Item_descMapper;
import cn.hm.model.Item;
import cn.hm.model.ItemExample;
import cn.hm.model.Item_desc;
import cn.hm.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lbc
 * @description: 商品服务
 * @date 2019/6/7 19:36
 */
@Service  //默认取名为 id为 itemServiceImpl
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private Item_descMapper item_descMapper;

    @Override
    public Item getItemById(Long itemId) {
        //根据主键查询
        Item item = itemMapper.selectByPrimaryKey(itemId);
        return item;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //设置分页信息
        PageHelper.startPage(page, rows);
        //执行查询
        ItemExample example = new ItemExample();
        List<Item> items = itemMapper.selectByExample(example);
        //创建一个返回值对象
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(items);
        //取分页结果
        PageInfo<Item> pageInfo = new PageInfo<>(items);
        long total = pageInfo.getTotal();
        result.setTotal(total);
        return result;
    }

    @Override
    public ItemAddResult addItem(Item item, String desc) {
        //生成商品的id
        long itemId = IDUtils.genItemId();
        //补全Item的属性
        item.setId(itemId);
        //1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        //现在的时间
        Date date = new Date();
        item.setUpdated(date);
        item.setCreated(date);
        //向商品表插入数据
        itemMapper.insert(item);

        //向商品描述表插入数据
        Item_desc item_desc = new Item_desc();
        item_desc.setItemDesc(desc);
        item_desc.setItemId(itemId);
        item_desc.setCreated(date);
        item_desc.setUpdated(date);

        item_descMapper.insert(item_desc);
        return ItemAddResult.ok();
    }
}



















