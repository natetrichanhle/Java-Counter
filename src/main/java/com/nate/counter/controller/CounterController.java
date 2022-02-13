package com.nate.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			int addToCount = (int) session.getAttribute("count");
			addToCount++;
			session.setAttribute("count", addToCount);
		}
		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String showCount(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "showCount.jsp";
	}

	@RequestMapping("/counter2")
	public String incrementBy2(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			int add2ToCount = (int) session.getAttribute("count");
			add2ToCount += 2;
			session.setAttribute("count", add2ToCount);
		}
		return "index.jsp";
	}

	@RequestMapping("/reset")
	public String resetCounter(HttpSession session) {
		session.removeAttribute("count");
		session.setAttribute("count", 0);
		return "showCount.jsp";
	}
}
