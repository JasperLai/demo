package com.example.demo.common.catchall;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.example.demo.common.response.Response;

/**
 * ResponseHandler
 *
 * @author Frank Zhang
 * @date 2020-11-10 3:18 PM
 */
@SuppressWarnings("rawtypes")
@Component
public class DefaultResponseHandler {
    private static final Logger log = LogManager.getLogger(DefaultResponseHandler.class);
    
    public Object handle(Class returnType, String errCode, String errMsg) {
        // 如果返回类型已经是Response，直接返回错误响应
        if (Response.class.isAssignableFrom(returnType)) {
            return Response.error(errCode, errMsg);
        }
        // 如果是其他类型，包装成Response
        return Response.error(errCode, errMsg);
    }
}
