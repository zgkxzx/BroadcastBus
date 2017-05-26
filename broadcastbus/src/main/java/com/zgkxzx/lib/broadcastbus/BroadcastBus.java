package com.zgkxzx.lib.broadcastbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Author       zgkxzx
 * Date         5/24/17
 * Discripter   This is a simple bus based on android broadcast
 */

public class BroadcastBus {
    private final static String TAG = BroadcastBus.class.getSimpleName();

    private WeakReference<Context> contextRef;
    private Map<Class<? extends BaseEvent>, OnEventReceive> eventMap = new HashMap<>();
    private boolean isRegister = false;

    public BroadcastBus(Context context) {
        contextRef = new WeakReference<>(context.getApplicationContext());
    }

    /**
     * Send Event
     *
     * @param baseEvent the send event
     */
    public synchronized void post(BaseEvent baseEvent) {
        Intent intent = new Intent(baseEvent.getClass().getName());
        intent.putExtra(baseEvent.getClass().getName(), baseEvent);
        if (contextRef.get() != null)
            contextRef.get().sendBroadcast(intent);
    }

    /**
     * register bus for a listener
     *
     * @param clazz          the type of event
     * @param onEventReceive the listener of the event
     */
    public synchronized <T extends BaseEvent> void register(Class<T> clazz, OnEventReceive onEventReceive) {
        eventMap.put(clazz, onEventReceive);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(clazz.getName());
        if (contextRef.get() != null)
            contextRef.get().registerReceiver(broadcastReceiver, intentFilter);

        isRegister = true;
    }


    /**
     * register bus for some listeners
     *
     * @param map map for listeners
     */
    public synchronized void register(Map<Class<? extends BaseEvent>, OnEventReceive> map) {
        this.eventMap = map;
        IntentFilter intentFilter = new IntentFilter();
        for (Map.Entry<Class<? extends BaseEvent>, OnEventReceive> event : eventMap.entrySet()) {
            intentFilter.addAction(event.getKey().getName());
        }

        if (contextRef.get() != null)
            contextRef.get().registerReceiver(broadcastReceiver, intentFilter);

        isRegister = true;
    }

    /**
     * remove a bus event
     *
     * @param clazz the type of event
     */
    public void unRegister(Class<?> clazz) {
        if (eventMap == null)
            return;
        if (eventMap.containsKey(clazz))
            eventMap.remove(clazz);
    }

    /**
     * unregister all bus event
     */
    public void unRegister() {
        if (contextRef.get() != null && isRegister) {
            contextRef.get().unregisterReceiver(broadcastReceiver);
        }

        isRegister = false;
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            for (Map.Entry<Class<? extends BaseEvent>, OnEventReceive> event : eventMap.entrySet()) {
                Class<?> key = event.getKey();
                if (key == null)
                    return;
                if (key.isInstance(intent.getSerializableExtra(key.getName()))) {
                    OnEventReceive onEventReceive = event.getValue();
                    if (onEventReceive != null)
                        onEventReceive.onEvent(intent.getSerializableExtra(key.getName()));
                }
            }

        }
    };


}
