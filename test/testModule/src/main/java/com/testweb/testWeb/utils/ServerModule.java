package com.testweb.testWeb.utils;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.network.InetAddresses;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetSocketAddress;

public class ServerModule {

    TransportClient client = null;

    public TransportClient getClient(){
        if(client == null){
            synchronized (this){
                if(client == null){
                    client = new ServerModule().transportClient();
                }
            }
        }
        return client;
    }

    private TransportClient transportClient() {
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
        //我用6.3.2版本的时候这里一直报异常说找不到InetSocketTransportAddress类，这应该和jar有关，当我改成5.6.8就不报错了
        TransportClient client = new PreBuiltTransportClient(settings);//6.3.2这里TransportAddress代替InetSocketTransportAddress
        client.addTransportAddress(new InetSocketTransportAddress(
                new InetSocketAddress(InetAddresses.forString("127.0.0.1"), 9300)));
        return client;
    }
}
