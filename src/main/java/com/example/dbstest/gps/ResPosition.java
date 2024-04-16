package com.example.dbstest.gps;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResPosition {
    
    private String msg;
    private Position p;

    public ResPosition( String msg ){
        this.msg = msg;
    }

    public ResPosition( String msg, Position p ){
        this.msg = msg;
        this.p = p;
    }
}
