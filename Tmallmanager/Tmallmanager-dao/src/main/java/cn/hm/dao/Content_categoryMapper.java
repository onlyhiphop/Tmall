package cn.hm.dao;

import cn.hm.model.Content_category;
import cn.hm.model.Content_categoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Content_categoryMapper {
    int countByExample(Content_categoryExample example);

    int deleteByExample(Content_categoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Content_category record);

    int insertSelective(Content_category record);

    List<Content_category> selectByExample(Content_categoryExample example);

    Content_category selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Content_category record, @Param("example") Content_categoryExample example);

    int updateByExample(@Param("record") Content_category record, @Param("example") Content_categoryExample example);

    int updateByPrimaryKeySelective(Content_category record);

    int updateByPrimaryKey(Content_category record);
}