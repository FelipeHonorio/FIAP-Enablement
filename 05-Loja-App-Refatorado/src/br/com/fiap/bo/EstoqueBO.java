package br.com.fiap.bo;

import org.apache.log4j.Logger;

import br.com.fiap.loja.TerminalConsulta;
import br.com.fiap.loja.dto.ProdutoTO;
import br.com.fiap.loja.exception.ProdutoNaoEncontradoException;

//Camada de neg�cio
public class EstoqueBO {
	private static Logger log = Logger.getLogger(EstoqueBO.class);
	
	public ProdutoTO consultarProduto(int codigo) throws ProdutoNaoEncontradoException {
		
		ProdutoTO produto;
		
		log.debug(codigo);
		
		switch (codigo) {
		case 401:
			produto = new ProdutoTO(401, 10, 100, "Camiseta Branca");
			break;
		case 402:
			produto = new ProdutoTO(402, 20, 50, "Camiseta Azul");
			break;
		case 403:
			produto = new ProdutoTO(403, 30, 20, "Camiseta Rosa");
			break;
		default:
			log.error("Produto n�o encontrado" + codigo);
			throw new ProdutoNaoEncontradoException();
		}
		
		return produto;
	}
}
