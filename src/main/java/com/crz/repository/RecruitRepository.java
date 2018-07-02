package com.crz.repository;

import com.crz.entity.Recruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecruitRepository {

	Page<Recruit> findAll(Pageable pageable);

}
