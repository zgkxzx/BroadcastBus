package com.zgkxzx.broadcastbusdemo;

import com.zgkxzx.lib.broadcastbus.BaseEvent;

/**
 * Author       zgkxzx
 * Date         5/24/17
 * Discripter   UserInfoEvent
 */

public class UserInfoEvent extends BaseEvent {
    private String name;
    private String avater;
    private int age;
    private boolean sex;

    public UserInfoEvent(String name, String avater, int age, boolean sex) {
        this.name = name;
        this.avater = avater;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserInfoEvent{" +
                "name='" + name + '\'' +
                ", avater='" + avater + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
