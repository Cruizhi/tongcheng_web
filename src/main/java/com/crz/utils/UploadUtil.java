package com.crz.utils;

import java.io.File;

public class UploadUtil {

	//文件存储路径
	public static String makeDir(String BasePath){
		String DateNow = new DateUtil().getNowDate();
		String path = BasePath + "\\" +DateNow;
		File file = new File(path);
		if(!file.exists())
			file.mkdirs();
		return path;
	}


}
