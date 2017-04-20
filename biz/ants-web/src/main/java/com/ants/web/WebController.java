package com.ants.web;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WebController {

    //    @Resource
    //    private TestService testService;

    @RequestMapping("/hello")
    //    @ResponseBody
    public String hello() {
        return "hello, spring boot!";// + testService.getName();
        //运行之后在浏览器中访问：http://localhost:8080/hello
    }

    @RequestMapping("/hi")
    public String hi(Map<String, Object> model) {
        System.out.println(System.currentTimeMillis() + "---hi");
        model.put("time", System.currentTimeMillis());
        model.put("message", "这是测试的内容。。。");
        model.put("toUserName", "张三");
        model.put("fromUserName", "老许");
        return "welcome"; //自动寻找resources/templates中名字为welcome.ftl/welcome.vm的文件作为模板，拼装后返回
    }

    @RequestMapping("/favicon.ico")
    public String favicon() {
        return "resource/ico/favicon.png";
    }
}
