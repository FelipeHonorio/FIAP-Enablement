package br.com.fiap.bo;


import org.apache.axis2.AxisFault;

import br.com.fiap.loja.dto.ProdutoTO;

import br.com.fiap.loja.exception.ProdutoNaoEncontradoException;

//Camada de negócio
public class EstoqueBO {
	
	public ProdutoTO consultarProduto(int codigo) throws AxisFault {
		
		ProdutoTO produto;
		
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
			throw new AxisFault("Produto não Cadastrado");
		}
		
		return produto;
	}
}
