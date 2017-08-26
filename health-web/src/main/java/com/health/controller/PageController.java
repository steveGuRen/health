package com.health.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {

	@RequestMapping(value = "/question/mobile-question-main")
	public String page(String userId, String accessToken, Map<String, Object> model,HttpServletRequest request,HttpServletResponse response) {
		model.put("userId", userId);
		model.put("accessToken", accessToken);
		return "/jsp/question/mobile-question-main";
	}
}
