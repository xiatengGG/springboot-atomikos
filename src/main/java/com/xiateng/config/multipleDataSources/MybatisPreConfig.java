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
 * 数据源Config2
 */
@Configuration
@MapperScan(basePackages = {"com.xiateng.dao.user"}, sqlSessionTemplateRef = "preSqlSessionTemplate")
public class MybatisPreConfig {

    @Autowired
    // @Qualifier表示查找Spring容器中名字为 preDataSource 的对象
    @Qualifier("dataSourcePre")
    private DataSource dataSource;

    /**
     * 创建 SqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean
    @Primary
    public SqlSessionFactory preSqlSessionFactory() throws Exception{
        // 用来创建 SqlSessionFactory 等同于下面配置
//        <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
//            <property name="dataSource" ref="dataSource" />
//            <property name="mapperLocations" value="classpath:mybatis-mapper/*.xml"/>
//        </bean>
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 设置mybatis的xml所在位置(扫描mybatis的相关xml文件，装配到容器中)
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath*:com/xiateng/mapper/user/*.xml"));
        return bean.getObject();
    }

    /**
     * 通过 SqlSessionFactory 来创建 SqlSessionTemplate
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    @Primary
    public SqlSessionTemplate preSqlSessionTemplate(@Qualifier("preSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        // SqlSessionTemplate是线程安全的，可以被多个DAO所共享使用
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
