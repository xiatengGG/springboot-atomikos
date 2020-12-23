package com.xiateng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// exclude = {DataSourceAutoConfiguration.class} 排除主动注入数据源
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableTransactionManagement // 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
//自动扫描包路径下面的所有@Controller、@Service、@Repository、@Component 的类，
// 并把符合扫描规则的类装配到spring容器中。
@ComponentScan(basePackages = {"com.xiateng"})
// 原来扫描dao层接口
//@MapperScan({"com.xiateng.dao.user","com.xiateng.dao.userbuyer"})
public class Application extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
