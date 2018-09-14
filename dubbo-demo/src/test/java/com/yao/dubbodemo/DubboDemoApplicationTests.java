package com.yao.dubbodemo;

import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboDemoApplicationTests {

    @Autowired
    RegistryConfig registryConfig;

    @Reference(version = "1.0", group = "normal", timeout = 30000)
    com.deppon.nhr.module.vacation.server.service.SyncWorkFlowService syncWorkFlowService;

    @Test
    public void contextLoads() {
        String s = "\"INHR119180831611850\"";
        syncWorkFlowService.judgeState(s);
    }

}
