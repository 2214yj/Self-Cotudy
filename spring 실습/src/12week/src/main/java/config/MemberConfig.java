package config;


import Spring.MemberDao;
import Spring.MemberService;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class MemberConfig {

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
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());
        return tm;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberDao());
    }

}
