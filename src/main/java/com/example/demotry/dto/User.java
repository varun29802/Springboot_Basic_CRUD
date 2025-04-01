package com.example.demotry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String empId;
    private String empName;
    private Integer empContactNumber;
    private Integer empAge;

}
