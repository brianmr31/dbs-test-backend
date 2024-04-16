package com.example.dbstest.gps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbstest.employe.EmployeDto;

@RestController
public class PositionController {
    
    @Autowired
    private PositionService positionService; 

    @CrossOrigin( origins="http://localhost:4200")
    @PostMapping("/position/")
    public ResPosition save(@RequestBody Position p ){
        this.positionService.save( p );
        return new ResPosition("ok");
    }

    @CrossOrigin( origins="http://localhost:4200")
    @GetMapping("/position/{pageNumber}/{pageSize}/{sort}/{order}")
    public Page < Position > findAll(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, 
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
        
        Page < Position > data = positionService.findAllDto( pageable );
        return data;
    }
}
