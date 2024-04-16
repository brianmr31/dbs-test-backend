package com.example.dbstest.employe;

import java.text.SimpleDateFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeDto {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    private String id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "Invalid characters date yyyy-mm-dd")
    private String dob;

    public EmployeDto( Employe e){
        this.id = e.getId();
        this.name = e.getName();
        this.dob = sdf.format( e.getDob() );
    }
}
