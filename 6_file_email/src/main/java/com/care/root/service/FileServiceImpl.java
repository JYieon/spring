package com.care.root.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.dto.FileDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired FileMapper mapper;
	
	public void fileProcess(MultipartFile file, String id, String name) {
		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);
		
		if(!file.isEmpty()) {
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMDDHHmmss-");
			String sysFileName = fo.format( new Date() );
			sysFileName += file.getOriginalFilename();
			
			dto.setImgFileName(sysFileName);
			
			File f = new File(IMG_REPO + "/" + sysFileName);
			try {
				file.transferTo(f); // 지정된 경로에 파일 저장
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else { //파일이 존재하지 않는 경우
			dto.setImgFileName("nan");
		}
		
		try {
			mapper.save(dto);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<FileDTO> getList(){
		return mapper.getList();
	}
	
	public void delete(String file, String id) {
		int result = 0;
		try {
			result = mapper.delete(id);
			if(result == 1) { //delete 성공적
				File d = new File(IMG_REPO + "/" + file);
				if(d.exists()) { //해당 위치에 접근 가능한가
					d.delete();
				}
				d.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public FileDTO getData(String id) {
		return mapper.getData(id);
	}
	
	public void modify(MultipartFile file, String origin, String id, String name) {
		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);
		
		if(file.isEmpty()) {
			dto.setImgFileName(origin);
		}else {
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMDDHHmmss-");
			String sysFileName = fo.format( new Date() );
			sysFileName += file.getOriginalFilename();
			
			dto.setImgFileName(sysFileName);
			
			File f = new File(IMG_REPO + "/" + sysFileName);
			try {
				file.transferTo(f); 
				File d = new File(IMG_REPO + "/" + origin);
				d.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mapper.modify(dto);
	}
}
