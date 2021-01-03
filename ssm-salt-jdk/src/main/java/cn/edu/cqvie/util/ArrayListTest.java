package cn.edu.cqvie.util;

import cn.edu.cqvie.domain.Student;
import cn.edu.cqvie.domain.Study;
import org.junit.Test;

import java.util.*;

public class ArrayListTest {


    /**
     * ArrayList 和 LinkedList 比较
     *
     * @date 2021-01-03
     */
    @Test
    public void arrayListAndLinkedListTest() {
        int length = 1000000;
        List<Integer> arrayList = new ArrayList<>(length);
        List<Integer> linkedList = new LinkedList<>();

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            arrayList.add(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("ArrayList cost time: " + (end1 - start1));


        long start2 = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            linkedList.add(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("LinkedList cost time: " + (end2 - start2));

        //数据结果
        //ArrayList cost time: 48
        //LinkedList cost time: 97
    }


    /**
     * 拷贝接口分析
     *
     * @throws CloneNotSupportedException
     */
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        Student old = new Student(22, "Tom", null);
        Study stOld = new Study();
        stOld.setMath("11");
        old.setStudy(stOld);

        Student new1 = (Student) old.clone();
        old.getStudy().setMath("22");
        old.setAge(20);

        System.out.println("old math String: " + old.getStudy().getMath());
        System.out.println("new1 math String: " + new1.getStudy().getMath());
        System.out.println("old age int: " + old.getAge());
        System.out.println("new1 age int: " + new1.getAge());
        System.out.println("new1 study: " + new1.getStudy());
        System.out.println("old study: " + old.getStudy());


    }


    /**
     * 在 sublist 中，高度注意对原始集合的元素个数修改，
     * 会导致列表的遍历，增加，删除均会产生 ConcurrentModificationException 异常
     */
    @Test
    public void subListTest() {
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        List<String> strList = list.subList(0, 3);
        list.set(2, "66666");
        System.out.println(strList.get(0));

        //fail-fast 错误检测机制
        /*
        list.add(3, "a");
        System.out.println(strList.get(2));
        */

        list.remove(2);
        System.out.println(strList.get(2));
    }

    @Test
    public void testArrays() {
        Long[] arr = new Long[]{1L, 2L, 3L, 4L};
        List list = Arrays.asList(arr);
        System.out.println(list.size()); //基本类型不支持范型化, 数组不支持向下转型
        System.out.println(list.get(0));
    }

    /**
     * 不可变集合
     */
    @Test
    public void unmodifiable() {
        List list = new ArrayList(Arrays.asList(3, 4, 5, 6, 7, 8, 9));
        List modilist = Collections.unmodifiableList(list);
        //modilist.add(5, 1); // 报错 java.lang.UnsupportedOperationException
        list.set(0, 1);
        System.out.println(modilist.get(0));
    }

    @Test
    public void testEcho1() {
        //long[] arr = new long[]{1l,4l,3l,3l};
        //List list = Arrays.asList(arr);
        //List 结构为 List<Long[]>

        //解决输出为 1 的问题
        Long[] arr = new Long[]{1l, 4l, 3l, 3l};
        List<Long> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(list.get(0));
    }
}
