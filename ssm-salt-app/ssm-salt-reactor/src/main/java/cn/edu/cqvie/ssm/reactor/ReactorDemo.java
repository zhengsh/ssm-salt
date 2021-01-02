package cn.edu.cqvie.ssm.reactor;

import reactor.core.publisher.Flux;

/**
 * reactor demo
 *
 * @author zhengsh
 * @date 2020-12-04
 */
public class ReactorDemo {

    public static void main(String[] args) {
        String wordStr = "hello guys i am bole welcome to luban school jdk quick fox prizev ";
        System.out.println("输入信息: " + wordStr);

        Flux<String> flux0 = Flux.fromArray(wordStr.split(""));
        System.out.print("输出信息: ");
        flux0.filter(i -> !" ".equals(i))
                .distinct()
                .sort(String::compareTo)
                .doOnSubscribe(i -> i.request(10))
                .doOnNext(System.out::print)
                .subscribe();
        System.out.println();
    }
}
