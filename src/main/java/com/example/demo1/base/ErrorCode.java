package com.example.demo1.base;

import com.example.demo1.utils.PropertiesLoader;
import com.example.demo1.utils.ResResult;

import java.text.MessageFormat;


/**
 * @Description: 异常信息
 * @ClassName: ErrorCode
 */
public class ErrorCode {
	private static PropertiesLoader properties = new PropertiesLoader(new String[]{"classpath:error_code.conf"});

    /** PARAM_NULL_ERROR:参数{0}不能为空 */
    public static final String PARAM_NULL_ERROR = "E00120001";

	/**
	 * HTTP状态码
	 */
	public static final String BAD_REQUEST = "400";
	public static final String NOT_AUTHORIZATION = "401";
	public static final String METHOD_NOT_ALLOWED = "405";
	public static final String NOT_ACCEPTABLE = "406";
	public static final String INTERNAL_SERVER_ERROR = "500";
	
	/**
	 * 运行时异常
	 */
	public static final String RUNTIME_EXCEPTION = "2000";
	public static final String NULL_POINTER_EXCEPTION = "2001";
	public static final String CLASS_CAST_EXCEPTION = "2002";
	public static final String IO_EXCEPTION = "2003";
	public static final String NO_SUCH_METHOD = "2004";
	public static final String INDEX_OUT_OF_BOUNDS = "2005";
	public static final String INTERNET_ERROR = "2006";
	
	/**
	* 文件类型错误
	*/
	public static final int FILE_TYPE_ERROR = 1801;
    
	/**
	 *  可在配置文件中定义错误编码对应的信息
	 */
	public static String getMessage(String errCode, Object[] fields) {
		if(fields != null && fields.length > 0) {
			return MessageFormat.format(getMessage(errCode), fields);
		}
		return properties.getProperty(errCode, "加载失败");
	}
	
	/**
	 * 
	 * @param errCode
	 * @param fields
	 * @return
	 */
	public static String getErrorMessage(String errCode, Object... fields) {
		if(fields != null && fields.length > 0) {
			return MessageFormat.format(getMessage(errCode), fields);
		}
		return properties.getProperty(errCode, "加载失败");
	}
	
	/** 
	 * 加载异常信息
	 * @Title: getMessage 
	 * @param errCode
	 * @return String    返回类型 
	 * @lastModify 2018年4月28日
	 */
	public static String getMessage(String errCode) {
		return properties.getProperty(errCode, "加载失败");
	}

    /** 
     * TODO(这里用一句话描述这个方法的作用) 
     * @Title: retParam 
     * @param status
     * @param data
     * @return 设定文件 
     * @return ResultDto    返回类型 
     * @lastModify 2018年4月30日
     */
    public static ResResult retParam(int status,Object[] data) {
        ResResult json = ResResult.fail(String.valueOf(status), getMessage(String.valueOf(status), data));
        return json;
    }
    

    /** 
     * TODO(这里用一句话描述这个方法的作用) 
     * @Title: retParam 
     * @param errorCode
     * @return 设定文件
     * @return ResultDto    返回类型 
     * @lastModify 2018年4月30日
     */
    public static ResResult retParam(String errorCode) {
        ResResult json = ResResult.fail(errorCode, getMessage(String.valueOf(errorCode)));
        return json;
    }
    
    /**
	 *  可在配置文件中定义错误编码对应的信息
	 */
	public static String getMessage(int errCode) {
		return properties.getProperty(String.valueOf(errCode), "加载失败");
	}
}
