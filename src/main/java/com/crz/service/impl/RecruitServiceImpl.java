package com.crz.service.impl;

import com.crz.entity.Recruit;
import com.crz.repository.RecruitRepository;
import com.crz.service.RecruitService;
import org.hibernate.id.insert.InsertGeneratedIdentifierDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService{

	@Autowired
	private RecruitRepository recruitRepository;

	@Override
	public Page<Recruit> getRecruitList(Pageable pageable) {
		return recruitRepository.findAll(pageable);
	}
}
