package com.crz.controller;

import com.crz.entity.User;
import com.crz.repository.UserRepository;
import com.crz.service.UserService;
import com.crz.utils.ResultVOUtil;
import com.crz.utils.UploadUtil;
import com.crz.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/getAllUser")
	public List<User> getAll(){
		List<User> userList = new ArrayList<>();
		userList = userRepository.findAll();
		return userList;
	}

	//用户登录服务
	@PostMapping("/LoginServlet")
	public ResultVO<User> Login(@RequestParam("userid")String userid,
						  @RequestParam("password")String password){
		User user = userService.findUser(userid,password);
		return ResultVOUtil.success(user);
	}

	//用户注册服务
	@PostMapping("/RegisterServlet")
	public ResultVO Register(@RequestParam("user")User user){
		User user1  = userService.saveUser(user);
		return ResultVOUtil.success("true");
	}

	@PostMapping("/UserDetail")
	@ResponseBody
	public ResultVO UserDetail(HttpServletRequest request){
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
					String filePath = UploadUtil.makeDir(basePath)+"\\"+filename;
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
					return ResultVOUtil.error(500,"failed to "+i+"-->"+e.getMessage()) ;
				}
			}else{
				return ResultVOUtil.error(0,"上传失败");
			}
		}
		return ResultVOUtil.success("true"+basePath);
	}
}
