package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import org.apache.log4j.Logger;

import br.com.fiap.bo.EstoqueBO;
import br.com.fiap.loja.dto.ProdutoTO;
import br.com.fiap.loja.exception.ProdutoNaoEncontradoException;

public class TerminalConsulta {
	private static Logger log = Logger.getLogger(TerminalConsulta.class);


	public static void main(String[] args) {
		
		log.warn("Aplicação Iniciada");
		Scanner sc = new Scanner(System.in);
		EstoqueBO bo = new EstoqueBO();
		log.trace("EstoqueBO instanciado com sucesso!.");
		Calendar data = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		do {
			System.out.println("FIAPStore " + sdf.format(data.getTime()));
			System.out.println("Digite o codigo: ");
			int codigo = sc.nextInt();
		
			
			try {
				ProdutoTO produto = bo.consultarProduto(codigo);
				System.out.println(produto.getDescricao());
				System.out.println("Preço: "+ produto.getPreco());
				System.out.println("Qdt: " + produto.getQuantidade());
				
			} catch (ProdutoNaoEncontradoException e) {
				System.err.println("Produto Não Encontrado");
			}

			System.out.print("Sair? S/N ");
			
		} while (sc.next().equalsIgnoreCase("N"));
		log.warn("Aplicação Finalizada!");
		sc.close();
	}

}
