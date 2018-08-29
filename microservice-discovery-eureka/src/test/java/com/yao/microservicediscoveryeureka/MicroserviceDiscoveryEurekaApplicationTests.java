package com.yao.microservicediscoveryeureka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("eureka2")
public class MicroserviceDiscoveryEurekaApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    EurekaInstanceConfigBean eurekaInstanceConfigBean;
    @Test
    public void contextLoads() {
        EurekaClientConfigBean eurekaClientConfigBean = (EurekaClientConfigBean) applicationContext.getBean("eurekaClientConfigBean");
        Map<String, String> serviceUrl = eurekaClientConfigBean.getServiceUrl();
        eurekaInstanceConfigBean.getHostname();
    }

}
