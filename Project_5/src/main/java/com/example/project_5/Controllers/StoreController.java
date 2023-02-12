package com.example.project_5.Controllers;

import com.example.project_5.Models.Store;
import com.example.project_5.Services.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store/")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
//    private final Store store;

    @GetMapping("get")
    public ResponseEntity getStore()
    {
        List<Store> storeList = storeService.getStore();
        return ResponseEntity.status(200).body(storeList);
    }

    @PostMapping("add")
    public ResponseEntity addStore(@Valid @RequestBody Store store)
    {
        storeService.addStore(store);
        return ResponseEntity.status(200).body("Store added!");
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateStore(@PathVariable Integer id, @Valid @RequestBody Store store)
    {
        storeService.updateStore(id, store);
        return ResponseEntity.status(200).body("Store updated!");
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id)
    {
        storeService.deleteStore(id);
        return ResponseEntity.status(200).body("Store delete!");
    }
}
