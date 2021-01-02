package cn.edu.cqvie.ssm.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * Bean 工具类
 *
 * @author zhengsh
 * @date 202-10-31
 */
public class BeanUtils {

    /**
     * 集合数据的拷贝
     *
     * @param sources: 数据源类
     * @param target:  目标类::new(eg: UserVO::new)
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
        return copyListProperties(sources, target, null);
    }


    /**
     * 带回调函数的集合数据的拷贝（可自定义字段拷贝规则）
     *
     * @param sources:  数据源类
     * @param target:   目标类::new(eg: UserVO::new)
     * @param callBack: 回调函数
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, BiConsumer<S, T> callBack) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t);
            list.add(t);
            if (callBack != null) {
                //回调方法
                callBack.accept(source, t);
            }
        }
        return list;
    }


    /**
     * 普通对象数据的拷贝
     *
     * @param sources: 数据源类
     * @param target:  目标类::new(eg: UserVO::new)
     * @return
     */
    public static void copyProperties(Object sources, Object target) {
        org.springframework.beans.BeanUtils.copyProperties(sources, target);
    }
}
