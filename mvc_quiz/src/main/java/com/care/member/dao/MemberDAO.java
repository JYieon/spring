package com.care.member.dao;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.care.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	private ArrayList<MemberDTO> list;
	
	public MemberDAO() {
		list = new ArrayList<MemberDTO>();
	}
	
	public void setList(MemberDTO dto) {
		list.add(dto);
	}
	
	public ArrayList<MemberDTO> getList() {
		return list;
	}

}
