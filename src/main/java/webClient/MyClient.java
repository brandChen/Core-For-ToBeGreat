package webClient;

import webService.MyWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2018/1/9.
 */
public class MyClient {

    public static void main(String[] args) {

        try {
            //服务WSDL Document的地址
            URL url = new URL("http://localhost:7000/WS_Server/Webservice?wsdl");
            //Qnameqname是qualified name 的简写
            //2.构成：由名字空间(namespace)前缀(prefix)以及冒号(:),还有一个元素名称构成
            //由发布的wsdl可知namespace为http://server.ws.platform.whaty.com/，
            QName qname=new QName("http://webService/","MyWebServiceImpl");
            Service service= Service.create(url, qname);
            MyWebService ms=service.getPort(MyWebService.class);
            ms.sayHello("123");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
