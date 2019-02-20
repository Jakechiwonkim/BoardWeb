package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardServiceClientTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class UserServiceClientTest extends TestCase {
	
	public UserServiceClientTest(String testName) {
		super(testName);
	}
	public static Test suite() {
		return new TestSuite(UserServiceClientTest.class);
	}
	public void testUser() {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring 컨테이너로부터 UserServiceImpl 객체를 Lookup 한다.
		UserService userService = (UserService) container.getBean("userService");

		// 3. 로그인 기능 테스트
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");

		UserVO user = userService.getUser(vo);
		if (user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}

		// 4. Spring 컨테이너를 종료한다.
		container.close();
	}
}