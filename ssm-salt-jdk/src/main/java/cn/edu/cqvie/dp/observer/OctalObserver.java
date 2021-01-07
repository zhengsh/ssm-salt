package cn.edu.cqvie.dp.observer;

public class OctalObserver extends Observer{
 
   public OctalObserver(Subject subject, Integer careNumber){
      this.subject = subject;
      this.careNumber = careNumber;
      this.subject.attach(this);
   }
 
   @Override
   public void update() {
     System.out.println( "Octal String: " 
     + Integer.toOctalString( subject.getState() ) ); 
   }
}