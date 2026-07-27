package com.example.InterceptorDemo.config;

import com.example.InterceptorDemo.interceptor.AuthenticationInterceptor;
import com.example.InterceptorDemo.interceptor.AuthorizationInterceptor;
import com.example.InterceptorDemo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptor loggingInterceptor;

    public AuthenticationInterceptor authenticationInterceptor;

    public AuthorizationInterceptor authorizationInterceptor;

    public WebConfig(LoggingInterceptor loggingInterceptor,
                     AuthenticationInterceptor authenticationInterceptor,
                     AuthorizationInterceptor authorizationInterceptor){
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor((authenticationInterceptor))
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login", "/api/public/**")

                .order(1).order(2);


        registry.addInterceptor(loggingInterceptor).order(1);
        registry.addInterceptor(authenticationInterceptor).order(2);
        registry.addInterceptor(authorizationInterceptor);

    }

}
