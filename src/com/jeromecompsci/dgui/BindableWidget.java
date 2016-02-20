package com.jeromecompsci.dgui;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Derek Wang
 */
abstract class BindableWidget extends Widget {
    public void on(String evt, final Object obj, final String methodName) {
        addBindingForEvent(evt, new Binding(obj.getClass(), obj, methodName));
    }

    public void on(String evt, final Class cls, final String methodName) {
        addBindingForEvent(evt, new Binding(cls, null, methodName));
    }

    abstract void addBindingForEvent(String evt, final Binding binding);
}

/**
 * @author Derek Wang
 */
class Binding {

    private Thread thread;
    private final Method method;
    private final Object object;


    public Binding(final Class targetClass, final Object targetObject, final String targetMethodName) {
        try {
            method = targetClass.getMethod(targetMethodName);
        } catch (NoSuchMethodException e) {
            throw BindingException.forNoSuchMethod(targetMethodName, e);
        }
        object = targetObject;
    }

    void executeBoundMethod() {
        if (thread == null || !thread.isAlive()) {
            thread = new Thread() {
                @Override public void run() {
                    while(true) {
                        try {
                            method.invoke(object);
                        } catch (IllegalAccessException e) {
                            throw new BindingException("FATAL: exception incurred in bound method invocation!", e);
                        } catch (InvocationTargetException e) {
                            // This is a user-caused error. Print it to them, but keep us running.
                            e.getCause().printStackTrace();
                        }
                        try {
                            synchronized (this) {
                                wait();
                            }
                        } catch (InterruptedException e) {
                            throw new BindingException("FATAL: exception incurred in bound method invocation!", e);
                        }
                    }
                }
            };

            thread.start();
        } else {
            synchronized (thread) {
                thread.notify();
            }
        }
    }
}

class BindingException extends RuntimeException {
    public BindingException(String message) {
        super(message);
    }

    public BindingException(String message, Throwable t) {
        super(message, t);
    }

    static BindingException forNonExistentEvent(String eventName) {
        return new BindingException("Cannot bind non-existent event '" + eventName + "' with method .on(...).");
    }

    static BindingException forNoSuchMethod(String methodName, Throwable t) {
        return new BindingException("Method " + methodName + "() does not exist (or improper syntax used for static vs. non-static). Cannot bind.", t);
    }
}
