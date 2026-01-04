package com.example.contextdbchat.Services;

import com.example.contextdbchat.DTOs.QueryRequest;
import com.example.contextdbchat.DTOs.QueryResponse;
import com.example.contextdbchat.Models.Customer;
import com.example.contextdbchat.Repositories.ChatRepository;
import lombok.Value;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ChatService {
    private final ChatClient chatClient;
    //private final ChatRepository chatRepository;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    // For /api/chat endpoint
    public String getChatResponse(String userQuery) {
        try {
            String response = chatClient.prompt()
                    .system("You are a helpful customer service assistant.")
                    .user(userQuery)
                    .call()
                    .content();

            return response;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // For /api/test endpoint - simple hardcoded prompt
    public String getTestResponse() {
        try {
            String response = chatClient.prompt()
                    .system("You are a helpful assistant.")
                    .user("What is today's date and time? Are there any special events or holidays today?")
                    .call()
                    .content();

            return response;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // POST /api/chat
    // 1. Fetch data from DB.
    // 2. Convert that data into a String (JSON or CSV format).
    // 3. Use Spring AI's ChatClient to send the context + question to the LLM.
    /*
    public QueryResponse getResponse(QueryRequest request) {
        // Generate or use provided session ID
        String sessionId = request.getSessionId() != null ?
                request.getSessionId() :
                UUID.randomUUID().toString();

        try {
            // 1. Fetch all customers data from the DB
            List<Customer> customers = chatRepository.findAll();

            // 2. Create structured context from the data
            String customerContext = createCustomerContext(customers);

            // 3. Create a more sophisticated prompt with clear instructions
            String systemPrompt = createSystemPrompt();

            // 4. Use PromptTemplate for better structure
            PromptTemplate promptTemplate = new PromptTemplate("""
                {systemPrompt}
                
                Available Customer Data:
                {customerContext}
                
                Question: {userQuery}
                
                Please analyze the customer data and provide a helpful response.
                If the question cannot be answered with the available data, say so clearly.
                """);

            Map<String, Object> promptVariables = new HashMap<>();
            promptVariables.put("systemPrompt", systemPrompt);
            promptVariables.put("customerContext", customerContext);
            promptVariables.put("userQuery", request.getQuery());

            Prompt prompt = promptTemplate.create(promptVariables);

            // 5. Get response from LLM
            String llmResponse = chatClient.call(prompt).getResult().getOutput().getContent();

            // 6. Return response
            return new QueryResponse(llmResponse, sessionId);

        } catch (Exception e) {
            // Handle errors gracefully
            return new QueryResponse(
                    "I apologize, but I encountered an error processing your request. " +
                            "Please try again or contact support if the issue persists.",
                    sessionId
            );
        }
    }
    */



}
