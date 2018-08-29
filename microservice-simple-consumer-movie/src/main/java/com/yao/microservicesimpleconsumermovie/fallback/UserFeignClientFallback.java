package com.yao.microservicesimpleconsumermovie.fallback;

import com.yao.microservicesimpleconsumermovie.api.UserFeignClient;
import com.yao.microservicesimpleconsumermovie.entity.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 　　　　　　　 ┏┓　 ┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　┃
 * 　　　　　　　┃　　　━　　 ┃ ++ + + +
 * 　　　　　　 ████━████  ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　 ┃　　　┃
 * 　　　　　　　　 ┃　　　┃ + + + +
 * 　　　　　　　　 ┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　 ┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　 ┃　　　┃
 * 　　　　　　　　 ┃　　　┃　　+
 * 　　　　　　　　 ┃　 　 ┗━━━┓ + +
 * 　　　　　　　　 ┃ 　　　　   ┣┓
 * 　　　　　　　　 ┃ 　　　　　 ┏┛
 * 　　　　　　　　 ┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　  ┃┫┫ ┃┫┫
 * 　　　　　　　　  ┗┻┛ ┗┻┛+ + + +
 *
 * @program: microservice-parent
 * @description: UserFeignClient的回退方法
 * @author: YaoYY
 * @create: 2018-08-21 22:32
 */

@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        System.err.println("熔断方法执行");
        User user = new User(id,"", "username", -1, new BigDecimal(22), null);
        return user;
    }

    @Override
    public String h(User user) {
        return null;
    }
}
