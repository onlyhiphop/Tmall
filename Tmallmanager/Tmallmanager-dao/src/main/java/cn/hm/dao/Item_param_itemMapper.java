package cn.hm.dao;

import cn.hm.model.Item_param_item;
import cn.hm.model.Item_param_itemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Item_param_itemMapper {
    int countByExample(Item_param_itemExample example);

    int deleteByExample(Item_param_itemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Item_param_item record);

    int insertSelective(Item_param_item record);

    List<Item_param_item> selectByExampleWithBLOBs(Item_param_itemExample example);

    List<Item_param_item> selectByExample(Item_param_itemExample example);

    Item_param_item selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Item_param_item record, @Param("example") Item_param_itemExample example);

    int updateByExampleWithBLOBs(@Param("record") Item_param_item record, @Param("example") Item_param_itemExample example);

    int updateByExample(@Param("record") Item_param_item record, @Param("example") Item_param_itemExample example);

    int updateByPrimaryKeySelective(Item_param_item record);

    int updateByPrimaryKeyWithBLOBs(Item_param_item record);

    int updateByPrimaryKey(Item_param_item record);
}