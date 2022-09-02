package com.ahuixst.config;

import com.ahuixst.utils.ResourceUtil;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author: ahui
 * @Description: spring配置
 * @DateTime: 2022/8/29 - 16:09
 **/
@Configuration
@MapperScan("com.ahuixst.dao")
@EnableTransactionManagement
public class ApplicationConfig {

    private final String DRIVER = ResourceUtil.getConfigByName("jdbc.driver");
    private final String URL = ResourceUtil.getConfigByName("jdbc.url");
    private final String USERNAME = ResourceUtil.getConfigByName("jdbc.username");
    private final String PASSWORD = ResourceUtil.getConfigByName("jdbc.password");

    /*
     * Mybatis加载步骤 SqlSessionFactoryBeanBuilder.builder() -》SqlSessionFactory.openSession() -》SqlSession
     * 代码步骤 将数据源DataSource注入到容器中-》通过传入数据源与Mybatis.xml文件生成SqlSessionFactory
     * 这里需要注意的是由于SqlSessionFactoryBean类内部已经，
     * 帮我们实例化了SqlSessionFactoryBeanBuilder，
     * 且在afterPropertiesSet()方法内对传入的数据源与配置文件进行了校验是否为空，
     * 不为空则调用buildSqlSessionFactory()方法来生成SqlSessionFactory
     */

    /**
     * 配置数据连接池 创建数据源Bean
     * @return DataSource
     */
    @Bean
    public DataSource getDataSource() {

        //配置DruidDataSource来生成数据源 由于DruidDataSource的父类DruidAbstractDataSource内实现了DataSource接口所以类型匹配
        DruidDataSource dataSource = new DruidDataSource();
        //数据库驱动
        dataSource.setDriverClassName(DRIVER);
        //数据库链接
        dataSource.setUrl(URL);
        //数据库用户名
        dataSource.setUsername(USERNAME);
        //数据库密码
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }

    /**
     * 生成 SqlSessionFactory
     * @return FactoryBean<SqlSessionFactory>
     */
    @Bean
    public FactoryBean<SqlSessionFactory> getSqlSessionFactory() {

        //该对象用于构建SqlSessionFactory是SqlSessionFactory的一个Bean (豆子) 也可以看作是一个黑盒提供各种便利的接口
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        //获取数据源
        factory.setDataSource(this.getDataSource());
        //导入mybatis配置文件 该配置文件其实也可以使用配置类来进行配置并传入但这两者只能选其一，
        //具体可以看afterPropertiesSet()方法对Configuration和ConfigLocation的校验
        factory.setConfigLocation(new ClassPathResource("config/mybatis-config.xml"));
        /*
         * FactoryBean也可以用于创建Bean但内部提供了更复杂的用法，如getObject方法，使实现类可以在Bean生成之前对其做一些操作.
         * 具体例子可以进入SqlSessionFactoryBean类中查看其中重写的getObject方法。
         */
        return factory;
    }

    /**
     * 事务管理
     * @return TransactionManager
     */
    @Bean
    public TransactionManager getTrans() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();

        //对数据源进行事务管理
        transactionManager.setDataSource(this.getDataSource());

        return transactionManager;
    }


}
