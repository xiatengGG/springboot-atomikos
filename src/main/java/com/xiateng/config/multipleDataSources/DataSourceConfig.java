package com.xiateng.config.multipleDataSources;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import javax.sql.XADataSource;

@Configuration
public class DataSourceConfig {

    // 将这个对象放入spring容器中（交给Spring管理）
    @Bean
    // 读取 application.yml 中的配置参数映射成为一个对象
    @ConfigurationProperties(prefix = "spring.datasource.pre")
    public XADataSource getDataSource1(){
        // 创建XA连接池
        return new MysqlXADataSource();
    }

    /**
     * 创建Atomikos数据源
     * 注解@DependsOn("druidXADataSourcePre")，在名为druidXADataSourcePre的bean实例化后加载当前bean
     * @param xaDataSource
     * @return
     */
    @Bean
    @DependsOn("getDataSource1")
    @Primary
    public DataSource dataSourcePre(@Qualifier("getDataSource1") XADataSource xaDataSource){
        //这里的AtomikosDataSourceBean使用的是spring提供的
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);
        return atomikosDataSourceBean;
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.sit")
    public XADataSource getDataSource2(){
        // 创建XA连接池
        return new MysqlXADataSource();
    }

    @Bean
    @DependsOn("getDataSource2")
    public DataSource dataSourceSit(@Qualifier("getDataSource2") XADataSource xaDataSource){
        //这里的AtomikosDataSourceBean使用的是spring提供的
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);
        return atomikosDataSourceBean;
    }
}
