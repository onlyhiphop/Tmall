package cn.hm.dao;

import cn.hm.model.Order_item;
import cn.hm.model.Order_itemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Order_itemMapper {
    int countByExample(Order_itemExample example);

    int deleteByExample(Order_itemExample example);

    int deleteByPrimaryKey(String id);

    int insert(Order_item record);

    int insertSelective(Order_item record);

    List<Order_item> selectByExample(Order_itemExample example);

    Order_item selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Order_item record, @Param("example") Order_itemExample example);

    int updateByExample(@Param("record") Order_item record, @Param("example") Order_itemExample example);

    int updateByPrimaryKeySelective(Order_item record);

    int updateByPrimaryKey(Order_item record);
}