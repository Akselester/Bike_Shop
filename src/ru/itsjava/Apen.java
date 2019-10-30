package ru.itsjava;

public class Apen {
    private String brand;
    private int rodSize;
    private boolean isWriting;
    private int yearOfMade;

    public Apen() {
        setBrand("IKEA");
        setRodSize(4);
        setWriting(false);
        setYearOfMade(1994);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRodSize(int size) {
        this.rodSize = size;
    }

    public void setWriting(boolean status) {
        this.isWriting = status;
    }

    public void setYearOfMade(int yearOfMade) {
        this.yearOfMade = yearOfMade;
    }

    public String getBrand() {
        return brand;
    }

    public int getRodSize() {
        return rodSize;
    }

    public boolean getWriting() {
        return isWriting;
    }

    public int getYearOfMade() {
        return yearOfMade;
    }
}
