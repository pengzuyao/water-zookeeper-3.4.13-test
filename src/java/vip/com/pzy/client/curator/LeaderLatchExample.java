package com.pzy.client.curator;

import com.google.common.collect.Lists;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.retry.RetryNTimes;

import java.util.List;

/**
 * @Description:
 * @Author: pengzuyao
 * @Time: 2019/07/24
 */
public class LeaderLatchExample {


    public static void main(String[] args) throws Exception {

        List<CuratorFramework> clients = Lists.newArrayList();
        List<LeaderLatch> leaderLatches = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            CuratorFramework client = CuratorFrameworkFactory.newClient("117.48.201.140:2181" ,new RetryNTimes(1 ,1000));
            clients.add(client);
            client.start();

            LeaderLatch leaderLatch = new LeaderLatch(client ,"/leaderLatch" ,"client#" + i);
            leaderLatches.add(leaderLatch);
            leaderLatch.start();
        }




    }
}
