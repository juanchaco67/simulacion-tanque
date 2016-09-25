package main;


import logic.HiloTanque;
import logic.Tanque;
import logic.Calculo;
public class Test {
	public static void main(String[] args) {
		//new Tanque(double A1, double H1, double N1, double h1, double d1, double H3, double A3) {
		Tanque tanque=new Tanque(1,2,2,1.5,0.023,0,1);
		Tanque tanque2=new Tanque(1,2,2,1.5,0.02,0,1);

		double auxVol1=0.0,vol2=0.0,vol3=0.0;
	
	
		//for (int i=0;i<Integer.parseInt(args[0]); i++) {			
		while(Calculo.volumenTotalH2(tanque)>auxVol1){
			System.out.println("TANQUE 1--------------------------------------");
			auxVol1+=Calculo.volumenChorrito(tanque);
			tanque.setN1(Calculo.nuevoN1(tanque));
			System.out.println("VELOCIDAD "+Calculo.velocidadC(tanque));
			System.out.println("VOLUMEN CHORRITO "+Calculo.volumenChorrito(tanque));
			System.out.println("VOLUMEN TANQUE "+Calculo.volumenTanque(tanque));
			System.out.println("VOLUMEN h2 "+Calculo.volumenTotalH2(tanque));
			System.out.println("ALTURA DINAMICA h2 "+Calculo.h2(tanque));	
			System.out.println("ALTURA REAL h2 "+(tanque.getH1()-tanque.getHh1()));
			System.out.println("ATURA QUE CAE ADENTRO "+Calculo.alturaCaeAdentro(tanque));
			System.out.println("DISTANCIA CHORRITO "+Calculo.distanciaChorro(tanque));
			System.out.println("VOLUMEN TOTAL QUE QUEDA "+Calculo.volumenTotalQueda(tanque));
			System.out.println("ANTES N1 "+tanque.getN1());
			System.out.println("NUEVO N1 "+Calculo.nuevoN1(tanque));
		

			if(Calculo.caeDentro(tanque,tanque2))
				vol2+=Calculo.volumenChorrito(tanque);		
			
			System.out.println("TANQUE 2--------------------------------------"+Calculo.volumenChorrito(tanque));		
			tanque2.setN1(tanque2.getN1()+Calculo.alturaCaeAdentro(tanque));
			System.out.println("VELOCIDAD "+Calculo.velocidadC(tanque2));
			System.out.println("VOLUMEN CHORRITO "+Calculo.volumenChorrito(tanque2));
			System.out.println("VOLUMEN TANQUE "+Calculo.volumenTanque(tanque2));
			System.out.println("VOLUMEN h2 "+Calculo.volumenTotalH2(tanque2));
			System.out.println("ALTURA DINAMICA h2 "+Calculo.h2(tanque2));	
			System.out.println("ALTURA REAL h2 "+(tanque2.getH1()-tanque2.getHh1()));
			System.out.println("DISTANCIA CHORRITO "+Calculo.distanciaChorro(tanque2));
			System.out.println("VOLUMEN TOTAL QUE QUEDA "+Calculo.volumenTotalQueda(tanque2));
			System.out.println("ANTES N1 "+tanque2.getN1());
			System.out.println("NEUVO N1 "+Calculo.nuevoN1(tanque2));
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
