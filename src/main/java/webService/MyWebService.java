package webService;


import javax.jws.WebService;

/**
 * @author gacl
 * 定义SEI(MyWebService EndPoint Interface(终端))
 */
//使用@WebService注解标注WebServiceI接口
@WebService
public interface MyWebService {
 
    //使用@WebMethod注解标注WebServiceI接口中的方法
    String sayHello(String name);
     
    String save(String name,String pwd);
}