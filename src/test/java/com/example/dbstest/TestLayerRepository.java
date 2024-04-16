package com.example.dbstest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.example.dbstest.employe.Employe;
import com.example.dbstest.employe.EmployeRepository;

@SpringBootTest
@ContextConfiguration(
  classes = { TestJpaConfig.class }, 
  loader = AnnotationConfigContextLoader.class)
@Transactional
public class TestLayerRepository {

    @Autowired
    private EmployeRepository employeRepository;
    

  @Test
  public void testDenganRepository() {
    Employe data = new Employe("hehwh","1995-01-29" );
    employeRepository.save(data);
    
    Employe data2 = employeRepository.findByName( "hehwh" );
    assertEquals("hehwh", data2.getName());
  }
}
