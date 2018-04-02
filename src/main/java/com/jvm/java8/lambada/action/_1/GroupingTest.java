package com.jvm.java8.lambada.action._1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingTest {

    static class Dish{
        int calories;
        String type;

        public Dish(String type,int calories){
            this.type=type;
            this.calories=calories;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Dish{" +
                    "calories=" + calories +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
    enum CaloricLevel{
        DIET,
        NORMAL,
        FAT
    }
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                             new Dish("咸鱼",200),
                             new Dish("烤鱼",500),
                new Dish("咸鱼",700),
                new Dish("烤鱼",800),
                new Dish("炸鱼",100),
                new Dish("炸鱼",600),
                new Dish("咸鱼",700),
                new Dish("炸鱼",300)
                 );

        Map<String, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                } )
                        )
                );

        System.out.println("dishesByTypeCaloricLevel.toString() = " + dishesByTypeCaloricLevel.toString());
    }
}
