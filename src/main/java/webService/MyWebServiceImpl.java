package webService;

import javax.jws.WebService;

/**
 * @author www.vxzsk.com
 * SEI的具体实现
 */
//使用@WebService注解标注WebServiceI接口的实现类WebServiceImpl
@WebService(endpointInterface= "webService.MyWebService",serviceName="MyWebServiceImpl")
public class MyWebServiceImpl implements MyWebService {
 
    @Override
    public String sayHello(String name) {
        System.out.println("MyWebService sayHello "+name);
        return "sayHello "+name;
    }
 
    @Override
    public String save(String name, String pwd) {
        System.out.println("MyWebService save "+name+"， "+pwd);
        return "save Success";
    }
}