package com.cozi.xiaosai.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author xiaosai
 * @Date 2019-11-21 13:35
 * @Version 1.0
 */

/**
 * 数据源配置类
 */
@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfiguration {
    //主库前缀
    final static String DATA_PREFIX = "spring.datasource.druid.data";

    //从库前缀
    final static String DATA1_PREFIX = "spring.datasource.druid.data1";

    /**
     * 配置主库数据源
     * @return
     */
    @Primary
    @Bean(name = "DataDataSource")
    @ConfigurationProperties(prefix = DATA_PREFIX)
    public DataSource dataDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 配置从库数据源
     * @return
     */
    @Bean(name = "Data1DataSource")
    @ConfigurationProperties(prefix = DATA1_PREFIX)
    public DataSource data1DataSource(){
        return DruidDataSourceBuilder.create().build();
    }

}
