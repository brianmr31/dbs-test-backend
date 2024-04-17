package com.example.test;

public class Tesla extends Car {
    
    protected String test = "test";

    public Tesla() {

    }

    public Tesla(int roda) {
        // super.getPelek();
        super.setRoda(roda);
    }

    public int getRoda(){
        return super.getRoda();
    }
}
