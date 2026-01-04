package com.example.contextdbchat.Configurations;

import com.example.contextdbchat.Models.Customer;
import com.example.contextdbchat.Repositories.ChatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/*
@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner initDatabase(ChatRepository repository) {
        return args -> {
            // Only load data if the repository is empty
            if (repository.count() == 0) {
                List<Customer> customers = Arrays.asList(
                        new Customer("John Doe", 5, "Wireless Headphones",
                                "john@example.com", 250, "2023-01-15"),
                        new Customer("Jane Smith", 12, "Smart Watch",
                                "jane@example.com", 500, "2022-08-22"),
                        new Customer("Bob Johnson", 3, "Laptop Sleeve",
                                "bob@example.com", 75, "2023-11-30"),
                        new Customer("Alice Williams", 8, "Bluetooth Speaker",
                                "alice@example.com", 400, "2023-03-10"),
                        new Customer("Charlie Brown", 15, "Tablet",
                                "charlie@example.com", 750, "2021-12-05"),
                        new Customer("Diana Prince", 7, "Gaming Mouse",
                                "diana@example.com", 350, "2023-05-18")
                );

                repository.saveAll(customers);
                System.out.println("Loaded " + customers.size() + " sample customers into database");
            }
        };
    }
}
*/
