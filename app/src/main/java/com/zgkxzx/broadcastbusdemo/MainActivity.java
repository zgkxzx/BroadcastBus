package com.zgkxzx.broadcastbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zgkxzx.lib.broadcastbus.BroadcastBus;
import com.zgkxzx.lib.broadcastbus.OnEventReceive;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();

    private BroadcastBus broadcastBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instance the bus
        broadcastBus = new BroadcastBus(this);
        //register the bus
        registerBus();

    }


    private void registerBus() {
        Map<Class<?>, OnEventReceive> eventMap = new HashMap<>();
        eventMap.put(UserInfoEvent.class, new OnEventReceive<UserInfoEvent>() {
            @Override
            public void onEvent(UserInfoEvent userInfoEvent) {
                Log.d(TAG, "UserInfoEvent onEvent - received: " + userInfoEvent.toString());
            }
        });
        eventMap.put(LoginInfoEvent.class, new OnEventReceive<LoginInfoEvent>() {
            @Override
            public void onEvent(LoginInfoEvent loginInfoEvent) {
                Log.d(TAG, "LoginInfoEvent onEvent - received: " + loginInfoEvent.toString());
            }
        });
        broadcastBus.register(eventMap);

    }

    public void skipEventClick(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //That must unregister the bus that is registered
        broadcastBus.unRegister();
    }
}
