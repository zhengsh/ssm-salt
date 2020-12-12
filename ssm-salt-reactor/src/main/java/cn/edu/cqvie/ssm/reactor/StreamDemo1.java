package cn.edu.cqvie.ssm.reactor;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.Collectors;

/**
 * @Author madaijun
 * @Date 2020\12\4 0004 15:48
 * @Version 1.0
 */
public class StreamDemo1 {
    private static String wordStr = "hello guys i am bole welcome to luban school jdk quick fox prizev";
    public static void alpSort(String wordStr) {
        List<Character> alpArray = wordStr
                .chars().mapToObj(i -> (char) i)
                .distinct()
                .sorted(Character::compareTo)
                .collect(Collectors.toList());
        alpArray.forEach(System.out::print);
    }

    public static void alpFluxSort(String wordStr) {
        //创建发布者
        SubmissionPublisher<Character> publisher = new SubmissionPublisher<Character>();
        try {
            //创建订阅者
            Flow.Subscriber<Character> subscriber = new Flow.Subscriber<Character>() {
                @Override
                public void onSubscribe(Flow.Subscription subscription) {
                }
                @Override
                public void onNext(Character item) {
                    System.out.print(item);
                }
                @Override
                public void onError(Throwable throwable) {
                }
                @Override
                public void onComplete() {
                }
            };
            //绑定订阅者
            publisher.subscribe(subscriber);
            List<Character> characterList = wordStr
            .replaceAll(" ", "")
            .chars().mapToObj(i -> (char) i)
            .distinct()
            .sorted(Character::compareTo)
            .collect(Collectors.toList());
            characterList.forEach(i -> publisher.submit(i));
            Thread.currentThread().join(100000);
        } catch (Exception e) {

        } finally {
            publisher.close();
        }
    }

    public static void main(String[] arg) {
        System.out.println("输入：String wordStr= " + wordStr);
        System.out.print("输出：");
        alpSort(wordStr);
        System.out.print("");
        alpFluxSort(wordStr);
    }
}
