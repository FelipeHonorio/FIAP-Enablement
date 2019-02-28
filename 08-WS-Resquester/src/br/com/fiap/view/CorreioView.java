package br.com.fiap.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.ArrayOfCServico;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class CorreioView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//Sedex 40010
		String calService = "40010";
		
		//Ler dois CEPs
		System.out.println("CEP Origem: ");
		String cepOrigem = sc.next();
		
		System.out.println("CEP Destino: ");
		String cepDestino = sc.next();
		
		
		CalcPrecoPrazoWSStub stub;
		try {
			stub = new CalcPrecoPrazoWSStub();
			
			
			CalcPrazo val = new CalcPrazo();
			val.setNCdServico(calService);
			val.setSCepOrigem(cepOrigem);
			val.setSCepDestino(cepDestino);
			
			CalcPrazoResponse resp = stub.calcPrazo(val);
			
			System.out.println("Prazo de Entrega: " + resp.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega());
			
			System.out.println("Data Máxima: " + resp.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
