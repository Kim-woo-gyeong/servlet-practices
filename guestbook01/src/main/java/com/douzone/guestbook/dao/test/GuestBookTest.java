package com.douzone.guestbook.dao.test;

import java.util.List;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVo;

public class GuestBookTest {

	public static void main(String[] args) {
//		insertTest();
		deleteTest();
		selectTest();
	}

	public static void insertTest() {
		
		GuestBookVo vo = new GuestBookVo();
		vo.setName("둘리");
		vo.setContents("엄마를 찾아요");
		vo.setPassword("dully");

		new GuestBookDao().insert(vo);
	}
	
	public static void selectTest() {
		List<GuestBookVo> list = new GuestBookDao().findAll();
		for(GuestBookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void deleteTest() {
		
		GuestBookVo vo = new GuestBookVo();
		
		vo.setNo(3L);
		vo.setPassword("dully");

		new GuestBookDao().delete(vo);
	}
}
