package com.example.demo;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DBConfig {

    @Bean(destroyMethod="close")
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/jdbctest?characterEncoding=utf8&serverTimezone=Asia/Seoul");
        ds.setUsername("root");
        ds.setPassword("Ga3785yj)!!#");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setMaxIdle(10);

        System.out.println("testing1");
        return ds;
    }

    @Bean
    public DBQuery dbQuery(){
        System.out.println("hi");
        return new DBQuery(dataSource());
    }

    @Bean
    public HomeController helloController() {
        return new HomeController();
    }

}
