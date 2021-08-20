package com.koreait.test21072901.model.repository.hardware;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisHardwareDAO implements HardwareDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Hardware.selectAll");
	}

	
}
