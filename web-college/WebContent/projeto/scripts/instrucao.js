function abrirPag(valor){
	
	var url = valor;
	 
	xmlRequest.open("GET",url,true);
	xmlRequest.onreadystatechange = mudancaEstado;
	xmlRequest.send(null);
	return url;
}
 
function mudancaEstado(){
	if (xmlRequest.readyState == 4){
		document.getElementById("mostrar_conteudo").innerHTML = xmlRequest.responseText;
	}
}