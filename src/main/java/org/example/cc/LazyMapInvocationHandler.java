package org.example.cc;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class LazyMapInvocationHandler implements InvocationHandler, Serializable {
    protected Map map;
    public LazyMapInvocationHandler(Map map) {
        this.map = map;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        map.get("test");
        return null;
    }
}
