package com.zgkxzx.broadcastbusdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zgkxzx.lib.broadcastbus.BroadcastBus;

/**
 * 创建者 zgkxzx
 * 日期   5/25/17
 * 描述
 */

public class SecondActivity extends AppCompatActivity {
    private final static String TAG = SecondActivity.class.getSimpleName();

    private BroadcastBus broadcastBus;
    private UserInfoEvent userInfoEvent;

    private int count;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        broadcastBus = new BroadcastBus(this);
        userInfoEvent = new UserInfoEvent("zgkxzx", "http://www.zgkxzx.club", 25, true);
    }


    public void sendMessageEventClick(View view) {
        count++;
        userInfoEvent.setAge(userInfoEvent.getAge() + count);
        //send bus message
        broadcastBus.post(userInfoEvent);
    }

    public void sendLoginMsgEventClick(View view) {
        LoginInfoEvent loginInfoEvent = new LoginInfoEvent("zgkxzx", "123456789");
        //send bus message
        broadcastBus.post(loginInfoEvent);
    }
}
