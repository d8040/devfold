package com.project.devfolio.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.devfolio.dto.Board;
import com.project.devfolio.dto.Member;
import com.project.devfolio.dto.ResultData;
import com.project.devfolio.service.BoardService;
import com.project.devfolio.util.Util;

@Controller
public class AdmBoardController extends BaseController {

	@Autowired
	private BoardService boardService;

	// 게시판 수정 페이지
	@RequestMapping("/adm/board/modify")
	public String showModify(Integer id, HttpServletRequest req) {
		if (id == null) {
			return msgAndBack(req, "id를 입력해주세요.");
		}

		Board board = boardService.getForPrintBoard(id);

		if (board == null) {
			return msgAndBack(req, "존재하지 않는 게시물 번호입니다.");
		}

		return "adm/article/modify";
	}
	
	// 게시판 수정
	@RequestMapping("/adm/board/doModify")
	@ResponseBody
	public ResultData doModify(@RequestParam Map<String, Object> param, HttpServletRequest req) {
		Member loginedMember = (Member) req.getAttribute("loginedMember");
		
		int id = Util.getAsInt(param.get("id"), 0);
		
		Board board = boardService.getBoard(id);
		
		if (id == 0) {
			return new ResultData("F-1", "id을 입력해주세요");
		}
		if (Util.isEmpty(param.get("code"))) {
			return new ResultData("F-1", "code을 입력해주세요");
		}
		if (Util.isEmpty(param.get("name"))) {
			return new ResultData("F-1", "name를 입력해주세요");
		}

		if (board == null) {
			return new ResultData("F-1", "해당 게시판은 존재하지 않습니다.");
		}
		
		ResultData actorCanModifyRd = boardService.getActorCanModifyRd(board, loginedMember);

		if (actorCanModifyRd.isFail()) {
			return actorCanModifyRd;
		}
		return boardService.modifyBoard(param);
	}
	
}
