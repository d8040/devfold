package com.project.devfolio.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.devfolio.dao.BoardDao;
import com.project.devfolio.dto.Board;
import com.project.devfolio.dto.Member;
import com.project.devfolio.dto.ResultData;
import com.project.devfolio.util.Util;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
		
	public Board getForPrintBoard(int id) {
		return boardDao.getForPrintBoard(id);
	}

	public Board getBoard(int id) {
		return boardDao.getBoard(id);
	}

	public ResultData getActorCanModifyRd(Board board, Member actor) {
		return getActorCanDeleteRd(board, actor);
	}

	private ResultData getActorCanDeleteRd(Board board, Member actor) {
		if (actor.getAuthLevel() == 7) {
			return new ResultData("S-1", "가능합니다.");
		}
		
		return new ResultData("F-1", "권한이 없습니다.");
	}

	public ResultData modifyBoard(Map<String, Object> param) {
		boardDao.modifyBoard(param);

		int id = Util.getAsInt(param.get("id"), 0);

		return new ResultData("S-1", "게시판을 수정하였습니다.", "id", id);
	}
}
