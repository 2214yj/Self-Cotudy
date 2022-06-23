package config;

import intercepter.AuthCheckIntercepter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public HandlerMapping handlerMapping() {
        RequestMappingHandlerMapping hm = new RequestMappingHandlerMapping();
        hm.setOrder(0);
        return hm;
    }

    @Bean
    public HandlerAdapter handlerAdapter() {
        RequestMappingHandlerAdapter ha = new RequestMappingHandlerAdapter();
        return ha;
    }

    @Bean
    public HandlerMapping simpleHandlerMapping() {
        SimpleUrlHandlerMapping hm = new SimpleUrlHandlerMapping();
        Map<String, Object> pathMap = new HashMap<>();
        pathMap.put("/**", defaultServletHandler());
        hm.setUrlMap(pathMap);
        return hm;
    }

    @Bean
    public HttpRequestHandler defaultServletHandler() {
        DefaultServletHttpRequestHandler handler = new DefaultServletHttpRequestHandler();
        return handler;
    }

    @Bean
    public HandlerAdapter requestHandlerAdapter() {
        HttpRequestHandlerAdapter ha = new HttpRequestHandlerAdapter();
        return ha;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/view/");
        vr.setSuffix(".jsp");
        return vr;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authCheckInterceptor())
                .addPathPatterns("/userInfo");
    }

    @Bean
    public AuthCheckIntercepter authCheckInterceptor() {
        return new AuthCheckIntercepter();
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms =
                new ResourceBundleMessageSource();
        ms.setBasenames("message.label");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

}
