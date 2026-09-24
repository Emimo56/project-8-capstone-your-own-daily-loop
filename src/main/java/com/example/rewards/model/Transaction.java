package com.example.rewards.model;
import java.math.BigDecimal; import java.time.LocalDate;
public record Transaction(String transactionId,String customerId,String customerName,LocalDate transactionDate,BigDecimal transactionAmount) {}
