package cn.edu.cqvie.dp.observer;

public class BinaryObserver extends Observer{
 
   public BinaryObserver(Subject subject, Integer careNumber){
      this.subject = subject;
      this.careNumber = careNumber;
      this.subject.attach(this);
   }
 
   @Override
   public void update() {
      System.out.println( "Binary String: " 
      + Integer.toBinaryString( subject.getState() ) ); 
   }
}