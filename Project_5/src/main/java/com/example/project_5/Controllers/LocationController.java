package com.example.project_5.Controllers;

import com.example.project_5.Models.Location;
import com.example.project_5.Services.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location/")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;
//    private final Location location;

    @GetMapping("get")
    public ResponseEntity getLocation()
    {
        List<Location> locationList = locationService.getLocation();
        return ResponseEntity.status(200).body(locationList);
    }

    @PostMapping("add")
    public ResponseEntity addLocation(@Valid @RequestBody Location location)
    {
        locationService.addLOcation(location);
        return ResponseEntity.status(200).body("Location added!");
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateLocation(@PathVariable Integer id, @Valid @RequestBody Location location)
    {
        locationService.updateLocation(id, location);
        return ResponseEntity.status(200).body("Location updated!");
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteLocation(@PathVariable Integer id)
    {
        locationService.deleteLocation(id);
        return ResponseEntity.status(200).body("Location delete!");
    }
}
