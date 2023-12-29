function isEmpty(input){
	return !input.value;
}

function lessThan(input, len){
	return input.value.length < len;
}

function containsHS(input){
	var ok = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM~!@#$%^&*()";
	
	for(var i =0; i< input.value.length;i++){
		if(ok.indexOf(input.value[i]) == -1){
			return true;
		}
	}
}

function notSame(input1,input2){
	return input1.value != input2.value;
}

function notCOntains(input, set){
	if(input.value.indexOf(set[i]) != -1){
		return false;
	}
}

function isNotNum(input){
	return isNaN(input.value) || (input.value.indexOf(" ") != -1);
}

function isNotType(input, type){
	type = "." + type;
	return input.value.toLowerCase().indexOf(type) != -1;
}