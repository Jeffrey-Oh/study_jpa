package com.sample.apage.manage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sample.apage.manage.repository.ApageManageRepository;
import com.sample.apage.manage.vo.ApageManageVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApageManageService {
    
    @Autowired
    private ApageManageRepository apageManageRepository;

    public List<ApageManageVo> findAll() {
        List<ApageManageVo> members = new ArrayList<>();
        apageManageRepository.findAll().forEach(e -> members.add(e));
        return members;
    }

    public Optional<ApageManageVo> findBySeq(Long seq) {
        Optional<ApageManageVo> member = apageManageRepository.findBySeq(seq);
        return member;
    }

    public void deleteById(Long seq) {
        apageManageRepository.deleteById(seq);
    }

    public ApageManageVo save(ApageManageVo member) {
        apageManageRepository.save(member);
        return member;
    }

    public void updateById(Long seq, ApageManageVo member) {
        Optional<ApageManageVo> e = apageManageRepository.findBySeq(seq);

        if (e.isPresent()) {
            e.get().setSeq(member.getSeq());
            e.get().setName(member.getName());
            apageManageRepository.save(member);
        }
    }
}
