package com.care.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao = new MemberDAO();

	public MemberService() {
	}
	
	public void setList(MemberDTO list) {
		dao.setList(list);
	}
	
	public ArrayList<MemberDTO> getList() {
		return dao.getList();
	}

}
