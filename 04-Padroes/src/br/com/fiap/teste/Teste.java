package br.com.fiap.teste;



import org.apache.log4j.Logger;

import br.com.fiap.singleton.ConfiguracaoSingleton;

public class Teste {

	//Criar um obj para realizar o log
	private static Logger log = Logger.getLogger(Teste.class); 
	
	public static void main(String[] args) {
		
		log.trace("Iniciando a aplicação");
		
		//Recuperar o idioma da aplicação
		String idioma = ConfiguracaoSingleton
					.getInstance().getProperty("idioma");
		
		log.info("Recuperando a configuração de Idioma: " + idioma);
		
		
		System.out.println(idioma);
	}
	
}



