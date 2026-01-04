package com.example.contextdbchat.Controllers;

import com.example.contextdbchat.DTOs.QueryRequest;
import com.example.contextdbchat.DTOs.QueryResponse;
import com.example.contextdbchat.Services.ChatService;
import org.hibernate.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {
    ChatService chatService;
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    /*
    POST /api/chat
     */
    @PostMapping("/chat")
    public ResponseEntity<QueryResponse> getChatResponse(@RequestBody QueryRequest request) {
        try {
            String response = chatService.getChatResponse(request.getQuery());
            return ResponseEntity.ok(new QueryResponse(response));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new QueryResponse("Error: " + e.getMessage()));
        }
    }

    // POST /api/chat
    @GetMapping("/test")
    public ResponseEntity<QueryResponse> getTestResponse() {
        try {
            String response = chatService.getTestResponse();
            return ResponseEntity.ok(new QueryResponse(response));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new QueryResponse("Error: " + e.getMessage()));
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Chatbot API is running");
    }

}
