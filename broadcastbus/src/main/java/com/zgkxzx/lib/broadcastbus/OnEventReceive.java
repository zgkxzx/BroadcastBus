package com.zgkxzx.lib.broadcastbus;

/**
 * Author       zgkxzx
 * Date         5/24/17
 * Discripter   this is a interface for receiving events;
 */

public interface OnEventReceive<T> {
    void onEvent(T t);
}
