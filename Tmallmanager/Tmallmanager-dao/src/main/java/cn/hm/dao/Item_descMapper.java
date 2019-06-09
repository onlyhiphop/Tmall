package cn.hm.dao;

import cn.hm.model.Item_desc;
import cn.hm.model.Item_descExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Item_descMapper {
    int countByExample(Item_descExample example);

    int deleteByExample(Item_descExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(Item_desc record);

    int insertSelective(Item_desc record);

    List<Item_desc> selectByExampleWithBLOBs(Item_descExample example);

    List<Item_desc> selectByExample(Item_descExample example);

    Item_desc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") Item_desc record, @Param("example") Item_descExample example);

    int updateByExampleWithBLOBs(@Param("record") Item_desc record, @Param("example") Item_descExample example);

    int updateByExample(@Param("record") Item_desc record, @Param("example") Item_descExample example);

    int updateByPrimaryKeySelective(Item_desc record);

    int updateByPrimaryKeyWithBLOBs(Item_desc record);

    int updateByPrimaryKey(Item_desc record);
}