package com.crz.service;

import com.crz.entity.Recruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecruitService {

	Page<Recruit> getRecruitList(Pageable pageable);

}
