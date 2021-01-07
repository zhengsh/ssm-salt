package cn.edu.cqvie.dp.observer;

public abstract class Observer {
   protected Subject subject;
   protected Integer careNumber;
   public abstract void update();
}
