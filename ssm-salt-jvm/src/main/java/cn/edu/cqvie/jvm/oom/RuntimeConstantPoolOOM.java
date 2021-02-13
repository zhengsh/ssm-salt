package cn.edu.cqvie.jvm.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * -XX:MetaspaceSize=6m -XX:MaxMetaspaceSize=6m
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        Long i = 0L;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
