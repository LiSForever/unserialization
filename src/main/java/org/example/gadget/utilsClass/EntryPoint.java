package org.example.gadget.utilsClass;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class EntryPoint implements Serializable {
    protected Map map;
    public EntryPoint(Map map){
        this.map = map;
    }
    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        System.out.println(map.values());
    }
}
