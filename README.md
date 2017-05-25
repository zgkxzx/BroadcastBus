### Introduce

This is a simple bus library by Android's broadcast. We can use it very convenient. Send and receive messages are marked by class name, which is in line with our actual engineering application.

### How to use

#### 1.Add the library to your project
```java
compile files('libs/broadcastbus-1.0.jar')
```
Copy the jar to the lib directory of your project and add the config to build.gradle.

#### 2.Instance the broadcastBus
```java
BroadcastBus broadcastBus = new BroadcastBus(this);
```
#### 3.Register the bus and listen the event
```java
Map<Class<?>, OnEventReceive> eventMap = new HashMap<>();
eventMap.put(UserInfoEvent.class, new OnEventReceive<UserInfoEvent>() {
    @Override
    public void onEvent(UserInfoEvent userInfoEvent) {
         Log.d(TAG, "UserInfoEvent onEvent - received: " + userInfoEvent.toString());
        }
});
//register a bus event       
broadcastBus.register(eventMap);
```
Between,the UseInfoEvent extends BaseEvent,and implement the Serializable.

#### 4.Send the bus event
```java
broadcastBus.post(userInfoEvent);
```
Send the bus event and what registered this event will receive this event message.

#### 5.Unregister the bus event
```java
broadcastBus.unRegister();
```
You must unregister the bus event when is not used.

### Feedback

You Have any questions and questions in the process of using to send the email to me.

* e-mail : zgkxzx@163.com
* QQ:  514011021

### Me & Throught

#### Simplicity is not simple.
