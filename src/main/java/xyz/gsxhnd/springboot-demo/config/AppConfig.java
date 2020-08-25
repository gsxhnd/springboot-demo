package xyz.gsxhnd.springboot-demo.config;

import xyz.gsxhnd.springboot-demo.Interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author jimo
 * @func 设置支持跨域和公开URL
 * @date 2018/8/24 22:37
 */
@Configuration
public class AppConfig extends WebMvcConfigurationSupport {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        System.out.println("cors mapping");
//        //允许全部请求跨域
//        registry.addMapping("/**")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .allowedOrigins("*");
//    }
//
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("interceptor");
        //添加拦截器
        registry.addInterceptor(new JWTInterceptor()).addPathPatterns("/**")
                // 后台管理 登录接口
                .excludePathPatterns("/api/v1/admin/user/login")
                // 小程序展示接口
                .excludePathPatterns("/api/v1/front/**");
    }
}