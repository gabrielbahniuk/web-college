package edu.asselvi.bd;

public enum EErrosBD {
	ABRE_CONEXAO ("Erro ao abrir a conexão com o Banco de Dados"),
	FECHA_CONEXAO ("Erro ao fechar a conexão com o Banco de Dados"),
	CRIA_TABELA ("Erro ao criar a tabela especificada"),
	CONSULTA_DADO ("Erro ao consultar dados na tabela específica"),
	INSERE_DADO ("Erro ao inserir dados na tabela especificada"),
	ALTERA_DADO ("Erro ao alterar dados na tabela especificada"),
	EXCLUI_DADO ("Erro ao excluir o registro da tabela especificada");
	
	private final String erro;

	public String getErro() {
		return erro;
	}
	
	private EErrosBD(String erro) {
		this.erro = erro;
	}
}
