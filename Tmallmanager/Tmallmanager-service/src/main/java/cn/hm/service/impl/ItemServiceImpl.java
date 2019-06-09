package cn.hm.service.impl;

import cn.hm.common.pojo.EasyUIDataGridResult;
import cn.hm.dao.ItemMapper;
import cn.hm.model.Item;
import cn.hm.model.ItemExample;
import cn.hm.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}



















