package springmvc_ensa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan("springmvc_ensa.controller")
public class WebConfig {
@Bean
    InternalResourceViewResolver viewResolver(){
       InternalResourceViewResolver internalResourceViewResolver =new InternalResourceViewResolver();
       internalResourceViewResolver.setSuffix(".jsp");
    internalResourceViewResolver.setPrefix("/WEB-INF/views/customer/");

    return internalResourceViewResolver;


    }


}
