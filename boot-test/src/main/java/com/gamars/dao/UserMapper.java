package com.gamars.dao;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	public int checkId(@Param("mId")String mId)throws Exception;

}
