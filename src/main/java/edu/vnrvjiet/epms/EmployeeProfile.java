package edu.vnrvjiet.epms;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeProfile {
    @Id
    private Integer employeeId;
    private String name;
    private String mobile;
    private String email;
    private URL linkedInUrl;

//    I would like to add a few more fields in future

}
