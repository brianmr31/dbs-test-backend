package com.example.dbstest.employe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employe {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    private String name;
    private Date dob;

    public Employe(String name, String dob){

        this.name = name;
        try {
            this.dob = sdf.parse(dob);
        } catch (ParseException e) {
            this.dob = new Date();
        }
    }

    public Employe(EmployeDto d) {
        this.name = d.getName();
        try {
            this.dob = sdf.parse(d.getDob());
        } catch (ParseException e) {
            this.dob = new Date();
        }
    }
}
