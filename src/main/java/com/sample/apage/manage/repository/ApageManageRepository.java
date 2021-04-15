package com.sample.apage.manage.repository;

import java.util.List;
import java.util.Optional;

import com.sample.apage.manage.vo.ApageManageVo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApageManageRepository extends JpaRepository<ApageManageVo, Long> {
    
    public Optional<ApageManageVo> findBySeq(Long seq);

    public List<ApageManageVo> findByUserId(String userId);

    public List<ApageManageVo> findByName(String name);
    
}
