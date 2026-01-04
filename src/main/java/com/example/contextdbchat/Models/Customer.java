package com.example.contextdbchat.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "total_orders")
    private Integer totalOrders;

    @Column(name = "most_recent_purchase")
    private String mostRecentPurchase;

    @Column(name = "email")
    private String email;

    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;

    @Column(name = "customer_since")
    private String customerSince; // Could be LocalDate in production
}
