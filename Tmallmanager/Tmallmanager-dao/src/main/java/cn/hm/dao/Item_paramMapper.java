package cn.hm.dao;

import cn.hm.model.Item_param;
import cn.hm.model.Item_paramExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Item_paramMapper {
    int countByExample(Item_paramExample example);

    int deleteByExample(Item_paramExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Item_param record);

    int insertSelective(Item_param record);

    List<Item_param> selectByExampleWithBLOBs(Item_paramExample example);

    List<Item_param> selectByExample(Item_paramExample example);

    Item_param selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Item_param record, @Param("example") Item_paramExample example);

    int updateByExampleWithBLOBs(@Param("record") Item_param record, @Param("example") Item_paramExample example);

    int updateByExample(@Param("record") Item_param record, @Param("example") Item_paramExample example);

    int updateByPrimaryKeySelective(Item_param record);

    int updateByPrimaryKeyWithBLOBs(Item_param record);

    int updateByPrimaryKey(Item_param record);
}