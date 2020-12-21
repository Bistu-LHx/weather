package com.test.weather;

public class City {
    public int id;
    public String city_code;
    public String city_name;
    public int pid;

    public City(String city_code, String city_name) {
        this.city_code = city_code;
        this.city_name = city_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public City() {
    }

    public String getCity_code() {
        return city_code;
    }

    public String getCity_name() {
        return city_name;
    }
}
