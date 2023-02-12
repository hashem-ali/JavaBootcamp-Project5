package com.example.project_5.Services;

import com.example.project_5.ApiExceptions.ApiException;
import com.example.project_5.Models.Customer;
import com.example.project_5.Models.Store;
import com.example.project_5.Repositries.CustomerRepo;
import com.example.project_5.Repositries.StoreRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final StoreRepo storeRepo;
//    private final Customer customer;

     public List<Customer> getCustomer() {
        return customerRepo.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepo.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer1){
        Customer oldCustomer = customerRepo.getById(id);
        if(oldCustomer == null){
            throw new ApiException("Not found");
        }
        oldCustomer.setId(id);
        customerRepo.save(customer1);
    }

    public void deleteCustomer(Integer id){
        Customer oldCustomer = customerRepo.getById(id);
        if(oldCustomer == null){
            throw new ApiException("Not found");
        }
        customerRepo.deleteById(id);
    }
    public void assignCustomerToStore(Integer storeId, Integer customerId){
        Store store = storeRepo.getById(storeId);
        Customer customer = customerRepo.getById(customerId);
        if(store==null||customer==null) {
            throw new ApiException("Id not found!");
        }
        store.getCustomers().add(customer);
        customer.getStores().add(store);
        storeRepo.save(store);
        customerRepo.save(customer);
    }
    public List<String> getCustomerByStoreId(Integer storeId){
        Store store = storeRepo.getById(storeId);
        if(store == null){
            throw new ApiException("Not Found");
        }
        List<String> customersName = new ArrayList<>();

        for (Customer customer: store.getCustomers()) {
            customersName.add(customer.getName());
        }
        return customersName;
    }
}
