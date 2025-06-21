package com.keyuan.java.ai.langchain4j;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;


public class langChain4JTest {

    @Test
    public void testLangChain4j() {
        // This is a placeholder for the actual test implementation.
        // You can add your test logic here.
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();

        String answer = model.chat("Hello, how are you?");
        System.out.println(answer);
    }
}
