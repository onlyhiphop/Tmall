package cn.hm.dao;

import cn.hm.model.Item_cat;
import cn.hm.model.Item_catExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Item_catMapper {
    int countByExample(Item_catExample example);

    int deleteByExample(Item_catExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Item_cat record);

    int insertSelective(Item_cat record);

    List<Item_cat> selectByExample(Item_catExample example);

    Item_cat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Item_cat record, @Param("example") Item_catExample example);

    int updateByExample(@Param("record") Item_cat record, @Param("example") Item_catExample example);

    int updateByPrimaryKeySelective(Item_cat record);

    int updateByPrimaryKey(Item_cat record);
}