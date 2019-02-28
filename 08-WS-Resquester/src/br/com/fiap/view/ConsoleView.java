package br.com.fiap.view;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import br.com.fiap.br.DisciplinaBOStub;
import br.com.fiap.br.DisciplinaBOStub.CalcularMedia;
import br.com.fiap.br.DisciplinaBOStub.CalcularMediaResponse;

public class ConsoleView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Ler o valor de NAC, PS e AM
		System.out.println("NAC: ");
		float nac = sc.nextFloat();
		
		System.out.println("PS: ");
		float ps = sc.nextFloat();
		
		System.out.println("AM: ");
		float am = sc.nextFloat();
		
		//Instanciar o STUB para acessar o web service
		try {
			DisciplinaBOStub stub = new DisciplinaBOStub();
			
			//Valores que serão enviados para o web service
			CalcularMedia valores = new CalcularMedia();
			valores.setNac(am);
			valores.setPs(ps);
			valores.setAm(am);
			
			//Chamando o web service
			CalcularMediaResponse resp = 
					stub.calcularMedia(valores);
			
			//Recuperar o valor retornado pelo web service
			double media = resp.get_return();
			System.out.println("Média é: " + media);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		sc.close();
	}

}
