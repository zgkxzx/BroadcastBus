package com.zgkxzx.broadcastbusdemo;

import com.zgkxzx.lib.broadcastbus.BaseEvent;

/**
 * Author       zgkxzx
 * Date         5/24/17
 * Discripter   LoginInfoEvent
 */

public class LoginInfoEvent extends BaseEvent{
    private String loginId;
    private String password;

    public LoginInfoEvent(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginInfoEvent{" +
                "loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
