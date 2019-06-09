package cn.hm;

import cn.hm.dao.ItemMapper;
import cn.hm.model.Item;
import cn.hm.model.ItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    @Test
    public void test(){
    /**
     * 测试分页
     */
    //初始化spring容器
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
    //从容器中获取Mapper代理对象
    ItemMapper itemMapper = context.getBean(ItemMapper.class);
    //执行sql语句之前设置分页信息使用PageHelper的startPage方法
    PageHelper.startPage(1, 10);
    //执行查询
    ItemExample example = new ItemExample();
    List<Item> items = itemMapper.selectByExample(example);
    System.out.println(items.getClass().getName());
    //去分页信息，PageInfo
    PageInfo<Item> pageInfo = new PageInfo<>(items);
    System.out.println(pageInfo.getTotal());  //查询到的数据总量
    System.out.println(pageInfo.getPages());  //总页数
    System.out.println(pageInfo.getSize());  //每页显示条数
    }

}
















