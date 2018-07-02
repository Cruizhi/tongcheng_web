package com.crz.controller;

import com.crz.entity.Recruit;
import com.crz.service.RecruitService;
import com.crz.utils.ResultVOUtil;
import com.crz.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class RecruitController {

	@Autowired
	private RecruitService recruitServicer;

	@GetMapping("RecruitList")
	public ResultVO<List<Recruit>> getRecruitList(@RequestParam(value = "page", defaultValue = "0") Integer page,
												  @RequestParam(value = "size", defaultValue = "1") Integer size){
		PageRequest request = new PageRequest(page,size);
		Page<Recruit> recruitPage = recruitServicer.getRecruitList(request);
		return ResultVOUtil.success(recruitPage);
	}

}
