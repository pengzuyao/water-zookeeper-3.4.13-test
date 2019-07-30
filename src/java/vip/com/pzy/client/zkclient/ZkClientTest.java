package com.pzy.client.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.io.IOException;

/**
 * @Description:
 * @Author: pengzuyao
 * @Time: 2019/07/23
 */
public class ZkClientTest {

    public static void main(String[] args) throws IOException {
        ZkClient zkClient = new ZkClient("117.48.201.140:2181" , 10000 , 10000 , new SerializableSerializer());
        zkClient.createPersistent("/pzyp" ,"1".getBytes());
        zkClient.subscribeDataChanges("/pzy", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("数据被改变了！");
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("数据被删除了！");
            }
        });

        System.in.read();
    }
}
