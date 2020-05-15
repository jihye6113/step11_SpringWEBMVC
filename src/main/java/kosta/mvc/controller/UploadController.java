package kosta.mvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.UploadDTO;

@Controller
public class UploadController {

	/**
	 * 매개변수로 MultipartFile을 주입 받으려면,
	 * xml 문서에 CommonsMultipartResolver 설정 필요하다.
	 * */
	@RequestMapping("/upload.do")
	public ModelAndView aa(String name, MultipartFile file, HttpSession session) { // form의 <input type="file" name="file"/> name과 인수 이름이 같아야된다.
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		
		// 저장할 파일이름
		String fileName = file.getOriginalFilename();
		
		// 업로드 하기
		try {
			file.transferTo(new File(path+"/"+fileName));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		// 뷰쪽으로 첨부된 파일의 정보를 가져간다.
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uploadResult");
		
		mv.addObject("name", name);
		mv.addObject("fileName", fileName);
		mv.addObject("fileSize", file.getSize());
		mv.addObject("path", path);
		
		return mv;
	}
	
	@PostMapping("/upload2.do")
	public String bb(UploadDTO dto, HttpSession session) {
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		
		MultipartFile file = dto.getFile();
		
		dto.setFileName(file.getOriginalFilename());
		dto.setFileSize(file.getSize());
		
		// 업로드
		try {
			file.transferTo(new File(path+"/"+dto.getFileName()));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return "uploadResult";
	}
	
	/**
	 * 다운로드 목록 가져오기
	 * */
	@RequestMapping("/downList.do")
	public ModelAndView down(HttpSession session) {
		//save폴더안에는 모든 목록(파일이름)을 가져온다.
		String path =
			session.getServletContext().getRealPath("/WEB-INF/save");
		
		ModelAndView mv = new ModelAndView();
		
		File file = new File(path);
		if(file.exists()) {//존재한다면 
			String [] fileNames = file.list();
			mv.addObject("fileNames", fileNames);
		}
		
		mv.setViewName("downList");//WEB-INF/views/downList.jsp이동
		return mv;
	}
	
	/**
	 * 다운로드하기
	 * */
	@RequestMapping("/down.do")
	public ModelAndView cc(String fname, HttpSession session) {
		String path =
				session.getServletContext().getRealPath("/WEB-INF/save");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("fname", new File(path+"/"+fname));
		
		mv.setViewName("downLoadView"); // 뷰이름
		return mv;
	}
}