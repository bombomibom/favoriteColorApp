function changeTextColor(){
	for(let i = 0; i < $("li").length; i++){
		var liText = $("li").eq(i).text();
		//console.log(liText);
		//console.log($("li").eq(i).length);
		//console.log(typeof($("li").eq(i)));
		var changeLiTextFirst = liText.replace(']', '').split('[');
		//console.log(changeLiTextFirst);
		var changeLiTextSecond = changeLiTextFirst[1];
		//console.log(changeLiTextSecond);
		var changeLiText = changeLiTextSecond.split(',');
		//console.log(changeLiText);
		//console.log(changeLiText.length);
		console.log("-------");
		
		// 150 이하 rgb 숫자 찾기
		var cntLessThan150 = 0;
		for(let j = 0; j < changeLiText.length; j++){
			changeLiText[j] = Number(changeLiText[j]);
			//console.log(typeof(changeLiText[j]));
			console.log(changeLiText[j]);
			if(changeLiText[j] < 150){
				cntLessThan150 = cntLessThan150 + 1;
			}
		}
		//console.log(cntLessThan150);
		if(cntLessThan150 == changeLiText.length){
			//console.log("whiteColorCss");
			$("li").eq(i).css({
				"color": "#fff"
			});
			$("li").eq(i).children("span").css({
				"color": "#fff"
			});
		}
	}
}

function changeBgColor(){
	console.log($("li").length);
	for(let i = 0; i < $("li").length; i++){
		var liText = $("li").eq(i).find("span").eq(0).text();
		//console.log(liText);
		var changeLiText = "rgb" + liText.replace('[', '(').replace(']', ')');
		//console.log(changeLiText);
		$("li").eq(i).css({
			"background": changeLiText
		});
	}
}

function changeBgColor2(){
	for(let i = 0; i < $("li").length; i++){
		var colorNm = $("li").eq(i).find("span").eq(0).text();
		//console.log(colorNm);
		$("li").eq(i).css({
			"background": colorNm
		});
	}
}

function changeHex(){
	for(let i = 0; i < $("li").length; i++){
		var liText = $("li").eq(i).text();
		//console.log(liText);
		//console.log(typeof(liText));
		var changeLiText = (liText.replace('[', '').replace(']', '')).split(',');
		//console.log(changeLiText);
		//console.log(changeLiText.length);
		//console.log(changeLiText[0]);
		//console.log(Number(changeLiText[0]));
		var hexList = "#";
		for(let j = 0; j < changeLiText.length; j++){
			var changeNum = Number(changeLiText[j]);
			//console.log(changeNum);
			var changeHexNum = changeNum.toString(16);
			//console.log(j + ": " + changeHexNum);
			//console.log(j + " length : " + changeHexNum.length);
			if(changeHexNum.length == 1){
				//console.log("this" + changeHexNum);
				changeHexNum = "0" + changeHexNum;
			}
			hexList = hexList + changeHexNum;
			//console.log(hexList);
		}
		
		$("li").eq(i).prepend("<span id='colorNm'>" + hexList + "</span>");
	}
}

$(document).ready(function(){
	
	if($("section").attr("id") == 'select'){
		changeBgColor();
		changeHex();
		changeTextColor();
		
		
		
		$("li").click(function(){
			$.ajax({
				url : "/insert_color",
				type : "POST",
				data : {
					color : $(this).find("span").eq(0).text()
				},
				success : function(result){
					alert(result);
					location.href = "/";
				},
				error : function(){
					alert(result);
					location.href = "/";
				}
			});
		})
	}
	
	if($("section").attr("id") == 'history'){
		//console.log("dd");
		changeBgColor2();
	}
	
	
})