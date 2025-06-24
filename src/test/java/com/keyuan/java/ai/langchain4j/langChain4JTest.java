package com.keyuan.java.ai.langchain4j;

import com.keyuan.java.ai.langchain4j.assistant.Assistant;
import com.keyuan.java.ai.langchain4j.assistant.DotaAnalysisAgent;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class langChain4JTest {
    @Autowired
    private QwenChatModel qwenChatModel;

    @Autowired
    private DotaAnalysisAgent analysisAgent;

    @Autowired
    private Assistant assistant;

//    @Test
//    public void testLangChain4j() {
//        // This is a placeholder for the actual test implementation.
//        // You can add your test logic here.
//        OpenAiChatModel model = OpenAiChatModel.builder()
//                .baseUrl("http://langchain4j.dev/demo/openai/v1")
//                .apiKey("demo")
//                .modelName("gpt-4o-mini")
//                .build();
//
//        String answer = model.chat("Hello, how are you?");
//        System.out.println(answer);
//    }
    @Test
    public void testQwenChatModel() {
        String answer = qwenChatModel.chat("Hello, how are you?");
        System.out.println(answer);
    }

    @Test
    public void testCreateAiService() {
        String answer1 = assistant.chat(1, "My name is Keyuan?");
        String answer3 = assistant.chat(1, "What is my name?");
        String answer2 = assistant.chat(2, "What is the weather like today?");
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
    }

    @Test
    public void testDotaAnalysisAgent() {
        String answer = analysisAgent.analysisHero(1, "Give me analysis of the hero in Dota 2, including his strengths, and weaknesses.", "Kunkka");
        System.out.println(answer);
    }
}
