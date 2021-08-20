package com.koreait.test21072901.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.test21072901.model.service.hardware.HardwareService;


@Controller
public class HardwareController {
	
	private static final Logger logger = LoggerFactory.getLogger(HardwareController.class);
	
	@Autowired
	private HardwareService hardwareService;
	
	// 리스트 화면 처리
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public String getList(Model model) {
			//3단계: 일 시키기
			List hardwareList = hardwareService.selectAll();
			
			//4단계: 결과 저장
			model.addAttribute("hardwareList", hardwareList);
			
			return "list";
		}
	
	
}
