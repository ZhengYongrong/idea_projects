package com.example.music.config;

import com.example.music.interceptor.AccessInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private AccessInterceptor accessInterceptor;
    //跨域允许的方法
    static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };

    @Override
    //把拦截器Interceptor注册到springboot中
    public void addInterceptors(InterceptorRegistry registry) {
        String interceptPath = "/**";
        //注册拦截器
        InterceptorRegistration loginIR = registry.addInterceptor(accessInterceptor);
        //配置拦截路径
        loginIR.addPathPatterns(interceptPath);
        //配置不拦截路径
        loginIR.excludePathPatterns("/song/songName").excludePathPatterns("/song/ranking");
        //注册其他拦截器
        //InterceptorRegistration permissionIR = registry.addInterceptor(accessInterceptor);
        //配置拦截路径
        //permissionIR.addPathPatterns(interceptPath);
        //配置不拦截路径
        //permissionIR.excludePathPatterns("");

    }

    @Override
    //解决跨域
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods(ORIGINS)
                .maxAge(3600);
    }

    /*配置静态虚拟路径*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/image/**").addResourceLocations("file:D:\\images\\");
    }
}