package com.example.dbstest.employe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, String>{

    @Query(" select new com.example.dbstest.employe.EmployeDto(e) from  Employe e ")
    Page<EmployeDto> findAllDto( Pageable page );

    @Query(" select e from  Employe e where e.name = :name ")
    Employe findByName(@Param("name")String name);
}
