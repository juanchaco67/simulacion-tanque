package main;


import logic.HiloTanque;
import logic.Tanque;
import logic.Calculo;
public class Test {
	public static void main(String[] args) {
		//new Tanque(double A1, double H1, double N1, double h1, double d1, double H3, double A3) {
		Tanque tanque=new Tanque(1,2,2,1.5,0.02,0,0.1);
		Tanque tanque2=new Tanque(1,2,2,1.5,0.02,0,1);

		double auxVol1=0.0,vol2=0.0,vol3=0.0;
	
	
		//for (int i=0;i<Integer.parseInt(args[0]); i++) {			
		while(Calculo.distanciaChorro(tanque)>0.0){
		
			auxVol1+=Calculo.volumenChorrito(tanque);
			tanque.setN1(Calculo.nuevoN1(tanque));
			if(Calculo.caeDentro(tanque,tanque2))
				vol2+=Calculo.volumenChorrito(tanque);			
			tanque2.setN1(tanque2.getN1()+Calculo.alturaCaeAdentro(tanque));			
			tanque2.setN1(Calculo.nuevoN1(tanque2));
			if(Calculo.desbordamiento(tanque2))
				vol3+=Calculo.volumenDesbordamiento(tanque);

		}
		//System.out.println("VOLUMEN DESPERDICIADO TANQUE 1"+(Calculo.volumenTotalH2(tanque)-vol1));

		System.out.println("VOLUMEN DESPERDICIADO TANQUE 1 "+(Calculo.volumenTotalH2(tanque)-vol2));
		System.out.println("VOLUMEN DESBORDAMIENTO "+vol3);
		System.out.println("SUMA DESBORDAMIENTO "+(vol3+(Calculo.volumenTotalH2(tanque)-vol2)));

	}

}
