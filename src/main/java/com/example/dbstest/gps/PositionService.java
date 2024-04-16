package com.example.dbstest.gps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public void save(Position p) {
        this.positionRepository.save( p );
    }

    public Page<Position> findAllDto(PageRequest pageable) {
        return this.positionRepository.findAll(pageable);
    }
}
