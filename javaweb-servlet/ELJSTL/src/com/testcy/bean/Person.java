package com.testcy.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    private String[] phones;
    private List<String>list;
    private Map<String,Object>map;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phones=" + Arrays.toString(phones) +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Person(String name, String[] phones, List<String> list, Map<String, Object> map) {
        this.name = name;
        this.phones = phones;
        this.list = list;
        this.map = map;
    }

    public Person() {
    }
}
