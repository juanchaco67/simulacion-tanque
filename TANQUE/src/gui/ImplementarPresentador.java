package gui;

import logic.Calculo;
import logic.Tanque;

public class ImplementarPresentador implements VistaPresentador {
	private VistaVentana vistaVentana;
	private Tanque tanque;
	private Tanque tanque2;

	public ImplementarPresentador(VistaVentana vistaVentana) {
		// TODO Auto-generated constructor stub
		this.vistaVentana=vistaVentana;
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub		
		double vol2=0.0,vol3=0.0;
		double promedioTiempo=0.0;	
		int contarPromedio=0;
		System.out.println("TIEMPO DESAGUE TANQUE 1 "+Calculo.redondear(Calculo.tiempoTotalllenado(tanque)));		
		vistaVentana.addTabla("TIEMPO DESAGUE TANQUE 1 ", Calculo.redondear(Calculo.tiempoTotalllenado(tanque)),"s");
		while(Calculo.distanciaChorro(tanque)>0.0){
			tanque.setN1(Calculo.nuevoN1(tanque));
			if(Calculo.caeDentro(tanque,tanque2))
				vol2+=Calculo.volumenChorrito(tanque);			
			tanque2.setN1(tanque2.getN1()+Calculo.alturaCaeAdentro(tanque));			
			tanque2.setN1(Calculo.nuevoN1(tanque2));
			if(Calculo.desbordamiento(tanque2)){
				promedioTiempo+=(Calculo.tiempoTotalllenado(tanque)+Calculo.tiempoChorrito(tanque));
				contarPromedio++;
				vol3+=Calculo.volumenDesbordamiento(tanque);
			}
		}
		System.out.println("VOLUMEN DESPERDICIADO TANQUE 1 "+(Calculo.redondear(Calculo.volumenTotalH2(tanque))-Calculo.redondear(vol2)));
		vistaVentana.addTabla("VOLUMEN DESPERDICIADO TANQUE 1 ",(Calculo.redondear(Calculo.volumenTotalH2(tanque))-Calculo.redondear(vol2)),"m^3");
		System.out.println("VOLUMEN DESBORDAMIENTO "+Calculo.redondear(vol3));
		vistaVentana.addTabla("VOLUMEN DESBORDAMIENTO ",Calculo.redondear(vol3),"m^3");
		System.out.println("TOTAL DESBORDAMIENTO "+(Calculo.redondear(vol3)+(Calculo.redondear(Calculo.volumenTotalH2(tanque))-Calculo.redondear(vol2))));
		vistaVentana.addTabla("TOTAL DESBORDAMIENTO ",(Calculo.redondear(vol3)+(Calculo.redondear(Calculo.volumenTotalH2(tanque))-Calculo.redondear(vol2))),"m^3");
		if(!String.valueOf(Calculo.redondear(promedioTiempo)/Calculo.redondear(contarPromedio)).equals("NaN")){
			System.out.println("TIEMPO PROMEDIO  DE CIERRE DE FLUJO DE AGUA TANQUE 1 "+(Calculo.redondear(promedioTiempo)/Calculo.redondear(contarPromedio)));
			vistaVentana.addTabla("TIEMPO PROMEDIO CIERRE FLUJO DE AGUA ",(Calculo.redondear(promedioTiempo)/Calculo.redondear(contarPromedio)),"s");
		}else{
			System.out.println("TIEMPO PROMEDIO  DE CIERRE DE FLUJO DE AGUA TANQUE 1 0.0");
			vistaVentana.addTabla("TIEMPO PROMEDIO CIERRE FLUJO DE AGUA ",0.0,"s");
		}

	}

	@Override
	public void addTanque(double[] datos, int opcion) {
		// TODO Auto-generated method stub
		if(opcion==1)
			tanque=new Tanque(datos[0], datos[1],datos[2],datos[3], datos[4],datos[5],datos[6]);			
		else
			tanque2=new Tanque(datos[0], datos[1],datos[2],datos[3], datos[4],datos[5],datos[6]);		


	}

}
