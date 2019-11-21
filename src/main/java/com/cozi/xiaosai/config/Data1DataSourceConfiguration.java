package com.cozi.xiaosai.config;

/**
 * @Author xiaosai
 * @Date 2019-11-21 13:47
 * @Version 1.0
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 从数据库
 * sql session工厂配置
 */
@Configuration
@MapperScan(basePackages = {"com.cozi.xiaosai.mapper.dataOrigin1"},sqlSessionFactoryRef = "data1SqlSessionFactory")
public class Data1DataSourceConfiguration {
    /**
     * mybatis的xml文件夹
     */
    public static final  String MAPPER_XML_LOCATIONS= "classpath*:mapper/dataOrigin1/**/*.xml";

    @Autowired
    @Qualifier("Data1DataSource")
    DataSource data1Source;

    /**
     * 配置sql session模板
     * @return
     */
    @Bean
    public SqlSessionTemplate springSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(data1SqlSessionFactory());
    }

    /**
     * 配置 sql session工厂
     * @return
     */
    @Bean
    public SqlSessionFactory data1SqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(data1Source);
        //注意：这里是通过路径找到所有匹配的xml,不是一个getResources（）
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATIONS));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置事务
     * @return
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(data1Source);
    }
}
