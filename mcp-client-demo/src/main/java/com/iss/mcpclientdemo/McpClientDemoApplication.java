package com.iss.mcpclientdemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class McpClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpClientDemoApplication.class, args);
    }


    @Autowired
    private ChatClient chatClient;
    @Bean
    public CommandLineRunner interactiveChatRunner(

            ConfigurableApplicationContext context
    ) {
        return args -> {

            Scanner scanner = new Scanner(System.in); // 用于读取控制台输入

            System.out.println("=== 聊天模式已启动（输入 'exit' 退出） ===");

            while (true) {
                System.out.print("\n>>> 你的问题: ");
                String userInput = scanner.nextLine().trim();

                // 输入 "exit" 退出聊天
                if ("exit".equalsIgnoreCase(userInput)) {
                    System.out.println(">>> 聊天结束，程序退出。");
                    break;
                }

                // 空输入则跳过
                if (userInput.isEmpty()) {
                    continue;
                }

                // 调用 AI 并打印回复
                 System.out.println("\n>>> AI 回复: " + chatClient.prompt(userInput).call().content());

                // 将 chatClient.prompt(userInput).stream().content(); 返回的结果流式打印
//                chatClient.prompt(userInput).stream().content().subscribe(System.out::print);
            }

            context.close(); // 关闭 Spring 上下文
        };
    }


}
