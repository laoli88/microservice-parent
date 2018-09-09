package com.yao.microservicesimpleprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceSimpleProviderUserApplication {

    public static void main(String[] args) {

        SpringApplication.run(MicroserviceSimpleProviderUserApplication.class, args);
    }
}
