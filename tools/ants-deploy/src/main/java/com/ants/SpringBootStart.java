/*   
  * qccr.com Inc.
  * Copyright (c) 2014-2018 All Rights Reserved.
 */ 
package com.ants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
* @Description: spring-boot 启动类  
* 
*     启动类需要放在根目录下，@ComponentScan注解回扫描当前类下的所有子目录
*   
* @author smatiger
* @date 2017年3月21日 下午5:35:55 
*/
@EnableAutoConfiguration
@ComponentScan
public class SpringBootStart {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStart.class, args);
    }

}
