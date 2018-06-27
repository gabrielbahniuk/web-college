function validaSenha(form) {
	if (form.edtSenha.value.length < 5) {
		alert("A senha deve ter pelo menos 5 caracteres!");
		form.edtSenha.focus();
		return false;
	}
	return true;
}

function processaSenha(form) {
	if (form.edtSenha.value == form.edtVerificaSenha.value) {
		form.edtVerificaSenha.value = "";
		return validaSenha(form);
	}
	alert("As senhas devem ser iguais.\nVerifique por favor!");
	form.edtVerificaSenha.value = "";
	form.edtSenha.focus;
	return false;
}