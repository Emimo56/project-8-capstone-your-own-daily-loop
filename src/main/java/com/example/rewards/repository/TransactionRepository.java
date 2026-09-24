package com.example.rewards.repository;
import com.example.rewards.model.Transaction; import java.util.List;
public interface TransactionRepository { List<Transaction> findAll(); }
