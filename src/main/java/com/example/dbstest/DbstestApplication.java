package com.example.dbstest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.dbstest.employe.Employe;
import com.example.dbstest.employe.EmployeService;

@SpringBootApplication
public class DbstestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbstestApplication.class, args);
	}

	@Bean
  	public CommandLineRunner demo(
		EmployeService employeeService) {
    	return (args) -> {

			String pattern = "MM-dd-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			employeeService.deleteAll();

			List<Employe> list = new ArrayList<Employe>();
			Employe test = new Employe();
			test.setName("wkwkwk"); 
			test.setDob( simpleDateFormat.parse("06-21-1995") );
			list.add(test);

			Employe test2 = new Employe();
			test2.setName("hehehee"); 
			test2.setDob( simpleDateFormat.parse("11-31-1993") );
			list.add(test2);

			Employe test3 = new Employe();
			test3.setName("test"); 
			test3.setDob( simpleDateFormat.parse("01-28-1996") );
			list.add(test3);

			Employe test4 = new Employe();
			test4.setName("paijo"); 
			test4.setDob( simpleDateFormat.parse("12-05-1996") );
			list.add(test4);

			employeeService.saveAll( list );
		};
	}
}
