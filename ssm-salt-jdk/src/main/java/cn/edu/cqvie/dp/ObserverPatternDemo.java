package cn.edu.cqvie.dp;

import cn.edu.cqvie.dp.notify.Lock;
import cn.edu.cqvie.dp.notify.ThreadA;
import cn.edu.cqvie.dp.observer.*;

public class ObserverPatternDemo {

   // 主题
  static Subject subject = new Subject();

   public static void main(String[] args) {

      Integer careNumber = 10; //订单号

      // 等待线程
      Lock lock = new Lock();
      ThreadA a = new ThreadA(lock);
      a.start();

      // 观察者
      new ThreadObserver(subject, careNumber, lock);

      // 1. 通知观察者
      System.out.println("Second state change: careNumber");
      subject.setState(careNumber);
   }
}