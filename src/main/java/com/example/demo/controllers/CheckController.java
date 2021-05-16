package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.student.service.SoapStudent;
import com.example.demo.whitetest.StudentRequest;
import com.example.demo.whitetest.WhiteTestResponse;

@Controller
public class CheckController {
	
	@Autowired
	private SoapStudent student;
	
	@GetMapping("/check/whitetest")
	public String CheckWhiteTestForm(Model model) {
		StudentRequest studentRequest = new StudentRequest();
		model.addAttribute("request", studentRequest);
		return"request";
	}
	@PostMapping("/check/whitetest")
	public String CheckResults(@ModelAttribute("request") StudentRequest request ,Model model) {
		WhiteTestResponse response = student.getWhiteTestStatus(request);
		model.addAttribute("response", response);
		return "response";
	}

}
