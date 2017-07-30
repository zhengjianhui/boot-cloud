package com.zjh.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhengjianhui on 17/7/16.
 */
public class AccessFilter extends ZuulFilter {


    /**
     * 过滤器类型，定义过滤会在哪个阶段执行，此处定义为pre 说明会在路由前执行
     *
     * pre      可以在请求被路由之前调用
     * routing  在路由请求时被调用
     * post     在routing 和 error 过滤器之后被调用
     * error    处理请求时发生错误时被调用
     *
     *
     * @return 请求的类型
     */
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序，根据返回值来判断过滤器的执行顺序
     *
     * @return 执行的顺序
     */
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要执行
     *
     * @return 是否需要执行该过滤器
     */
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体的过滤逻辑
     *
     * @return
     */
    public Object run() {
        RequestContext cxt = RequestContext.getCurrentContext();
        HttpServletRequest request = cxt.getRequest();

        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            // 设置返回码
            cxt.setResponseStatusCode(401);
            // 设置返回的body
            cxt.setResponseBody("access token is empty");

        }

        return null;
    }
}
