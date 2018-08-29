package com.yao.microservicefileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceFileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceFileUploadApplication.class, args);
    }
}
