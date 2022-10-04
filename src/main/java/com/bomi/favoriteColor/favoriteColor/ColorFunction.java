package com.bomi.favoriteColor.favoriteColor;

import java.util.ArrayList;
import java.util.Random;

public class ColorFunction {
	
	public ArrayList<Color> randomNumber() {
		Random random = new Random();
		int rgbLen = 3;
		int listLen = 16;

		ArrayList<Color> color = new ArrayList<Color>();
		ArrayList<Integer>[] tmp = new ArrayList[listLen];
		for(int i = 0; i < listLen; i++) {
			System.out.println("-----------------------");
			System.out.println(i + "번째");
			tmp[i] = new ArrayList<Integer>();
			
			for(int j = 0; j < 3; j++) {
				tmp[i].add(random.nextInt(255));
			}
			
			System.out.println("tmp" + i + ": " + tmp[i]);
			color.add(new Color(tmp[i]));
			System.out.println("tmp 추가 후 : " + "color.get(" + i + ").color" + color.get(i).color);
		}
		
		return color;
	}
}
