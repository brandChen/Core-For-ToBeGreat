package Redis;

import redis.clients.jedis.Jedis;

/**
 * @author chenyuan
 * @version 创建时间：2017年11月13日 下午1:58:50
 * @ClassName 类名称
 * @Description 类描述
 */
public class Test {
    public static void main(String[] args) {
        try {
            String host = "localhost";// 控制台显示访问IP地址
            int port = 6379;
            Jedis jedis = new Jedis(host, port);
            // 鉴权信息
            jedis.auth("123");// password
            String key = "redis";
            String value = "aliyun-redis1";
            // select db默认为0
            jedis.select(1);
            // set一个key
            jedis.set(key, value);
            System.out.println("Set Key " + key + " Value: " + value);
            // get 设置进去的key
            String getvalue = jedis.get(key);
            System.out.println("Get Key " + key + " ReturnValue: " + getvalue);
            jedis.quit();
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}