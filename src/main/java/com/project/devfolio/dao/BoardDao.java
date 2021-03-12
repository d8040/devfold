package com.project.devfolio.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.devfolio.dto.Board;

@Mapper
public interface BoardDao {
	Board getForPrintBoard(@Param("id") int id);

	Board getBoard(@Param("id") int id);

	void modifyBoard(Map<String, Object> param);

}
