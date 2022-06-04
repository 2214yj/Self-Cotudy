package config;


import controller.DBQuery;
import controller.HomeController;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;


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

        return ds;
    }

    @Bean
    public DBQuery dbQuery() throws SQLException {
        return new DBQuery(dataSource());
    }

    @Bean
    public HomeController helloController() {
        System.out.println("test");
        return new HomeController();
    }

}
