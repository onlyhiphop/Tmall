package cn.hm.dao;

import cn.hm.model.Order_shipping;
import cn.hm.model.Order_shippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Order_shippingMapper {
    int countByExample(Order_shippingExample example);

    int deleteByExample(Order_shippingExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order_shipping record);

    int insertSelective(Order_shipping record);

    List<Order_shipping> selectByExample(Order_shippingExample example);

    Order_shipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order_shipping record, @Param("example") Order_shippingExample example);

    int updateByExample(@Param("record") Order_shipping record, @Param("example") Order_shippingExample example);

    int updateByPrimaryKeySelective(Order_shipping record);

    int updateByPrimaryKey(Order_shipping record);
}