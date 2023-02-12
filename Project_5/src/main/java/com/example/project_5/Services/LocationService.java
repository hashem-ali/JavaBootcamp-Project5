package com.example.project_5.Services;

import com.example.project_5.ApiExceptions.ApiException;
import com.example.project_5.Models.Location;
import com.example.project_5.Repositries.LocationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepo locationRepo;
//    private final Location location;

    public List<Location> getLocation() {
        return locationRepo.findAll();
    }

    public void addLOcation(Location location){
        locationRepo.save(location);
    }

    public void updateLocation(Integer id, Location location1){
        Location oldLocation = locationRepo.getById(id);
        if(oldLocation == null){
            throw new ApiException("Not found");
        }
        oldLocation.setId(id);
        locationRepo.save(location1);
    }

    public void deleteLocation(Integer id){
        Location oldLocation = locationRepo.getById(id);
        if(oldLocation == null){
            throw new ApiException("Not found");
        }
        locationRepo.deleteById(id);
    }
}
