/**
 * 
 */
package com.thosepeople.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.util.CollectionUtils;

import com.thosepeople.dao.InfoCommonDao;
import com.thosepeople.model.InfoStatistics;

/**
 * @author zhuo
 * 
 */
public class InfoCommonDaoImpl extends JdbcDaoSupport implements InfoCommonDao {
	private static final BeanPropertyRowMapper<InfoStatistics> rowMapper = new BeanPropertyRowMapper<InfoStatistics>(
			InfoStatistics.class);
	static {
		rowMapper.setPrimitivesDefaultedForNullValue(true);
	}
	private static final String GET_INFO_STATISTIC_BY_ID_LIST = " select * from info_statistics where id in ? ";

	@Override
	public List<InfoStatistics> getInfoStatisticByIdList(List<Integer> idList) {
		List<InfoStatistics> result = this.getJdbcTemplate().query(
				GET_INFO_STATISTIC_BY_ID_LIST, new Object[] {}, rowMapper);
		if (CollectionUtils.isEmpty(result)) {
			Collections.emptyList();
		}
		return result;
	}

}
