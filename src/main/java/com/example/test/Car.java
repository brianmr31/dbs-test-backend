package com.example.test;

public abstract class Car {
    
    private int roda = 0;
    private String bahanBakar = "Car";
    private String sepion = "auto";
    private String pelek = "auto";

    public Car(){

    }

    public int getRoda() {
        return this.roda;
    }

    public void setRoda(int roda) {
        this.roda = roda;
    }

    public String getBahanBakar() {
        return this.bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    private String getSepion() {
        return this.sepion;
    }

    private void setSepion(String sepion) {
        this.sepion = sepion;
    }
    
    protected String getPelek() {
        return this.pelek;
    }

    protected void setPelek(String pelek) {
        this.pelek = pelek;
    }
}
