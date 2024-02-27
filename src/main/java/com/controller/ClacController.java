package com.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CalcBean;

@RestController
public class ClacController {
	@PostMapping("/add")
	public HashMap<String, Object> add(@RequestBody CalcBean calc){
		HashMap<String, Object> hm = new HashMap<>();
		Integer ans = calc.getX() + calc.getY();
		hm.put("ans" , ans);
		return hm;
	}
}
