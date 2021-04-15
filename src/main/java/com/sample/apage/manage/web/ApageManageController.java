package com.sample.apage.manage.web;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.sample.apage.manage.service.ApageManageService;
import com.sample.apage.manage.vo.ApageManageVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apageManage")
public class ApageManageController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApageManageService apageManageService;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<ApageManageVo>> getAllmembers() {
        List<ApageManageVo> member = apageManageService.findAll(); return new ResponseEntity<List<ApageManageVo>>(member, HttpStatus.OK);
    }

    @GetMapping(value = "/{seq}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ApageManageVo> getMember(@PathVariable("seq") Long seq) {
        Optional<ApageManageVo> member = apageManageService.findBySeq(seq);
        return new ResponseEntity<ApageManageVo>(member.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{seq}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteMember(@PathVariable("seq") Long seq) {
        apageManageService.deleteById(seq);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{seq}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ApageManageVo> updateMember(@PathVariable("seq") Long seq, ApageManageVo member) {
        apageManageService.updateById(seq, member);
        return new ResponseEntity<ApageManageVo>(member, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApageManageVo> save(ApageManageVo member) {
        return new ResponseEntity<ApageManageVo>(apageManageService.save(member), HttpStatus.OK);
    }

    @RequestMapping(value="/saveMember", method = RequestMethod.GET)
    public ResponseEntity<ApageManageVo> save(HttpServletRequest req, ApageManageVo member) {
        return new ResponseEntity<ApageManageVo>(apageManageService.save(member), HttpStatus.OK);
    }

}