package com.jeromecompsci.dgui;

import java.lang.reflect.InvocationTargetException;

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

    private Class targetClass;
    private Object targetObject;
    private String targetMethodName;

    public Binding(Class targetClass, Object targetObject, String targetMethodName) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethodName = targetMethodName;
    }

    void executeBoundMethod() {
        try {
            targetClass.getMethod(targetMethodName).invoke(targetObject);
        } catch (NoSuchMethodException e) {
            e.printStackTrace(System.err);
        } catch (IllegalAccessException e) {
            e.printStackTrace(System.err);
        } catch (InvocationTargetException e) {
            e.printStackTrace(System.err);
        }
    }
}

class NoSuchEventException extends RuntimeException {
    public NoSuchEventException(String s) {
        super("Cannot bind non-existent event '" + s + "' with method .on(...).");
    }
}