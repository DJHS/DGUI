package com.jeromecompsci.dgui;

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

    private Method method;
    private Object targetObject;

    public Binding(Class targetClass, Object targetObject, String targetMethodName) {
        try {
            this.method = targetClass.getMethod(targetMethodName);
        } catch (NoSuchMethodException e) {
            throw BindingException.forNoSuchMethod(targetMethodName, e);
        }
        this.targetObject = targetObject;
    }

    void executeBoundMethod() {
        try {
            method.invoke(targetObject);
        } catch (IllegalAccessException|InvocationTargetException e) {
            throw new BindingException("FATAL: exception incurred in bound method invocation!", e);
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
