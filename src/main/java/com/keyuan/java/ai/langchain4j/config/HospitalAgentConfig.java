package com.keyuan.java.ai.langchain4j.config;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HospitalAgentConfig {

    @Bean
    public ChatMemoryProvider hospitalChatMemoryProvider(){
        return memoryId -> MessageWindowChatMemory.builder().id(memoryId).maxMessages(10).build();
    };
}
