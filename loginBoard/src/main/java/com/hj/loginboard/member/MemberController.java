package com.hj.loginboard.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hj.loginboard.member.MemberDTO;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	@Autowired
	SqlSession ss;
	@Autowired
	MemberService mbService;
	@RequestMapping(value = "/index.do")
	public String index(Model model) {
		
		return "member/index";
	}
	
	//�α��� ȭ��
	@RequestMapping(value = "/login.do")
	public String login(Model model) {
		return "member/login";
	}
	
	//�α��ε�����
	@RequestMapping(value="/loginProc.do",method = RequestMethod.POST)
	public String memberlogin(MemberDTO md,HttpServletRequest req,RedirectAttributes rttr)throws Exception{
		
		HttpSession session = req.getSession();
		MemberDTO login = mbService.memberLogin(md);
		
		if(login == null) {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg",false);
		}else{
			session.setAttribute("user", login);
		}
		
		return "redirect:/";
	}
	//���̵� üũ
	@ResponseBody
	@RequestMapping(value = "/idCheck.do",method = RequestMethod.POST)
	public int idCheck(HttpServletRequest req) throws Exception {
		
		 String userId = req.getParameter("userId");
		 MemberDTO idCheck =  mbService.idCheck(userId);
		 
		 int result = 0;
		 
		 if(idCheck != null) {
		  result = 1;
		 } 
		 
		 return result;
		
	}
	//�α׾ƿ�
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	//ȸ������ ȭ��
	@RequestMapping(value = "/insert.do")
	public String insert(Model model) {
		return "member/insert";
	}
	
	//ȸ������ ������ ����
	@RequestMapping(value = "/insertProc.do",method = RequestMethod.POST)
	public String insertProc(MemberDTO md) throws Exception{
		mbService.memeberInsert(md);
		return "redirect:/";
	}
	
	//ȸ������ ȭ��
	@RequestMapping(value = "/update.do",method = RequestMethod.POST)
	public String update(MemberDTO md,Model model) throws Exception{
		MemberDTO resultMd = mbService.memberSelet(md);
		model.addAttribute("upMember",resultMd);
		return "member/update";
	}
	//ȸ������
	@RequestMapping(value = "/updateProc.do",method = RequestMethod.POST)
	public String updateProc(MemberDTO md) throws Exception{
		System.out.println(md);
		mbService.memberUpdate(md);
		return "redirect:/";
	}
	//ȸ��Ż�� ������
	@RequestMapping(value = "/delete.do",method = RequestMethod.GET)
	public String delete() throws Exception{

		return "member/delete";
	}
	@RequestMapping(value = "/delete.do",method = RequestMethod.POST)
	public String deleteProc(HttpSession session,MemberDTO md,RedirectAttributes rttr) throws Exception{
		MemberDTO member = (MemberDTO)session.getAttribute("user");
		
		String inPw = member.getUserPw();
		String dbPw = md.getUserPw();
		
		if(!(inPw.equals(dbPw))) {
			rttr.addFlashAttribute("msg",false);
			return "redirect:/member/delete.do";
		}else {
			mbService.memberDelete(md);
			session.invalidate();
			return "redirect:/";
		}
	}
}