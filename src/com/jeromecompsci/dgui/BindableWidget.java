package com.jeromecompsci.dgui;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Derek Wang
 */
abstract class BindableWidget extends Widget {
    public void bind(final Object obj, final String methodName) {
        addBindingAsListener(new Binding() {
            @Override Class getTargetClass() {
                return obj.getClass();
            }
            @Override Object getTargetObject() {
                return obj;
            }
            @Override String getTargetMethodName() {
                return methodName;
            }
        });
    }

    public void bind(final Class cls, final String methodName) {
        addBindingAsListener(new Binding() {
            @Override Class getTargetClass() {
                return cls;
            }
            @Override Object getTargetObject() {
                return null;
            }
            @Override String getTargetMethodName() {
                return methodName;
            }
        });
    }

    abstract void addBindingAsListener(final Binding binding);
}

/**
 * @author Derek Wang
 */
abstract class Binding {

    abstract Class getTargetClass();
    abstract Object getTargetObject();
    abstract String getTargetMethodName();

    void executeBoundMethod() {
        try {
            getTargetClass().getMethod(getTargetMethodName()).invoke(getTargetObject());
        } catch (NoSuchMethodException e) {
            e.printStackTrace(System.err);
        } catch (IllegalAccessException e) {
            e.printStackTrace(System.err);
        } catch (InvocationTargetException e) {
            e.printStackTrace(System.err);
        }
    }
}
