/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.iflytek.sgy.znsj.sj.common.util 
 * @author: Jack Ma
 * @date: 2018年10月1日 上午11:52:14 
 */
package com.example.demo1.utils;

/**
 * @author
 * @Description: TODO
 * @date: 2018年10月1日 上午11:52:14
 */
public class SysCode {
	public static String YES = "1";
	public static String NO = "0";
	public static String YES_TXT = "是";
	public static String NO_TXT = "否";

	// 图片上传的类型
	public static String[] fileTypes = new String[] { "jpg", "gif", "bmp", "png",
			"jpeg", "JPG", "GIF", "BMP", "PNG", "JPEG", "ico", "ICO"};
	// 视频上传的类型
	public static String[] audioTypes = new String[] { "mp4","flv", "MP4","FLV"};
	
	/**
	 * 数据库类型
	 * @author admin
	 *
	 */
	public static interface JDBC_TYPE{
		String ORACLE = "oracle";
		String MYSQL = "mysql";
	}
}
