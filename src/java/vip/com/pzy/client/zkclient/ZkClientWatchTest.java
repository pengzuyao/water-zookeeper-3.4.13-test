package com.pzy.client.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

/**
 * @Description:
 * @Author: pengzuyao
 * @Time: 2019/07/23
 */
public class ZkClientWatchTest {

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient("117.48.201.140:2181" , 10000 , 10000 , new SerializableSerializer());
            zkClient.writeData("/pzy" ,"5");
            zkClient.delete("/pzyp");
    }
}
