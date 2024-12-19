package com.example.demo.common.catchall;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import com.example.demo.common.exception.BizException;
import com.example.demo.common.exception.SysException;
import com.example.demo.common.response.Response;

/**
 * ResponseHandler - 统一异常处理
 */
@Component
public class DefaultResponseHandler {
    private static final Logger log = LogManager.getLogger(DefaultResponseHandler.class);
    
    public Object handle(Class<?> returnType, Throwable e) {
        if (e instanceof BizException) {
            // 业务异常
            BizException biz = (BizException) e;
            log.warn("业务异常: {}", biz.getMessage());
            return Response.fail(biz.getErrCode(), biz.getMessage());
        } 
        else if (e instanceof DataAccessException) {
            // 数据库相关异常
            log.error("数据库访问异常: {}", e.getMessage(), e);
            return Response.fail("DB_ERROR", "数据库访问异常");
        }
        // HttpClient网络相关异常
        else if (e instanceof ResourceAccessException || e instanceof SocketTimeoutException) {
            log.error("网络超时: {}", e.getMessage(), e);
            return Response.fail("NETWORK_TIMEOUT", "网络超时，请稍后重试");
        }
        else if (e instanceof ConnectException) {
            log.error("网络连接失败: {}", e.getMessage(), e);
            return Response.fail("NETWORK_ERROR", "网络连接失败，请检查网络");
        }
        else if (e instanceof SocketException) {
            log.error("网络连接异常: {}", e.getMessage(), e);
            return Response.fail("NETWORK_ERROR", "网络连接异常，请稍后重试");
        }
        else if (e instanceof SysException) {
            // 系统异常
            SysException sys = (SysException) e;
            log.error("系统异常: {}", sys.getMessage(), sys);
            return Response.fail(sys.getErrCode(), "系统异常，请联系管理员");
        }
        // 其他未知异常
        else {
            log.error("未知异常: ", e);
            return Response.fail("SYSTEM_ERROR", "系统异常，请联系管理员");
        }
    }
}
