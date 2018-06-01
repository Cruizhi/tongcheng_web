package com.crz.controller;

import com.crz.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class ReceiveImagesController {


	@PostMapping("/ReceiveImages")
	public @ResponseBody String ReceiveImages(HttpServletRequest request){
		MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("mFile");
		MultipartFile file = null;

		//存储的基本路径
		String basePath = request.getServletContext().getRealPath("/images");
		for(int i = 0;i < files.size(); i++){
			file = files.get(i);
			if(!file.isEmpty()){
				log.info("receiveimage name is :"+file.getName());
				try{
					String filename = file.getOriginalFilename();
					//图片存储的路径
					String filePath = makeDir(basePath)+"\\"+filename;
					log.info("图片存储路径为："+filePath);
					byte[] bytes = file.getBytes();

					File file1 = new File(filePath);
					InputStream inputStream = file.getInputStream();
					BufferedInputStream fis = new BufferedInputStream(inputStream);
					FileOutputStream fos = new FileOutputStream(file1);
					log.info("文件原名为："+file.getOriginalFilename());
//					fos.write(bytes);
					int f;
					while((f = fis.read()) != -1){
						fos.write(f);
					}
					fos.flush();
					fos.close();
					fis.close();
				}catch(Exception e){
					return "failed to "+i+"-->"+e.getMessage();
				}
			}else{
				return "false";
			}
		}
		return "true"+basePath;
	}

	@PostMapping("/upload")
	@ResponseBody
	public String upload(HttpServletRequest request,
						 MultipartFile[] file) {
		try{
			//上传文件目录
			String uploadDir = request.getSession().getServletContext().getRealPath("/")+"/upload";
			File dir = new File(uploadDir);
			if(!dir.exists()){
				dir.mkdirs();
			}
			//遍历文件数组实现上传
			for(int i = 0;i<file.length;i++){
				if(file[i] != null){
					//调用上传方法
					executeUpload(uploadDir,file[i]);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
				return "上传失败";
		}
		return "上传成功";
	}

	private void executeUpload(String uploadDir,MultipartFile file)throws Exception{
		//文件后缀名
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		//上传文件名
		String filename = UUID.randomUUID()+ suffix;
		//服务器端保存的文件对象
		File serverFile = new File(uploadDir+filename);
		//将上传文件写入服务器端文件内
		file.transferTo(serverFile);
	}

	//文件存储路径
	private String makeDir(String BasePath){
		String DateNow = new DateUtil().getNowDate();
		String path = BasePath + "\\" +DateNow;
		File file = new File(path);
		if(!file.exists())
			file.mkdirs();
		return path;
	}
}
