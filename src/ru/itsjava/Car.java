package ru.itsjava;


public class Car {
    private String color;
    private double engineVolume;
    private int wheelsCount;
    private boolean isBeep;

    //  Написать сеттеры и геттеры для всех полей. Написать метод для строкового представления обЪекта.Car
//  Это конструктор по умолчанию:
    public Car() {
        setColor("black");
        setEngineVolume(2.0);
        setWheelsCount(4);
        setBeep(false);
    }

    public Car(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setEngineVolume(double volume){
        this.engineVolume = volume;
    }

    public double getEngineVolume(){
        return engineVolume;
    }

    public void setWheelsCount(int count){
        this.wheelsCount = count;
    }

    public int getWheelsCount(){
        return wheelsCount;
    }

    public void setBeep(boolean isBeep){
        this.isBeep = isBeep;
    }

    public boolean getIsBeep(){
        return isBeep;
    }

    public String carToString(){
        String output ="Color = " + getColor() +
                "\nEngine Volume = " + getEngineVolume() +
                "\nWheels count = " + getWheelsCount() +
                "\nBeeping = " + getIsBeep();
        return output;
    }
}
