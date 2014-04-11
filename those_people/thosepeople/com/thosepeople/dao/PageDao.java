package com.thosepeople.dao;

import java.util.List;

import com.thosepeople.constant.InfoType;
import com.thosepeople.vo.InfoProfile;

public interface PageDao {

	List<InfoProfile> getMoreInfo(String keyword, int pageNum,int pageSize,InfoType it);
}
