package com.example.demo1.utils;

import java.io.Serializable;


/**
 * * 定义返回数据统一封装的类
 * ***************
 * 说明：
 * flag:用作标记是否成功
 * data:返回的数据
 * errCode:错误编码（仅flag为false时有效）
 * errMsg:错误信息（仅flag为false时有效）
 */
public class ResResult implements Serializable {
    private static final long serialVersionUID = -2399353048688907090L;

    /**
     * 成功/失败 状态
     */
    private boolean flag;

    /**
     * 返回的数据
     */
    private Object data;

	/**
     * 错误码
     */
    private String errCode;

    /**
     * 错误信息
     */
    private String errMsg;

    /**
     * 默认构造函数
     */
    public ResResult() {
    }

    public ResResult(boolean flag, Object data, String errCode, String errMsg) {
        this.flag = flag;
        this.data = data;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    /**
     * 成功响应结果
     *
     * @return
     */
    public static ResResult success() {
        return new ResResult(true, null, "-1", "success");
    }

    /**
     * 请求成功时返回的对象
     */
    public static ResResult success(Object data) {
        return new ResResult(true, data, "-1", "success");
    }
    /**
     * 请求失败异常，带占位符的消息
     *
     * @param message 消息类型
     *      占位数据变量
     * @return
     */
    public static ResResult fail(String message) {
        return new ResResult(false, null, "400", message);
    }
    /**
     * 请求失败时返回的对象
     */
    public static ResResult fail(String errCode, String errMsg, String errType) {
        ResResult result = new ResResult();
        result.setFlag(false);
        result.setErrCode(errCode);
        result.setErrMsg(errMsg);
        return result;
    }
    
    /**
     * 请求失败时返回的对象
     */
    public static ResResult fail(String errCode, String errMsg) {
        ResResult result = new ResResult();
        result.setFlag(false);
        result.setErrCode(errCode);
        result.setErrMsg(errMsg);
        return result;
    }
    
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

}