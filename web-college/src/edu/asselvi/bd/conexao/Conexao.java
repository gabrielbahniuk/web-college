package edu.asselvi.bd.conexao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.asselvi.bd.BDException;
import edu.asselvi.bd.EErrosBD;
import edu.asselvi.util.Manipulador;

public class Conexao {
	
	private static Connection conn;
	private static Manipulador properties = new Manipulador();
	
	public static Connection getConexao(){
        if (conn == null) {
            try {            	
            	Class.forName(properties.getValorPropertie("server.driver"));
            	
            	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", 
                		    "root", 
                		    "gabriel");

            	conn.setCatalog("ads25_gabrielbahniuk");
            } catch (ClassNotFoundException erro) {
                System.out.println("Driver nao encontrado!\n"+ erro.toString());
            } catch (SQLException erro) {
                System.out.println("Problemas na conexao com a fonte de dados\n"+erro.toString());
            } catch (Exception erro) {
				System.out.println("Ocorreu um problema ao buscar conexão!\n"+erro.toString());
			}
        }
        return conn;
    }
	
	 public static Connection getConnectionInstall(){
	        if (conn == null) {
	            try {
	            	Class.forName(properties.getValorPropertie("server.driver"));
	            	conn = DriverManager.getConnection(
	                		(properties.getValorPropertie("server.url")+
	                		properties.getValorPropertie("server.host")+
	                		properties.getValorPropertie("server.port")), 
	                		properties.getValorPropertie("server.user"), 
	                		properties.getValorPropertie("server.pass"));
	            } catch (ClassNotFoundException erro) {
	                System.out.println("Driver nao encontrado!\n"+ erro.toString());
	            } catch (SQLException erro) {
	                System.out.println("Problemas na conexao com a fonte de dados\n"+erro.toString());
	            } catch (Exception erro) {
					System.out.println("Ocorreu um problema ao buscar conexão!\n"+erro.toString());
				}
	        }
	        return conn;
	    }
	
	public static void fechaConexao() throws BDException {
		try {
			if (conn != null)
				conn.close();
			conn = null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.FECHA_CONEXAO, e.getMessage());
		}
	}
	
	
	public static void criarBanco() throws Exception {		
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/gabri/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/web-college/WEB-INF/classes/edu/asselvi/bd/conexao/script.txt"));
		String currentLine = null;
		while ((currentLine = br.readLine()) != null ) {
			System.out.println(currentLine);
			getConexao().prepareStatement(currentLine).execute();			
		}
		Manipulador m = new Manipulador();
		m.setValorPropertie("server.user", new Conexao().getUsuario());
		m.setValorPropertie("server.pass", new Conexao().getSenha());
		System.out.println(m.getValorPropertie("server.user"));
		System.out.println(m.getValorPropertie("server.pass"));
		
		br.close();
	}


	public static void close() {
		try {
			if (conn != null || !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String getUsuario() throws Exception {
		String usuario = "";
		try {
			Manipulador m = new Manipulador();
			usuario = m.getValorPropertie("server.user");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	private String getSenha() throws Exception {
		String senha = "";
		try {
			Manipulador m = new Manipulador();
			senha = m.getValorPropertie("server.pass");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return senha;

	}
}