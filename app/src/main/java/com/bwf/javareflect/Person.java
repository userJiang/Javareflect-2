package com.bwf.javareflect;

import android.util.Log;

/**
 * Created by Administrator on 2016/12/28.
 */

public class Person {
    private String name;
    public int age;
    public String address;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public void test(){
        Log.i("javareflect","名字:"+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    private String toString(String name,int age){
        Log.i("SSSSSS",name+""+"\n"+age);
        return name+age;
    }
}
