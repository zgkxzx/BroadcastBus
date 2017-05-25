package com.zgkxzx.lib.broadcastbus;

import java.io.Serializable;

/**
 * Author       zgkxzx
 * Date         5/24/17
 * Discripter   the base event class and child class must extend the base event and implement serializable
 */


public abstract class BaseEvent implements Serializable {
    protected String tag;

}
