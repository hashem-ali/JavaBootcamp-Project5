package com.example.project_5.Controllers;

import com.example.project_5.Models.Customer;
import com.example.project_5.Services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
//    private final Customer customer;
//
    @GetMapping("get")
    public ResponseEntity geCustomer()
    {
        List<Customer> customerList = customerService.getCustomer();
        return ResponseEntity.status(200).body(customerList);
    }

    @PostMapping("add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer)
    {
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer added!");
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer)
    {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("Customer updated!");
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id)
    {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer delete!");
    }

    @PutMapping("{customerId}/store/{storeId}")
    public ResponseEntity assignCustomerToStore(@PathVariable Integer storeId,@PathVariable Integer customerId){
        customerService.assignCustomerToStore(storeId, customerId);
        return ResponseEntity.status(200).body("Assigned Successfully");
    }
    @PutMapping("allCustomers/{storeId}")
    public ResponseEntity allCustomersByStoreId(@PathVariable Integer storeId){
        return ResponseEntity.status(200).body(customerService.getCustomerByStoreId(storeId));
    }
}
