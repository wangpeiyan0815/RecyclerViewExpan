package com.wpy.recycler.bean;

import java.util.List;

/**
 * Created by dell on 2017/8/27.
 */

public class InfoDean {
    private String name;
    private List<City> city;

    public InfoDean(String name, List<City> city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
}
