package cn.edu.cqvie.dp.observer;

import cn.edu.cqvie.dp.notify.Lock;

public class ThreadObserver extends Observer{

   protected Lock object;

   public ThreadObserver(Subject subject, Integer careNumber, Lock object){
      this.subject = subject;
      this.careNumber = careNumber;
      this.object = object;
      this.subject.attach(this);
   }
 
   @Override
   public void update() {
      System.out.println( "Thread String: " + Integer.toBinaryString( subject.getState() ) );
      try {
         Thread.sleep(20000L);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      synchronized (this.object) {
         this.object.lockCode = String.valueOf(System.currentTimeMillis());
         this.object.notifyAll();
      }
   }
}