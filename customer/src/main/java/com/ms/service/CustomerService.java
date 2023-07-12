package com.ms.service;

import com.ms.model.Customer;
import com.ms.repo.CustomerRepository;
import com.ms.request.CustomerRequest;
import com.ms.request.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {

     public void registerCustomer(CustomerRequest request){
         Customer customer = Customer.builder()
                 .firstName(request.firstName())
                 .lastName(request.lastName())
                 .email(request.email())
                 .build();
         //todo validate email
         customerRepository.saveAndFlush(customer);

         var data = restTemplate.getForObject(
                 "http://FRAUD/api/v1/fraud-check/{customerId}",
                 FraudCheckResponse.class,
                 customer.getId()
         );
         if (data.isFraud()){
             throw new IllegalStateException("fraud");
         }
     }

}
