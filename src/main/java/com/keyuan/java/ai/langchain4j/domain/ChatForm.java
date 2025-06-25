package com.keyuan.java.ai.langchain4j.domain;

import lombok.Data;

@Data
public class ChatForm {
    private Long memoryId;//对话id
    private String message;
}
