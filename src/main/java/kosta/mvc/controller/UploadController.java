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
	 * �Ű������� MultipartFile�� ���� ��������,
	 * xml ������ CommonsMultipartResolver ���� �ʿ��ϴ�.
	 * */
	@RequestMapping("/upload.do")
	public ModelAndView aa(String name, MultipartFile file, HttpSession session) { // form�� <input type="file" name="file"/> name�� �μ� �̸��� ���ƾߵȴ�.
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		
		// ������ �����̸�
		String fileName = file.getOriginalFilename();
		
		// ���ε� �ϱ�
		try {
			file.transferTo(new File(path+"/"+fileName));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		// �������� ÷�ε� ������ ������ ��������.
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
		
		// ���ε�
		try {
			file.transferTo(new File(path+"/"+dto.getFileName()));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return "uploadResult";
	}
	
	/**
	 * �ٿ�ε� ��� ��������
	 * */
	@RequestMapping("/downList.do")
	public ModelAndView down(HttpSession session) {
		//save�����ȿ��� ��� ���(�����̸�)�� �����´�.
		String path =
			session.getServletContext().getRealPath("/WEB-INF/save");
		
		ModelAndView mv = new ModelAndView();
		
		File file = new File(path);
		if(file.exists()) {//�����Ѵٸ� 
			String [] fileNames = file.list();
			mv.addObject("fileNames", fileNames);
		}
		
		mv.setViewName("downList");//WEB-INF/views/downList.jsp�̵�
		return mv;
	}
	
	/**
	 * �ٿ�ε��ϱ�
	 * */
	@RequestMapping("/down.do")
	public ModelAndView cc(String fname, HttpSession session) {
		String path =
				session.getServletContext().getRealPath("/WEB-INF/save");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("fname", new File(path+"/"+fname));
		
		mv.setViewName("downLoadView"); // ���̸�
		return mv;
	}
}