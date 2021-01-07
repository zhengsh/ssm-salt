package cn.edu.cqvie.dp.observer;

public class HexaObserver extends Observer{
 
   public HexaObserver(Subject subject, Integer careNumber){
      this.subject = subject;
      this.careNumber = careNumber;
      this.subject.attach(this);
   }
 
   @Override
   public void update() {
      System.out.println( "Hex String: " 
      + Integer.toHexString( subject.getState() ).toUpperCase() ); 
   }
}