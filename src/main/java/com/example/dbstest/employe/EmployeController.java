package com.example.dbstest.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbstest.MessageData;

import jakarta.validation.Valid;

@RestController
public class EmployeController {
    
    @Autowired
    private EmployeService employeService;

    @CrossOrigin( origins="http://localhost:4200")
    @GetMapping("/employees/{pageNumber}/{pageSize}/{sort}/{order}")
    public Page < EmployeDto > getEmployees(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, 
        @PathVariable String sort, @PathVariable String order) {
            
        Sort.Direction tmpsort = null ;
        if( order.equals("ASC") ){
            tmpsort = Sort.Direction.ASC;
        } else if( order.equals("DESC") ) {
            tmpsort = Sort.Direction.DESC;
        } else {
            tmpsort = Sort.Direction.ASC;           
        }

        PageRequest pageable = null;
        if ( sort != null) {
            // with sorting
            pageable = PageRequest.of(pageNumber, pageSize, tmpsort, sort);
        } else {
            // without sorting
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        
        Page < EmployeDto > data = employeService.findAllDto( pageable );
        return data;
    }

    @CrossOrigin( origins="http://localhost:4200")
    @PostMapping("/employees")
    public MessageData save(@Valid @RequestBody EmployeDto em ) throws Exception {
        this.employeService.save(em);
        return new MessageData("ok");
    }
}
