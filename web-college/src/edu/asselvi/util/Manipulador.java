package edu.asselvi.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class Manipulador{

	private Properties props;
	private static final String FILENAME = "config.properties";
	
	public Manipulador(){
		try {
			props = new Properties();
			System.out.println("Construtor iniciado... Props...");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public String getValorPropertie(String chave) throws Exception{
		try {					
		final InputStream stream = this.getClass().getResourceAsStream("config.properties");
		props.load(stream);
		return props.getProperty(chave);			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void setValorPropertie(String chave, String valor) throws Exception{
		try {
			final InputStream stream = this.getClass().getResourceAsStream("config.properties");
			props.load(stream);
			FileOutputStream fos = new FileOutputStream("C:/Users/gabri/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/web-college/WEB-INF/classes/edu/asselvi/util/config.properties");
			props.store(fos, "");
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
