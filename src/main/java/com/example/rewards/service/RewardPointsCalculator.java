package com.example.rewards.service;
import org.springframework.stereotype.Service; import java.math.BigDecimal;
@Service public class RewardPointsCalculator { private static final BigDecimal FIFTY=new BigDecimal("50"), ONE_HUNDRED=new BigDecimal("100"), TWO=new BigDecimal("2");
 public int calculateRewardPoints(BigDecimal transactionAmount){ if(transactionAmount==null||transactionAmount.compareTo(FIFTY)<0)return 0; if(transactionAmount.compareTo(ONE_HUNDRED)<=0)return transactionAmount.subtract(FIFTY).intValue(); return 50+transactionAmount.subtract(ONE_HUNDRED).multiply(TWO).intValue(); }
}
