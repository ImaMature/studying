/* id중복체크 start */
$(function() {
	$("#id").change(function(){
		//alert("아디중복체크");
		$.ajax({
			url : "idcheck.jsp",
			data : {m_id:document.getElementById("formsignup").id.value}, 
			success : function(result){
				if(result==1){
					document.getElementById("IdResult").style.color = "red";
					document.getElementById("IdResult").innerHTML = "현재 사용중인 아이디 입니다.";
					
					
				}else{
					document.getElementById("IdResult").style.color = "green";
					document.getElementById("IdResult").innerHTML = "사용가능한 아이디입니다.";
					
				}
			}
		});	
	});
});
/* id중복체크 end */


/* 회원가입 유효성 검사하기 start */
function signup(){
	var password = document.getElementById("formsignup").password.value;
	var passwordconfirm = document.getElementById("formsignup").passwordconfirm.value;
	var name = document.getElementById("formsignup").name.value;
	var phone = document.getElementById("formsignup").phone.value;

	//비밀번호 정규 표현식 (영문,숫자 5~10글자])
	var pwjs = /^[a-zA-Z](?=.{0,28}[0-9])[0-9a-zA-Z]{4,9}$/;
	
	//이름 정규 표현식
	var namejs = /^[A-Za-z0-9가-힣]{1,5}$/;
	
	//연락처 정규 표현식
	var phonejs = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
	
	
	
	
	//비밀번호 검사
	if(!pwjs.test(password) || !pwjs.test(passwordconfirm)){
		document.getElementById("PwResult").style.color = "red";
		document.getElementById("PwResult").innerHTML="비밀번호는 영문 + 숫자 조합 5~10 문자 사이의 문자열을 입력해주세요."
		document.getElementById("PwCResult").innerHTML="";
		return false;
	}else if(password != passwordconfirm){
		document.getElementById("PwCResult").style.color = "red";
		document.getElementById("PwResult").innerHTML="";
		document.getElementById("PwCResult").innerHTML="비밀번호가 동일하지 않습니다."
		return false;
	}else{
		document.getElementById("PwCResult").style.color = "green";
		document.getElementById("PwResult").innerHTML="";
		document.getElementById("PwCResult").innerHTML="사용가능한 비밀번호입니다."
	}
	
	// 이름
	if( !namejs.test(name) ){
		document.getElementById("NameResult").style.color= "red";
		document.getElementById("NameResult").innerHTML="이름을 입력해주세요.[특수문자는 제외]";
		return false;
	}else{
		document.getElementById("NameResult").innerHTML="";
	}
	
	
	//연락처 검사
	if( !phonejs.test( phone ) ){
		document.getElementById("PhoneResult").style.color= "red";
		document.getElementById("PhoneResult").innerHTML="연락처 형식으로 입력해주세요. 예시(010-0000-0000)";
		return false;
	}else{
		document.getElementById("PhoneResult").style.color= "green";
		document.getElementById("PhoneResult").innerHTML="사용가능한 연락처입니다";
	}

}
/* 회원가입 유효성 검사하기 end */