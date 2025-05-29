package com.electroshop.electroshop_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HomeController {
	
	public static String hello() {
		return "hello";
	}
	
	
}
