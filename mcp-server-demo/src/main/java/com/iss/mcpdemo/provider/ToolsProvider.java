package com.iss.mcpdemo.provider;

import com.iss.mcpdemo.service.IMcpProviderService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ToolsProvider {

    @Autowired
    private List<IMcpProviderService> toolsProviderServices;

    @Bean
    public ToolCallbackProvider provideToolCallbackProvider() {
        return MethodToolCallbackProvider.builder().toolObjects(toolsProviderServices.toArray()).build();
    }
}
