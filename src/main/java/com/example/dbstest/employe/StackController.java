package com.example.dbstest.employe;

import java.util.ArrayList;
import java.util.List;

public class StackController {
    
    int[] stack = new int[5];
    
    // List<Integer> stack = new ArrayList();

    public boolean push( int x ){ 
        boolean isFull = true;
        for( int i = 0; i < stack.length; i++ ){
            if( stack[i] == 0 ){
                stack[i] = x;
                isFull = false;
                break;
            }
        }
        return isFull;
        // stack.add( i );
    }

    public boolean pop(){
        boolean isEmpty = true;
        for( int i = 0; i < stack.length; i++ ){
            if( stack[ (stack.length -1 )- i ] != 0 ){
                stack[i] = 0;
                isEmpty = false;
                break;
            }   
        }
        // stack.remove( stack.size() - 1 );
        return isEmpty;
    }
}
