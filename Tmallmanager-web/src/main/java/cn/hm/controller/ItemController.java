package cn.hm.controller;

import cn.hm.common.pojo.EasyUIDataGridResult;
import cn.hm.model.Item;
import cn.hm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lbc
 * @description: 商品管理Controller
 * @date 2019/6/7 20:50
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")  //{itemId}匹配路径里面itemId的参数
    @ResponseBody //会自动的将pojo转成json，必须引入jakson包，否则406错误
    public Item getItemById(@PathVariable Long itemId){   //参数必须和上面的{}里面的一致
        Item item = itemService.getItemById(itemId);
        System.out.println("访问成功...");
        System.out.println(item.toString());
        return item;
    }

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(int page, int rows){
        //调用服务
        EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }


}
