package com.java8.lambada.action._1;

public class Apple {

    private int weight;
    private String color;

    public Apple(int weight,String color){
        this.weight=weight;
        this.color=color;
    }

    public boolean isGreen(){
        if("green".equals(color)){
            return true;
        }
        return false;
    }

    public boolean isBig(){
        if(weight>5){
            return true;
        }
        return false;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
