package com.example.rewards.controller;
import com.example.rewards.dto.CustomerRewardsResponse; import com.example.rewards.model.Transaction; import com.example.rewards.service.RewardsService; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.time.YearMonth; import java.util.List;
@RestController public class RewardsController { private final RewardsService rewardsService; public RewardsController(RewardsService r){rewardsService=r;}
 @GetMapping("/rewards") public List<CustomerRewardsResponse> getRewardsForAllCustomers(){return rewardsService.getRewardsForAllCustomers();}
 @GetMapping("/rewards/{customerId}") public CustomerRewardsResponse getRewardsForCustomer(@PathVariable String customerId){return rewardsService.getRewardsForCustomer(customerId);}
 @GetMapping("/transactions") public List<Transaction> getTransactions(@RequestParam(required=false) String customerId,@RequestParam(required=false) String startMonth,@RequestParam(required=false) String endMonth){return rewardsService.getTransactions(customerId,parseMonth(startMonth,"startMonth"),parseMonth(endMonth,"endMonth"));}
 private YearMonth parseMonth(String month,String name){if(month==null||month.isBlank())return null;try{return YearMonth.parse(month);}catch(Exception e){throw new IllegalArgumentException(name+" must use YYYY-MM format");}}
 @ResponseStatus(HttpStatus.BAD_REQUEST) @ExceptionHandler(IllegalArgumentException.class) public ErrorResponse handleBadRequest(IllegalArgumentException e){return new ErrorResponse(e.getMessage());}
 public record ErrorResponse(String message){}
}
