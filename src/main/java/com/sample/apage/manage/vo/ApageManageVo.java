package com.sample.apage.manage.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="adm_member")
public class ApageManageVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq; // 일련번호
    private String userId; // 아이디
    @Column(columnDefinition = "TEXT")
    private String userPw; // 비밀번호
    @Column(columnDefinition = "TEXT")
    private String userPwEnc; // 비밀번호 암호화 SHA2-256
    private String name; // 이름
    private String tel; // 전화번호
    private String phone; // 휴대폰
    private String email; // 이메일
    private String zipCode; // 우편번호
    private String addr1; // 대표주소
    private String addr2; // 상세주소
    private String remoteIp; // 접근IP
    @Column(columnDefinition = "TEXT")
    private String accessIp; // 허용IP 문자열
    private String level; // 관리자 권한
    @Column(columnDefinition = "DATETIME")
    private String regDate; // 등록일
    @Column(columnDefinition = "DATETIME")
    private String editDate; // 수정일
    @Column(columnDefinition = "DATETIME")
    private String lastLoginDate; // 마지막 로그인 일시
}