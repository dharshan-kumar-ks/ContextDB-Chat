package com.example.contextdbchat.Repositories;

import com.example.contextdbchat.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Customer, Long> {

}
