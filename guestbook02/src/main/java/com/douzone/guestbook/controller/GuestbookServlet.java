package com.douzone.guestbook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVo;

public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String action = request.getParameter("a");
		
		if("add".equals(action)) {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String contents = request.getParameter("message");
			
			if("".equals(name)) {
				
				pw.println("<script>alert('이름을 입력하세요.');location.href='"+request.getContextPath()+"/gb';</script>");
				pw.flush();
				
			} else if("".equals(password)) {
				
				pw.println("<script>alert('비밀번호를 입력하세요.');location.href='"+request.getContextPath()+"/gb';</script>");
				pw.flush();
				
			} else if("".equals(contents)) {
				pw.println("<script>alert('내용을 입력하세요.');location.href='"+request.getContextPath()+"/gb';</script>");
				pw.flush();
			} else {
				GuestBookVo vo = new GuestBookVo();
				vo.setName(name);
				vo.setPassword(password);
				vo.setContents(contents);
				
				new GuestBookDao().insert(vo);
				
				response.sendRedirect(request.getContextPath()+"/gb");
			}
			
		} else if("deleteform".equals(action)) {
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
			
		} else if("delete_check".equals(action)) {
			
			Long no = Long.parseLong(request.getParameter("no"));
			String password = request.getParameter("password");
			
			GuestBookVo vo = new GuestBookVo();
			vo.setNo(no);
			vo.setPassword(password);
			
			
			Boolean result = new GuestBookDao().delete(vo);

			if(result){
				response.sendRedirect(request.getContextPath()+"/gb");		
			} else {
				pw.println("<script>alert('비밀번호가 틀렸습니다');location.href='/guestbook02/gb?a=deleteform&&no="+vo.getNo()+"';</script>");
				pw.flush();
			}
			
		} else {
			List<GuestBookVo> list = new GuestBookDao().findAll();
			
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
