package com.demo.springbootmybatis.exception.handler;

import com.alibaba.fastjson.JSONObject;
import com.demo.springbootmybatis.model.common.ResponseResult;
import com.demo.springbootmybatis.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
@Slf4j
public class DefaultExceptionHandler {
    private static final String UTF8 = "UTF-8";
    private static final String RESPONSE_CONTENT_TYPE = "text/json;charset=UTF-8";

    @ExceptionHandler(BindException.class)
    public void processValidationError(HttpServletResponse response, BindException ex) {
        response.setCharacterEncoding(UTF8);
        response.setContentType(RESPONSE_CONTENT_TYPE);
        response.setStatus(200);
        BindingResult result = ex.getBindingResult();
        HashMap<String, String> fieldErrors = processFieldErrors(result.getFieldErrors());
        try (PrintWriter writer = response.getWriter();) {
            ResponseResult resp = new ResponseResult();
            resp.setStatus(400);
            resp.setMessage(JSONObject.toJSONString(fieldErrors));
            writer.write(JSONObject.toJSONString(resp));
        } catch (IOException e) {
            log.error("", e);
        }
    }

    @ExceptionHandler(BaseException.class)
    public void processAPIError(HttpServletResponse response, BaseException ex) {
        log.error("异常堆栈信息, ", ex);
        response.setCharacterEncoding(UTF8);
        response.setContentType(RESPONSE_CONTENT_TYPE);
        response.setStatus(200);
        PrintWriter writer = null;
        try {
            ResponseResult resp = new ResponseResult();
            resp.setStatus(ex.getCode());
            resp.setMessage(ex.getMessage());
            writer = response.getWriter();
            writer.write(JSONObject.toJSONString(resp));
        } catch (IOException e) {
            log.error("", e);
        } finally {
            if (null != writer) {
                writer.close();
            }
        }
    }

    @ExceptionHandler(Exception.class)
    public void processError(HttpServletResponse response, Exception ex) {
        log.error("异常堆栈信息, ", ex);
        response.setCharacterEncoding(UTF8);
        response.setContentType(RESPONSE_CONTENT_TYPE);
        response.setStatus(200);
        PrintWriter writer = null;
        try {
            ResponseResult resp = new ResponseResult();
            resp.setStatus(500);
            resp.setMessage("服务器异常");

            writer = response.getWriter();
            writer.write(JSONObject.toJSONString(resp));
        } catch (IOException e) {
            log.error("", e);
        } finally {
            if (null != writer) {
                writer.close();
            }
        }
    }

    private HashMap<String, String> processFieldErrors(List<FieldError> fieldErrors) {
        HashMap<String, String> fieldErrorsMap = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            fieldErrorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return fieldErrorsMap;
    }
}