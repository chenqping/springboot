package org.example.bookpub;

//import org.apache.catalina.filters.RemoteIpFilter;
import org.example.bookpub.formatters.BookFormatter;
import org.example.bookpub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.time.Duration;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
/*    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }*/

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        return new LocaleChangeInterceptor();
    }

    @Bean
    public ServletWebServerFactory servletContainer(){
/*        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.getSession().setTimeout(Duration.ofMinutes(1));*/
        JettyServletWebServerFactory jetty = new JettyServletWebServerFactory();
        jetty.getSession().setTimeout(Duration.ofMinutes(1));
        return jetty;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Autowired
    private BookRepository bookRepository;
    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addFormatter(new BookFormatter(bookRepository));
    }

    @Override
    public  void configurePathMatch(PathMatchConfigurer configurer){
        configurer.setUseSuffixPatternMatch(false).setUseTrailingSlashMatch(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/internal/**").addResourceLocations("classpath:/");
    }
}
