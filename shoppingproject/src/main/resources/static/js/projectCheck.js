function orderCheck(){
	var nameField = document.orderForm.name;
	var ponField = document.orderForm.ponnum;
	var subjectnameField = document.orderForm.subjectname;
	var addr1Field = document.orderForm.address1;
	var addr2Field = document.orderForm.address2;
	var addr3Field = document.orderForm.address3;
	
	if (isEmpty(nameField)) {
		alert("이름?");
		nameField.focus();
		return false;
	}
	
	if (isEmpty(ponField) || isNotNum(ponField)) {
		alert("전화번호?");
		ponField.value = "";
		ponField.focus();
		return false;
	}
	
	if (isEmpty(subjectnameField)) {
		alert("이름?");
		nameField.focus();
		return false;
	}
	
	
	if (isEmpty(addr1Field) || isEmpty(addr2Field) 
		|| isEmpty(addr3Field)) {
		alert("주소?");
		addr1Field.value = "";
		addr2Field.value = "";
		addr3Field.value = "";
		return false;
	}
}

function joinCheck() {
	var idField = document.joinForm.psm_id;
	var pwField = document.joinForm.psm_pw;
	var pwChkField = document.joinForm.psm_pwChk;
	var nameField = document.joinForm.psm_name;
	var jumin1Field = document.joinForm.psm_jumin1;
	var jumin2Field = document.joinForm.bm_jumin2;
	var addr1Field = document.joinForm.psm_address1;
	var addr2Field = document.joinForm.psm_address2;
	var addr3Field = document.joinForm.psm_address3;

	if (isEmpty(idField) || containsHS(idField) || $("#joinId").css("color") == "rgb(255, 0, 0)") {
		alert("ID?");
		idField.value = "";
		idField.focus();
		return false;
	}

	if (isEmpty(pwField) || lessThan(pwField, 5)
			|| notContains(pwField, '1234567890')
			|| notSame(pwField, pwChkField)) {
		alert("PW?");
		pwField.value = "";
		pwChkField.value = "";
		pwField.focus();
		return false;
	}

	if (isEmpty(nameField)) {
		alert("이름?");
		nameField.focus();
		return false;
	}

	if (isEmpty(jumin1Field) || lessThan(jumin1Field, 6)
			|| isNotNum(jumin1Field) || isEmpty(jumin2Field)
			|| lessThan(jumin2Field, 1) || isNotNum(jumin2Field)) {
		alert("주민번호?");
		jumin1Field.value = "";
		jumin2Field.value = "";
		jumin1Field.focus();
		return false;
	}

	if (isEmpty(addr1Field) || isEmpty(addr2Field) || isEmpty(addr3Field)) {
		alert("주소?");
		addr1Field.value = "";
		addr2Field.value = "";
		addr3Field.value = "";
		return false;
	}

	return true;
}