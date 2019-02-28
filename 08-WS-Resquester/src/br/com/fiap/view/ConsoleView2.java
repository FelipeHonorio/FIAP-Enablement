package br.com.fiap.view;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import br.com.fiap.br.DisciplinaBOStub;
import br.com.fiap.br.DisciplinaBOStub.CalcularMediaResponse;
import br.com.fiap.br.DisciplinaBOStub.CalcularNotaExame;
import br.com.fiap.br.DisciplinaBOStub.CalcularNotaExameResponse;

public class ConsoleView2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Nota exame
		//Ler a nota
		System.out.println("Sua nota: ");
		float nac = sc.nextFloat();

		
		try {
			DisciplinaBOStub stub = new DisciplinaBOStub();
			
			CalcularNotaExame val = new CalcularNotaExame();
			val.setMedia(nac);
			
			CalcularNotaExameResponse resp = stub.calcularNotaExame(val);
			
			System.out.println("Nota necessária : "+ resp.get_return());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
