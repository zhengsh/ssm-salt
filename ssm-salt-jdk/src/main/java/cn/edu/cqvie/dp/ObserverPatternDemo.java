package cn.edu.cqvie.dp;

import cn.edu.cqvie.dp.notify.Lock;
import cn.edu.cqvie.dp.notify.ThreadA;
import cn.edu.cqvie.dp.observer.Subject;
import cn.edu.cqvie.dp.observer.ThreadObserver;

public class ObserverPatternDemo {

   // 1.  创建主题
  static Subject subject = new Subject();

   public static void main(String[] args) {

      //2. 生成订单号
      int careNumber = 10;

      //3. 进入逻辑走完逻辑后等待
      Lock lock = new Lock();
      ThreadA a = new ThreadA(lock);
      a.start();

      //4. 创建观察者1
      new ThreadObserver(subject, careNumber, lock);

      //6. 主题事件触发
      System.out.println("Second state change: careNumber");
      subject.setState(careNumber);
   }
}