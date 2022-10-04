package com.bomi.favoriteColor.favoriteColor;

import java.util.ArrayList;

public class Color {
	int idx;
	ArrayList<Integer> color;
	String colorNm;	
	String regDatim;
	

	Color(){
		
	}
	
	Color(String colorNm){
		this.colorNm = colorNm;
	}
	
	
	Color(ArrayList<Integer> color){
		this.color = color;
	}
	
	Color(ArrayList<Integer> color, String regDatim){
		this.color = color;
		this.regDatim = regDatim;
	}
	
	Color(int idx, String colorNm, String regDatim){
		this.idx = idx;
		this.colorNm = colorNm;
		this.regDatim = regDatim;
	}
	
	Color(int idx, ArrayList<Integer> color, String regDatim){
		this.idx = idx;
		this.color = color;
		this.regDatim = regDatim;
	}
	
	public String getColorNm() {
		return colorNm;
	}

	public void setColorNm(String colorNm) {
		this.colorNm = colorNm;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public ArrayList<Integer> getColor() {
		return color;
	}

	public void setColor(ArrayList<Integer> color) {
		this.color = color;
	}

	public String getRegDatim() {
		return regDatim;
	}

	public void setRegDatim(String regDatim) {
		this.regDatim = regDatim;
	}
}
