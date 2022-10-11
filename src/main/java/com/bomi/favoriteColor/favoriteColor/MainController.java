package com.bomi.favoriteColor.favoriteColor;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	// firstPage
	@GetMapping("/")
	public String home(Model model) {
		try {
			this.moveSelectColorPage(model);
		} catch (Exception e) {
			
		}
		return "main";
	}
	
	// moveSelectColorPage
	@GetMapping("/select_color")
	public String moveSelectColorPage(Model model) {
		ColorFunction colorFunction = new ColorFunction();
		try {
			ArrayList<Color> color = new ArrayList<Color>();
			color = colorFunction.randomNumber();
			model.addAttribute("colorList", color);
			model.addAttribute("pageName", "select");
		} catch (Exception e) {
		
		}
		return "main";
	}

	// moveHistoryPage
	@GetMapping("/history_color")
	public String moveHistoryPage(Model model) {
		DB db = new DB("color");
		
		try {
			ArrayList<Color> color = new ArrayList<Color>();
			color = db.selectData();
			System.out.println(color.get(0).colorNm);
			model.addAttribute("colorList", color);
			model.addAttribute("pageName", "history");
		} catch (Exception e) {
			
		}
		return "main";
	}
	
	
}
