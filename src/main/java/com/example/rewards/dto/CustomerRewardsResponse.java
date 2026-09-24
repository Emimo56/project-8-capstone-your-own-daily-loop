package com.example.rewards.dto;
import com.example.rewards.model.MonthlyReward; import java.util.List;
public record CustomerRewardsResponse(String customerId,String customerName,List<MonthlyReward> monthlyRewards,int totalRewardPoints) {}
