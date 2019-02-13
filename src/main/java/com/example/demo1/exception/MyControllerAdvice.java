package com.example.demo1.exception;

import com.example.demo1.base.ErrorCode;
import com.example.demo1.utils.ResResult;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.Set;

/**
 * controller 增强器
 */
@ControllerAdvice
public class MyControllerAdvice {
    
    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResResult runtimeExceptionHandler(RuntimeException runtimeException) {  
        runtimeException.printStackTrace();
        return ErrorCode.retParam(2000, null);
    }  

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResResult nullPointerExceptionHandler(NullPointerException ex) {  
        ex.printStackTrace();
        return ErrorCode.retParam(2001, null);
    }   
    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public ResResult classCastExceptionHandler(ClassCastException ex) {  
        ex.printStackTrace();
        return ErrorCode.retParam(2002, null);  
    }  

    //IO异常
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public ResResult iOExceptionHandler(IOException ex) {  
        ex.printStackTrace();
        return ErrorCode.retParam(2003, null); 
    }  
    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public ResResult noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        ex.printStackTrace();
        return ErrorCode.retParam(2004, null);
    }  

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public ResResult indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {  
        ex.printStackTrace();
        return ErrorCode.retParam(2005, null);
    }
    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ResResult requestNotReadable(HttpMessageNotReadableException ex){
        System.out.println("400..requestNotReadable");
        ex.printStackTrace();
        return ErrorCode.retParam(400, null);
    }
    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public ResResult requestTypeMismatch(TypeMismatchException ex){
        System.out.println("400..TypeMismatchException");
        ex.printStackTrace();
        return ErrorCode.retParam(400, null);
    }
    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public ResResult requestMissingServletRequest(MissingServletRequestParameterException ex){
        System.out.println("400..MissingServletRequest");
        ex.printStackTrace();
        return ErrorCode.retParam(400, null);
    }
    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public ResResult request405(){
        System.out.println("405...");
        return ErrorCode.retParam(405, null);
    }
    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public ResResult request406(){
        System.out.println("404...");
        return ErrorCode.retParam(406, null);
    }
    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class,HttpMessageNotWritableException.class})
    @ResponseBody
    public ResResult server500(RuntimeException runtimeException){
        System.out.println("500...");
        return ErrorCode.retParam(406, null);
    }
    
    /** 
     * 参数check异常
     * @Title: userExceptionHandler 
     * @param ex 异常内容
     * @return ResResult    返回类型 
     * @lastModify 2018年4月30日
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResResult baseExceptionHandler(BaseException ex) {  
        ex.printStackTrace();
        return ErrorCode.retParam(ex.getMessage());
    }
    
    /** 
     * 输出错误信息
     * @Title: userExceptionHandler 
     * @param ex 异常内容
     * @return ResResult    返回类型 
     * @lastModify 2018年4月30日
     */
    @ExceptionHandler(BaseMsgException.class)
    @ResponseBody
    public ResResult baseMsgExceptionHandler(BaseMsgException ex) {  
        ex.printStackTrace();
        return ResResult.fail("500",ex.getMessage());
    }
    
    /** 
     * 参数check异常
     * @Title: userExceptionHandler 
     * @param ex 异常内容
     * @return ResResult    返回类型 
     * @lastModify 2018年4月30日
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResResult baseExceptionHandler(IllegalArgumentException ex) {  
        ex.printStackTrace();
        return ResResult.fail(ErrorCode.PARAM_NULL_ERROR, ex.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResResult handleException(Exception e){
        //Hibernate Validator验证消息返回
        BindingResult result = null;
        if (e instanceof MethodArgumentNotValidException){
            result = ((MethodArgumentNotValidException) e).getBindingResult();
        } else if (e instanceof BindException){
            result = ((BindException) e).getBindingResult();
        } else if (e instanceof ConstraintViolationException){
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();
            StringBuilder errorMsg = new StringBuilder();
            for (ConstraintViolation<?> violation : constraintViolations) {
                errorMsg.append(violation.getMessage());
                break;
            }
            errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
            return ResResult.fail(ErrorCode.PARAM_NULL_ERROR,errorMsg.toString());
        }
        if (result != null) {
            StringBuilder errorMsg = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errorMsg.append(error.getDefaultMessage()).append(",");
                break;
            }
            errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
            return ResResult.fail(ErrorCode.PARAM_NULL_ERROR,errorMsg.toString());
        }
     
        return ResResult.fail(ErrorCode.PARAM_NULL_ERROR, e.getMessage());
    }

}
