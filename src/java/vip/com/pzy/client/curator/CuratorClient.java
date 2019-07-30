package com.pzy.client.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @Description:
 * @Author: pengzuyao
 * @Time: 2019/07/23
 */
public class CuratorClient {

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient("117.48.201.140:2181" , new RetryNTimes(3 ,1000));
        client.start();
        //client.create().forPath("/data" ,"3".getBytes());

        String path = "/pathp";
        NodeCache nodeCache = new NodeCache(client ,path);
        nodeCache.start(true);
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("22222222222222222");
            }
        });

        client.getData().usingWatcher(new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("用的是watch");
            }
        }).forPath(path);

        System.in.read();
    }
}
