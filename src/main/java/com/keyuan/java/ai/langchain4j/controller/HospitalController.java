package com.keyuan.java.ai.langchain4j.controller;

import com.keyuan.java.ai.langchain4j.assistant.HospitalAgent;
import com.keyuan.java.ai.langchain4j.domain.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalAgent hospitalAgent;

    @Operation(summary = "对话")
    @PostMapping("/chat")
    public String chat(@RequestBody ChatForm chatForm) {
        return hospitalAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }

}
