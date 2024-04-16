package com.example.dbstest;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.dbstest.employe.EmployeController;
import com.example.dbstest.employe.EmployeDto;
import com.example.dbstest.employe.EmployeService;

import static org.hamcrest.Matchers.containsString;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeController.class)
public class TestLayerController {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeService employeService;

    @Test
    public void testMethodGetEmployees() throws Exception{   
        Page<EmployeDto> datas = new PageImpl<>(Collections.emptyList());

        Mockito.when( employeService.findAllDto( Mockito.any() )).thenReturn( datas );

        try {
            ResultActions result = mockMvc.perform( get("/employees/0/10/name/NONE") );
            result.andDo(print()).andExpect( status().isOk() ).andExpect(content().string( containsString("\"totalPages\":1") ) ) ;

            // verify(avengerRepository, times(1)).findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
