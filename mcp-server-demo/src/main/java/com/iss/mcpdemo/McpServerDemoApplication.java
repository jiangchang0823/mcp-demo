package com.iss.mcpdemo;

import com.iss.mcpdemo.service.IMcpProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class McpServerDemoApplication {

    @Autowired
    private List<IMcpProviderService> toolsProviderServices;

    public static void main(String[] args) {
        SpringApplication.run(McpServerDemoApplication.class, args);
    }

}
