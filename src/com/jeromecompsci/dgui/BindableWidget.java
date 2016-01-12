package com.jeromecompsci.dgui;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Derek Wang
 */
abstract class BindableWidget extends Widget {
    public void bind(final Object obj, final String methodName) {
        addBindingAsListener(new Binding(obj.getClass(), obj, methodName));
    }

    public void bind(final Class cls, final String methodName) {
        addBindingAsListener(new Binding(cls, null, methodName));
    }

    abstract void addBindingAsListener(final Binding binding);
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
