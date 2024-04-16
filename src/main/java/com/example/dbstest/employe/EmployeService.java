package com.example.dbstest.employe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeService {
    
    @Autowired
    private EmployeRepository employeRepository;

    public Page<EmployeDto> findAllDto( Pageable page ) {
        return this.employeRepository.findAllDto(page);
    }

    public Employe findByName( String name ){
        return this.employeRepository.findByName(name);
    }

    public void saveAll(List<Employe> list) {
        this.employeRepository.saveAll(list);
    }

    public void deleteAll() {
        this.employeRepository.deleteAll();
    }

    public void save(EmployeDto data) {
        this.employeRepository.save( new Employe( data ) );
    }

    public void save(Employe data) {
        this.employeRepository.save(data);
    }

    public long count() {
        return this.employeRepository.count();
    }

    public String getCheckData( String input ) {
        String hasil = "";
        int[] tmp = new int[input.length()];
        for(int i=0; i < input.length(); i++ ){
            tmp[i] = Character.getNumericValue(input.charAt(i));
        }

        for(int j=0; j < tmp.length; j++ ){
            // 0
            for(int jj=0; jj < tmp.length; jj++ ){
                // 6 ke - j = 2
                if( jj != ( tmp.length - 1 ) ){
                    //        2       6
                    if( tmp[jj+1] < tmp[jj] ){
                        int d = tmp[jj];
                        tmp[jj] = tmp[jj+1];
                        tmp[jj+1] = d;
                    }
                }
            }
        }

        for(int c=0; c < tmp.length; c++ ){
            hasil += tmp[c];
        }
        return hasil;
    }
}
