package com.ants.starter.dubbo;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
* @Description: dubbo 自动配置类
* @author smatiger
* @date 2017年4月24日 下午3:05:57 
*/
@Configuration
@EnableConfigurationProperties(DubboProperties.class)
public class DubboAutoConfiguration {

    @Resource
    private DubboProperties dubboProperties;

    @Bean
    public ApplicationConfig requestApplicationConfig() {
        return dubboProperties.getApplication();
    }

    @Bean
    public RegistryConfig requestRegisryConfig() {
        return dubboProperties.getRegistry();
    }

    public ProtocolConfig requestProtocolConfig() {
        return dubboProperties.getProtocol();
    }

}
