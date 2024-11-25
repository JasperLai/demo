package com.example.demo.common.catchall;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

import java.net.ConnectException;
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
            return Response.error(biz.getErrCode(), biz.getMessage());
        } 
        else if (e instanceof DataAccessException) {
            // 数据库相关异常
            log.error("数据库访问异常: {}", e.getMessage(), e);
            return Response.error("DB_ERROR", "数据库访问异常");
        }
        // 网络相关异常
        else if (e instanceof ResourceAccessException) {
            // ResourceAccessException 包装了具体的网络异常
            Throwable cause = e.getCause();
            if (cause instanceof SocketTimeoutException) {
                log.error("网络超时: {}", e.getMessage(), e);
                return Response.error("NETWORK_TIMEOUT", "网络超时，请稍后重试");
            } else if (cause instanceof ConnectException) {
                log.error("网络连接失败: {}", e.getMessage(), e);
                return Response.error("NETWORK_ERROR", "网络连接失败，请检查网络");
            }
            // 其他网络异常
            log.error("网络访问异常: {}", e.getMessage(), e);
            return Response.error("NETWORK_ERROR", "网络访问异常，请稍后重试");
        }
        else if (e instanceof RestClientException) {
            // 其他REST调用异常
            log.error("远程服务调用异常: {}", e.getMessage(), e);
            return Response.error("RPC_ERROR", "远程服务调用异常");
        }
        else if (e instanceof SysException) {
            // 系统异常
            SysException sys = (SysException) e;
            log.error("系统异常: {}", sys.getMessage(), sys);
            return Response.error(sys.getErrCode(), "系统异常，请联系管理员");
        }
        // 其他未知异常
        else {
            log.error("未知异常: ", e);
            return Response.error("SYSTEM_ERROR", "系统异常，请联系管理员");
        }
    }
}
