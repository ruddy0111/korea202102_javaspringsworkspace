package com.koreait.test21072901.model.service.hardware;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.test21072901.model.repository.hardware.HardwareDAO;

@Service
public class HardwareServiceImpl implements HardwareService{
	@Autowired
	private HardwareDAO hardwareDAO;

	@Override
	public List selectAll() {
		return hardwareDAO.selectAll();
	}

	

}
