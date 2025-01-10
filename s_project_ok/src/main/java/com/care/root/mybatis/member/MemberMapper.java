package com.care.root.mybatis.member;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO getMember(String id);
	public ArrayList<MemberDTO> getList();
	public ArrayList<MemberDTO> getData(@Param("bbb") String id);
	public int register( MemberDTO dto );
	public void keepLogin(@Param("sessionId") String sessionId, @Param("id") String id);
//	두개 이상의 값 전달시 param으로 xml에서 사용할 변수명 지정
	public MemberDTO getSessionId(String sessionId);
}









