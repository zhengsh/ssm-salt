package cn.edu.cqvie.dp;

import cn.edu.cqvie.dp.observer.BinaryObserver;
import cn.edu.cqvie.dp.observer.HexaObserver;
import cn.edu.cqvie.dp.observer.OctalObserver;
import cn.edu.cqvie.dp.observer.Subject;

public class ObserverPatternDemo {
   public static void main(String[] args) {
      // 主题
      Subject subject = new Subject();

      Integer careNumber = 10;
      // 观察者
      new HexaObserver(subject, careNumber);
      // 观察者
      new OctalObserver(subject, 0);
      // 观察者
      new BinaryObserver(subject, 0);
 
      System.out.println("First state change: 15");   
      subject.setState(15);
      System.out.println("Second state change: 10");  
      subject.setState(10);
   }
}