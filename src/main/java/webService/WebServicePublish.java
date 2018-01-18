package webService;

import javax.xml.ws.Endpoint;
 

/**
 * @author gacl
 *
 * 发布Web Service
 */
public class WebServicePublish {
 
    public static void main(String[] args) {
        String address = "http://localhost:7000/WS_Server/Webservice";
        Endpoint.publish(address , new MyWebServiceImpl());
        System.out.println("发布webservice成功!"+address);
    }
}