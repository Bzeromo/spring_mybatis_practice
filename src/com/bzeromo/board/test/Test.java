package com.bzeromo.board.test;

import com.bzeromo.board.config.MyAppSqlConfig;
import com.bzeromo.board.model.dao.BoardDao;
import com.bzeromo.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		//이제 굳이 Impl을 따로 구현할 필요 없다!
		BoardDao dao = MyAppSqlConfig.getSession().getMapper(BoardDao.class);
	
//		//게시글 추가
//		Board board = new Board("하 myBatis 쉽네요", "박모씨", "So EZ ㅋㅋ");
//		dao.insertBoard(board);
//		
		//게시글 삭제
//		dao.deleteBoard(14);
//		
//		//조회수 증가
//		dao.updateViewCnt(5);
		
		//게시글 수정
		Board bo = dao.selectOne(6);
		bo.setTitle("대답 개 잘함");
		bo.setContent("드루와");
		dao.updateBoard(bo);
//		
		//전체 게시글 조회
		for(Board b : dao.selectAll()) {
			System.out.println(b);
		}
		
//		//특정 게시글 조회
//		System.out.println(dao.selectOne(6));
	}
}
