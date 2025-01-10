package com.care.root.member.service;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public int loginCheck(String id, String pwd);
	public ArrayList<MemberDTO>  getList();
	public MemberDTO getMember(String id);
	public int register( MemberDTO dto );
	public void keepLogin(String sessionId, String id);
	public MemberDTO getSessionId(String sessionId);
}









