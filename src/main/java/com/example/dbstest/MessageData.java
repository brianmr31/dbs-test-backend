package com.example.dbstest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageData {

    String msg;

    public MessageData( String msg ){
        this.msg = msg;
    }
}
