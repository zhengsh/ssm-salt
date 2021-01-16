//package cn.edu.cqvie.redis;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProcessMessagesChannelTwo {
//
//    public synchronized void monitorBroadcast(String message) {
//        try {
//            System.out.println("我监听到频道2的消息啦,消息是:" + message);
//        } catch (Exception e) {
//            System.out.println("消息监听失败啦~~~~~~~");
//        }
//    }
//}