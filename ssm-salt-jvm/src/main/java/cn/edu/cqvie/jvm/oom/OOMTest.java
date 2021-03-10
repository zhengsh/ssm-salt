package cn.edu.cqvie.jvm.oom;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class OOMTest {


    //JVM 参数设置
    // -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=jvm.dump
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new HashMap<String, String>() {
                {
                    UUID uuid = UUID.randomUUID();
                    put(uuid.toString(), uuid.toString());
                }
            });
        }
    }
}
