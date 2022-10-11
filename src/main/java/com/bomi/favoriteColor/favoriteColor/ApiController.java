package com.bomi.favoriteColor.favoriteColor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
		// insert_color
		@PostMapping("/insert_color")
		public String insert_action(HttpServletRequest request, Model model) {
			DB db = new DB("color");
			
			String color = request.getParameter("color");
			String msg = "";
			System.out.println(color);
			
			try {
				db.insertData(new Color(color));
				msg = "입력 되었습니다.";
				return msg;
			} catch (Exception e) {
				msg = "입력에 실패했습니다.";
				return msg;
			}
		}
		
}
