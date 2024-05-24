package com.example.demo.common.catchall;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.example.demo.common.exception.BaseException;
import com.example.demo.exception.BaseData;

/**
 * ResponseHandler
 *
 * @author Frank Zhang
 * @date 2020-11-10 3:18 PM
 */
@SuppressWarnings("rawtypes")
@Component
public class DefaultResponseHandler{
    private static final Logger log = LogManager.getLogger(DefaultResponseHandler.class);

    
    public  Object handle(Class returnType, String errCode, String errMsg){
       
        return handleColaResponse(returnType, errCode, errMsg);
    }

    private static Object handleColaResponse(Class returnType, String errCode, String errMsg) {
        try {
            BaseData response = (BaseData)returnType.newInstance();
            response.setSuccess(false);
            response.setErrCode(errCode);
            response.setReturnMsg(errMsg);
            return response;
        }
        catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return  null;
        }
    }

    // private static boolean isColaResponse(Class returnType) {
    //     return  returnType == Response.class || returnType.getGenericSuperclass() == Response.class;
    // }
}
