package cn.edu.cqvie.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class ZookeeperTest {

    /**
     * connectString 连接地址可以写多个，比如"127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183",当客户端与服务端的Socket连接断掉后就会重试去连其他的服务器地址
     * sessionTimeout 客户端设置的话会超时时间
     * watcher 监听器
     */
    private static ZooKeeper zooKeeper;

    static {
        try {
            zooKeeper = new ZooKeeper("192.168.40.52:2181", 60 * 1000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ZookeeperTest() {
    }

    public static void main(String[] args) throws KeeperException, InterruptedException {
        // 创建一个节点，并设置内容，设置ACL(该节点的权限设置)，
        // 节点类型（7种：持久节点、临时节点、持久顺序节点、临时顺序节点、容器节点、TTL节点、TTL顺序节点）
        String result = zooKeeper.create("/luban123", "123".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(result);

        Stat stat = new Stat();
        byte[] data = zooKeeper.getData("/luban123", false, stat);
        System.out.println(new String(data));

        stat = zooKeeper.exists("/luban1234", false);
        System.out.println(stat);  // 如果节点不存在，则stat为null

        // 修改节点的内容，这里有乐观锁,version表示本次修改, -1表示不检查版本强制更新
        // stat表示修改数据成功之后节点的状态
        stat = zooKeeper.setData("/luban", "xxx".getBytes(), -1);

        // 删除节点
        zooKeeper.delete("/luban123", -1);


        // 创建子节点
        result = zooKeeper.create("/luban/luban123", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(result);

        // 获取子节点
        stat = new Stat();
        List<String> children = zooKeeper.getChildren("/luban", false, stat);
        System.out.println(children);
    }
}
