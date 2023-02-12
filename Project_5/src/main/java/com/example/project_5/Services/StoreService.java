package com.example.project_5.Services;

import com.example.project_5.ApiExceptions.ApiException;
import com.example.project_5.Models.Store;
import com.example.project_5.Repositries.StoreRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepo storeRepo;
//    private final Store store;


    public List<Store> getStore() {
        return storeRepo.findAll();
    }

    public void addStore(Store store){
        storeRepo.save(store);
    }

    public void updateStore(Integer id, Store store1){
        Store oldStore = storeRepo.getById(id);
        if(oldStore == null){
            throw new ApiException("Not found");
        }
        oldStore.setId(id);
        storeRepo.save(store1);
    }

    public void deleteStore(Integer id){
        Store oldStore = storeRepo.getById(id);
        if(oldStore == null){
            throw new ApiException("Not found");
        }
        storeRepo.deleteById(id);
    }



}
