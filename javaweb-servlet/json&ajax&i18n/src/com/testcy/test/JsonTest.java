package com.testcy.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import com.testcy.bean.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {

    //将java bean和json的互相转换
    @Test
    public void testJson() {
        Person person = new Person(1, "Curry");
        Gson gson = new Gson();
        //将java bean转换为json字符串
        String jsonStr = gson.toJson(person);
        System.out.println(person);
        System.out.println(jsonStr);

        //将json字符串转换为java bean
        Person person1 = gson.fromJson(jsonStr, Person.class);
        System.out.println(person1.getName());
    }

    //将java list集合和json的互相转换
    @Test
    public void test2() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(1, "Curry"));
        list.add(new Person(2, "Tom"));
        Gson gson = new Gson();
//        将list集合转换为json对象
        String listJsonStr = gson.toJson(list);
        System.out.println(listJsonStr);

        //将json字符串转化为list集合
        List<Person> listPerson = gson.fromJson(listJsonStr, new TypeToken<List<Person>>() {
        }.getType());
        System.out.println(listPerson);
        System.out.println(listPerson.get(0));
    }

    //将java map集合和json的互相转换
    @Test
    public void test3() {
//        HashMap<Integer, String> map = new HashMap<>();
//
//        map.put(1,"Curry");
//        map.put(2,"Tom");
        HashMap<Integer, Person> map2 = new HashMap<>();
        map2.put(1,new Person(1,"Curry"));
        map2.put(2,new Person(2,"Tom"));
        Gson gson = new Gson();
        String mapJsonStr = gson.toJson(map2);
        System.out.println(mapJsonStr);

        Map<Integer,Person> map3 = gson.fromJson(mapJsonStr, new TypeToken<Map<Integer, Person>>() {
        }.getType());
        System.out.println(map3);
        Person person = map3.get(1);
        System.out.println(person);
    }
}
