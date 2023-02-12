package com.example.project_5.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Area should be not empty!")
    @Size(min = 3,message = "Area most be more than 1 character!")
    private String area;
    @NotEmpty(message = "Street should be not empty!")
    @Size(min = 3,message = "Street most be more than 1 character!")
    private String street;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Store store;
}
