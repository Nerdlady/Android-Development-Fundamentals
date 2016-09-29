package com.example.homeworkfive;

/**
 * Created by Nerd_lady on 29-Sep-16.
 */

public class Food {

    private long id;
    private String name;
    private String descrioption;

    public Food(long id,String name, String descrioption) {
        this.name = name;
        this.id = id;
        this.descrioption = descrioption;
    }

    public String getName() {
        return name;
    }

    public String getDescrioption() {
        return descrioption;
    }

    public long getId() {
        return id;
    }
}
