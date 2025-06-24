package com.keyuan.java.ai.langchain4j.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTools {

    @Tool(name = "add", value = "Adds two numbers together.")
    public double add(
            @P(value = "加数1", required = true) double a,
            @P(value = "加数2", required = true) double b) {
        return a + b;
    }

    @Tool
    public double squareRoot(double a) {
        return Math.sqrt(a);
    }
}
