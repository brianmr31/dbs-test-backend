package com.example.dbstest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.dbstest.employe.Employe;
import com.example.dbstest.employe.EmployeRepository;
import com.example.dbstest.employe.EmployeService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestLayerService {

  @Mock
  private EmployeRepository employeRepository;

  
  @InjectMocks
  private EmployeService employeService;

  @Test
  public void testDenganService(){
    Employe data = new Employe("hehwh","1995-01-29" );

    // DISIAPIN dulu
    given( employeRepository.findByName(data.getName())).willReturn( data );
    given( employeRepository.count()).willReturn( 1L );
    given( employeRepository.save(data)).willReturn( data );

    // this.employeService.setRepository(employeRepository);

    this.employeService.save(data);
    System.out.println("========");

    long count = this.employeService.count();
    System.out.println( count );

    Employe data2 = this.employeService.findByName( "hehwh" );
    assertEquals("hehwh", data2.getName());
  }

  @DisplayName("JUnit test for testDenganServiceRumit ")
  @Test
  public void testDenganServiceRumit(){
    String hasil = this.employeService.getCheckData("0987654321");

    assertEquals("0123456789", hasil);
  }

}