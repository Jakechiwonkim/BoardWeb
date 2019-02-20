package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BoardServiceClientTest extends TestCase {
	public BoardServiceClientTest(String testName) {
		super(testName);
	}
	public static Test suite() {
		return new TestSuite(BoardServiceClientTest.class);
	}
	public void testBoard() {
		
	}
	
	private void doit() {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring 컨테이너로부터 BoardServiceImpl 객체를 Lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용..............");
		boardService.insertBoard(vo);

		// 4. 글 목록 검색 기능 테스트		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}

		// 5. Spring 컨테이너 종료
		container.close();
	}
}