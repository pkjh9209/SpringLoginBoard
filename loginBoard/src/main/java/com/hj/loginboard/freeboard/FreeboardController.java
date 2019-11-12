package com.hj.loginboard.freeboard;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.hj.loginboard.freeboard.FreeboardDTO;

@Controller
@RequestMapping(value="/freeboard")
public class FreeboardController {

	@Autowired
	SqlSession ss;
	@Autowired
	FreeboardService service;
	
	//�����Խ���������
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(@RequestParam("pageNum")FreeboardDTO fd,String pageNum,Model model) throws Exception {
		
		cntBoard = service.boardCount();
		List<FreeboardDTO> list = service.list(pageNum);
		model.addAttribute("list",list);
		return "/freeboard/index";
		
	}
	
	//���ۼ�������
	@RequestMapping(value = "/boardWrite.do")
	public String boardWrite(Model model) throws Exception{
		return "/freeboard/boardWrite";
	}
	
	//���ۼ�	
	@RequestMapping(value = "/boardWriteProc.do", method = RequestMethod.POST)
	public String boardWriteProc(FreeboardDTO fd) throws Exception {
		
		service.write(fd);
		return "redirect:/freeboard/index.do";
	}
	
	//�۳���	
	@RequestMapping(value = "/boardView.do", method = RequestMethod.GET)
	public String boardView(@RequestParam("idx") int idx, Model model) throws Exception{
		
		FreeboardDTO fd = service.select(idx);
		model.addAttribute("bdView",fd);
		return "/freeboard/boardView";
	}
	
	//���� ������ 
	@RequestMapping(value = "/boardUpdate.do", method = RequestMethod.GET)
	public String boardUpdate(@RequestParam("boardIdx") int idx, Model model) throws Exception{
		
		FreeboardDTO fd = service.select(idx);
		model.addAttribute("upView",fd);
		return "/freeboard/boardUpdate";
	}
	//���� ������ 	
	@RequestMapping(value = "/boardDelete.do", method = RequestMethod.GET)
	public String boardDelete(@RequestParam("boardIdx") int idx, Model model) throws Exception{
		FreeboardDTO fd = service.select(idx);
		model.addAttribute("delete",fd);
		return "/freeboard/boardDelete";
	}
	
	//�ۼ���
	@RequestMapping(value = "/boardUpdateProc.do",method = RequestMethod.POST)
	public String boardUpdateProc(FreeboardDTO fd) throws Exception{
		
		System.out.println("�����Ϸ�");
		service.update(fd);
		return "redirect:/freeboard/index.do";
	}
	
	//�ۻ���
	@RequestMapping(value = "/boardDeleteProc.do", method = RequestMethod.POST)
	public String boardDeleteProc(@RequestParam("boardIdx") int idx) throws Exception{
		
		System.out.println("�����Ϸ�");
		service.delete(idx);
		return "redirect:/freeboard/index.do";
	}
	
}
