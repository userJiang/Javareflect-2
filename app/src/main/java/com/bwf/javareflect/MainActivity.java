package com.bwf.javareflect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
////        initview1();
//        try {
//            initview2();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        try {
//            initview3();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        }
//        try {
//            initview4();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        try {
            initview5();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    //5、调用Person对象中的方法
    private void initview5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person p=new Person();
        Class cls=p.getClass();
        Method method = cls.getDeclaredMethod("toString",String.class,int.class);
        method.setAccessible(true);
        method.invoke(p,"对不对？",999);
    }
    //4、改变私有属性的值
    private void initview4() throws NoSuchFieldException, IllegalAccessException {
        Class cls=Person.class;
        Person person1=new Person();
        Field field=cls.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person1,"哈哈哈");
        Log.i("改变私有属性：",person1.getName());

    }
    //3、获取Method对象
    private void initview3() throws NoSuchMethodException {
        Class cls=Person.class;
        Method[] methods=cls.getMethods();
        for (Method method : methods) {
            Log.i("Person类中所有的公共方法:",method.getName()+"");
        }
        Method method=cls.getMethod("test",null);
        Log.i("Person类中test方法:",method.getName()+"");
        method=cls.getDeclaredMethod("setAge",int.class);
        Log.i("Person类中setAge方法:",method.getName()+"");
    }

    //2、反射获取该类的公共、私有对象
    private  void initview2() throws NoSuchFieldException {
        Class cls=Person.class;
        Field[] fields=cls.getFields();
        for (Field field:fields){
            Log.i("Person类中所有的公共属性:",field.getName()+"");
        }
        Log.i("Person类中所有的公共属性:",fields.length+"");
        Field field=cls.getField("age");
        Log.i("Person类中age属性:",field.getName()+"");
        fields=cls.getDeclaredFields();
        for (Field fieldq:fields){
            Log.i("Person类中所有的属性:",fieldq.getName()+"");
            field=cls.getDeclaredField("name");
            Log.i("Person类中name属性:",field.getName()+"");
        }
    }

    //1、反射获取该类对象
    private void initview1(){
        Class cls=null;
        Person person=new Person();
        cls=person.getClass();
        cls=Person.class;
        try {
            cls=Class.forName("com.bwf.javareflect.Person");
            Object obj = cls.newInstance();
            if(obj instanceof Person) {
                Log.i("javareflect","obj是Person对象");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
