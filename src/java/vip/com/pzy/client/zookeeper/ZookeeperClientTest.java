package com.pzy.client.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @Description:
 * @Author: pengzuyao
 * @Time: 2019/07/23
 */
public class ZookeeperClientTest {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper client = new ZooKeeper("117.48.201.140:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("链接的时候" + event);
            }
        });

        Stat stat = new Stat();
        /*client.getData("/pzy", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (Event.EventType.NodeDataChanged.equals(event.getType())){
                    System.out.println("数据发生了改变！");
                }
            }
        },stat);*/

        String s = new String(client.getData("/pzy" ,false ,stat));
        System.out.println(s);
        System.out.println(stat.toString());

        client.create("/pzy/a" ,"1".getBytes() ,ZooDefs.Ids.OPEN_ACL_UNSAFE ,CreateMode.PERSISTENT);
        client.getData("/pzy", true, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                System.out.println("111111111111111111");
            }
        } ,null);

        System.in.read();
    }



}
