package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.care.root.service.FileService;

@Controller
public class FileController {
	
	@Autowired FileService fs;

	@GetMapping("form")
	public String form() {
		return "uploadForm";
	}
	
	@PostMapping("upload")
	public String upload(MultipartHttpServletRequest mul, String id, String name, MultipartFile file) {
		fs.fileProcess(file, id, name);
		
		/*
		 * System.out.println("id : " + id); System.out.println("name : " + name);
		 * System.out.println("file : " + file.getOriginalFilename());
		 * System.out.println("----------------"); System.out.println("id : " +
		 * mul.getParameter("id")); System.out.println("mul.name : "
		 * +mul.getParameter("name") ); MultipartFile mf = mul.getFile("file");
		 * System.out.println("mf.file : " + mf.getOriginalFilename());
		 */
		return "redirect:form";
	}
	
	@GetMapping("views")
	public String views(Model model) {
		model.addAttribute("list", fs.getList());
		return "result";
	}
	
	@GetMapping("download")
	public void download(String file, HttpServletResponse res) throws Exception {
		res.addHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(file, StandardCharsets.UTF_8));
		File downFile = new File(FileService.IMG_REPO + "/" + file); //file을 불러오기 위한 위치 설정
		FileInputStream in = new FileInputStream(downFile); //해당 위치의 파일 가져오기
		FileCopyUtils.copy(in, res.getOutputStream()); //해당 위치 파일을 사용자에게 응답
		in.close();
	}
	
	@GetMapping("delete")
	public String delete(String file, String id) {
		fs.delete(file, id);
		return "redirect:views";
	}
	
	@GetMapping("modify_form")
	public String modify_form(Model model, String id) {
		model.addAttribute("info", fs.getData(id));
		return "modify_form";
	}
	
	@PostMapping("modify")
	public String modify(MultipartFile file, String origin, String id, String name) {
		fs.modify(file, origin, id, name);
		return "redirect:views";
	}
}
