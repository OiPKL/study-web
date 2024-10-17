package com.example.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.dto.Message;
import com.ssafy.mvc.dto.Satto;
import com.ssafy.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	Util util = Util.getInstance();

	@GetMapping("/ssato")
	String main(Model model) {
		Message msg = new Message("init", "1~45사이의 숫자를 입력해주세요");
		model.addAttribute("msg", msg);
		return "sattoForm";
	}

	@PostMapping("/ssato")
	String satto(@RequestParam String type, @RequestParam List<Integer> num, HttpSession session, Model model) {
		Satto userSatto;

		Message msg = util.validCheck(type, num);
		if (msg.getStatus().equals("error")) {
			model.addAttribute("msg", msg);
			return "sattoForm";
		}

		if (type == "auto") {
			userSatto = new Satto();
		} else {
			userSatto = new Satto(num);
		}

		Satto serverSatto = new Satto();

		int match = userSatto.compare(serverSatto);

		session.setAttribute("userSatto", userSatto);
		session.setAttribute("serverSatto", serverSatto);
		session.setAttribute("match", match);

		return "redirect:result";
	}

	@GetMapping("result")
	public String result(HttpSession session, Model model) {
		model.addAttribute("userSatto", session.getAttribute("userSatto"));
		model.addAttribute("serverSatto", session.getAttribute("serverSatto"));
		model.addAttribute("match", session.getAttribute("match"));
		return "result";
	}

}
