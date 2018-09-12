package com.yao.microservicesimpleconsumermovie.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yao.microservicesimpleconsumermovie.api.UserFeignClient;
import com.yao.microservicesimpleconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserFeignClient userFeignClient;

    @Value("${server.port}")
    private Integer port;
    @Value("${customize}")
    private String customize;
    
    /** 
     * @Description: 从git上获取customize的值并打印出去
     * @Param: [] 
     * @Return: java.lang.String
     * @Author: YaoYY 
     * @Date: 2018/8/31 
     */ 
    @GetMapping("getCustomize")
    public String getCstomize() {
        return customize;
    }

    /**
     * @Description: 看看能不能从码云上拿到配置
     * @Param: []
     * @return: java.lang.String
     * @Author: YaoYY
     * @Date: 2018/8/30
     */
    @GetMapping("getPort")
    public String getPort() {
        return port.toString();
    }

    @GetMapping("{id}")
    public User findById(@RequestHeader(value = "yaoyy", required = false) String host, @PathVariable Long id) {
        System.err.println(host);
        return restTemplate.getForObject("http://PROVIDER-USER/"+id, User.class);
    }

    @GetMapping("feign/{id}")
    public Map<String, Object> feignTest(@PathVariable("id") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userFeignClient.findById(id);
        map.put("user", user);
        return map;
    }

    @PostMapping("save")
    public String saveUser(User user) {
        String msg = userFeignClient.h(user);
        return msg;
    }

    public User rongduan(Long id) {
        System.err.println("熔断方法执行");
        User user = new User(000L,"", "username", -1, new BigDecimal(22), null);
        return user;
    }
}
