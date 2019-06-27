package cn.hm.controller;

import cn.hm.common.pojo.EasyUITreeNode;
import cn.hm.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lbc
 * @description: TODO
 * @date 2019/6/9 16:50
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getTreeNode(@RequestParam(name = "id", defaultValue = "0")Long parentId){
        return itemCatService.getItemCatList(parentId);
    }
}
