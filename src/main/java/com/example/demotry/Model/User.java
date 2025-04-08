package com.example.demotry.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private String empId;
    private String empName;
    private Integer empContactNumber;
    private Integer empAge;
}
