package com.ahuixsttest.testdom4j;

import com.ahuixst.config.ApplicationConfig;
import com.ahuixst.dao.BookMapper;
import com.ahuixst.dao.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BookSingleCaseTest {

    @Resource
    private BookMapper bookMapper;

    @Resource
    private UsersMapper usersMapper;

    @Test
    public void test() {

        /*PageHelper.startPage(1, 3).doSelectPage(() ->{
            for (Book book : bookMapper.selectList(null)) {
                System.out.println(book);
            }
        });*/

        /*Users users = new Users();
        users.setName("tom");
        users.setAge(21);
        int insert = usersMapper.insert(users);
        System.out.println(insert);*/


    }

    /**
     * 原生mybatis测试方式 注意由于配置文件中没有配置数据源信息所以启动会报错.
     * @throws IOException
     */
    /*@Test
    public void MybatisTest() throws IOException {

        //读取配置文件
        Reader resourceAsReader = Resources.getResourceAsReader("config/mybatis-config.xml");

        //构建SqlSessionFactory
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession(true);
        List<Book> bookList = sqlSession.selectList("select * from book");
        for (Book book : bookList) {
            System.out.println(book);
        }

    }*/
}
