package cn.edu.cqvie.dp;

import cn.edu.cqvie.dp.notify.Lock;
import cn.edu.cqvie.dp.notify.ThreadA;
import cn.edu.cqvie.dp.observer.*;

public class ObserverPatternDemo {

   // 主题
  static Subject subject = new Subject();

   public static void main(String[] args) {
      // 等待线程
      Lock lock = new Lock();
      ThreadA a = new ThreadA(lock);
      a.start();

      Integer careNumber = 10;
      // 观察者
      new HexaObserver(subject, 0);
      // 观察者
      new OctalObserver(subject, 0);
      // 观察者
      new BinaryObserver(subject, 0);
      // 观察者
      new ThreadObserver(subject, careNumber, lock);

      // 1. 通知观察者
      System.out.println("First state change: 15");
      subject.setState(15);
      System.out.println("Second state change: 10");  
      subject.setState(10);
   }
}