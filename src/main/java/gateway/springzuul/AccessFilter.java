package gateway.springzuul;

import com.netflix.zuul.ZuulFilter;

public class AccessFilter extends ZuulFilter {

	@Override
	public Object run() {
		// TODO Auto-generated method stub
		System.out.println("-------GateWay--------");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";   // pre 在请求路由之前 
	}					// routing 在路由请求时候被调用
						// post 在routing和error过滤器之后被调用
						// error 处理请求时发生错误时被调用

}
