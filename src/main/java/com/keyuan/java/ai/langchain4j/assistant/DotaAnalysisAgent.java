package com.keyuan.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "calculatorTools"
)
public interface DotaAnalysisAgent {

    @SystemMessage(fromResource = "dota-analysis-agent.txt")
    @UserMessage("{{userMessage}}" + "{{heroName}}")
    String analysisHero(@MemoryId int memoryId, @V("userMessage") String userMessage, @V("heroName") String dotaHeroData);
}
