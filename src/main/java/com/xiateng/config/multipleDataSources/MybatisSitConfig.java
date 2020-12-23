package com.xiateng.config.multipleDataSources;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 数据源Config1
 */
@Configuration
@MapperScan(basePackages = {"com.xiateng.dao.userbuyer"}, sqlSessionTemplateRef = "sitSqlSessionTemplate")
public class MybatisSitConfig {

    @Autowired
    @Qualifier("dataSourceSit")
    private DataSource dataSource;

    /**
     * 创建 SqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean
    @Primary
    public SqlSessionFactory sitSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 设置mybatis的xml所在位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath*:com/xiateng/mapper/userbuyer/*.xml"));
        return bean.getObject();
    }

    /**
     * 通过 SqlSessionFactory 来创建 SqlSessionTemplate
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    @Primary
    public SqlSessionTemplate sitSqlSessionTemplate(@Qualifier("sitSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        // SqlSessionTemplate是线程安全的，可以被多个DAO所共享使用
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
