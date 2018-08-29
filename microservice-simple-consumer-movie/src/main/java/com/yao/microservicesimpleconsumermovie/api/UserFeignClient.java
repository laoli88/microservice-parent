package com.yao.microservicesimpleconsumermovie.api;

import com.yao.microservicesimpleconsumermovie.entity.User;
import com.yao.microservicesimpleconsumermovie.fallback.UserFeignClientFactoryFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author tuzki
 */
@FeignClient(value = "PROVIDER-USER", fallbackFactory = UserFeignClientFactoryFallback.class)
public interface UserFeignClient {

    /**
     * @Description:
     * @Param:  * @param id :  用户id
     * @return:  * @return : com.yao.microservicesimpleconsumermovie.entity.User
     * @Author: YaoYY
     * @Date: 2018-08-22 21:47
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    String h(@RequestBody User user);
}
