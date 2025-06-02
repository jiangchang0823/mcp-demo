package com.iss.mcpdemo;

import com.iss.mcpdemo.service.CourseService;
import com.iss.mcpdemo.service.IMcpProviderService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallback;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpDemoApplication {

    @Autowired
    private List<IMcpProviderService> toolsProviderServices;

    public static void main(String[] args) {
        SpringApplication.run(McpDemoApplication.class, args);
    }


//    @Bean
//    public List<ToolCallback> getToolCallbacks(CourseService courseService) {
//        return List.of(ToolCallbacks.from(courseService));
//    }

    @Bean
    public ToolCallbackProvider getToolCallbacks(CourseService courseService) {
//        return List.of(ToolCallbacks.from(courseService));
        return MethodToolCallbackProvider.builder().toolObjects(toolsProviderServices.toArray()).build();
    }

}
