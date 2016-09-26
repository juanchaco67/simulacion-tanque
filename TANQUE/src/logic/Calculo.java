package logic;

public class Calculo {
	private static final double GRAVEDAD=9.8;
	/**
	* velocidad de orificio
	* @param tanque
	* @return
	*/
	public static double velocidadC(Tanque tanque){
		return Math.sqrt(2*GRAVEDAD*(tanque.getN1()-tanque.getHh1()));
	}
	/**
	* area del tanque 
	* @param tanque
	* @return
	*/
	public static double areaTanque(Tanque tanque){
		return (Math.PI*(Math.pow(tanque.getA1(),2)))/4;
	}
	/**
	* area del orificio
	* @param tanque
	* @return
	*/
	public static double areaOrificio(Tanque tanque){
		return (Math.PI*Math.pow(tanque.getD1(),2))/4;
	}
	/**
	* caudal de los tanques
	* @param tanque
	* @return
	*/
	public static double caudal(Tanque tanque){
		return areaOrificio(tanque)*velocidadC(tanque);
	}
	/**
	* volumen del chorrito  en determinado tiempo 
	* @param tanque
	* @return
	*/
	public static double volumenChorrito(Tanque tanque){
		return caudal(tanque)*(distanciaChorro(tanque)/velocidadC(tanque));
	}
	/**
	* volumen del chorrito
	* @param tanque
	* @return
	*/
	public static double volumenTanque(Tanque tanque){
		return areaTanque(tanque)*tanque.getH1();
	}
	/**
	* volumen que queda 
	* @param tanque
	* @return
	*/
	public  static double volumenQueda(Tanque tanque){
		return areaTanque(tanque)*tanque.getN1();
	}
	/**
	* volumen total
	* @param tanque
	* @return
	*/
	public static double volumenTotalQueda(Tanque tanque){
		return volumenQueda(tanque)-volumenChorrito(tanque);
	}
	/**
	* altura h2 por encima del orificio
	* @param tanque
	* @return
	*/
	public static double h2(Tanque tanque){
		return tanque.getN1()-tanque.getHh1();
	}
	/**
	* volumen por encima del orificio, este  esta variando
	* @param tanque
	* @return
	*/
	public static double volumenH2Queda(Tanque tanque){
		return areaTanque(tanque)*h2(tanque);
	}
	/**
	* volumen total de  altura por encima del orificio
	* @param tanque
	* @return
	*/
	public static double volumenTotalH2(Tanque tanque){
		return areaTanque(tanque)*(tanque.getH1()-tanque.getHh1());
	}
	/**
	* area del tanque 
	* @param tanque
	* @return
	*/
	public static double distanciaChorro(Tanque tanque){
		return  2*Math.sqrt(h2(tanque)*(tanque.getN1()-h2(tanque)));
	}
	/**
	* altura  del fluido  N1 nueva
	* @param tanque
	* @return
	*/
	public static double nuevoN1(Tanque tanque){
		return volumenTotalQueda(tanque)/areaTanque(tanque);
	}
	/**
	* Es cuando el liquido cae dentro del tanque2  
	* @param tanque1
	* @param tanque1
	* @return
	*/
	public static boolean caeDentro(Tanque tanque1,Tanque tanque2){
		if(distanciaChorro(tanque1)>=tanque1.getA3() &&  distanciaChorro(tanque1)<=tanque1.getA3()+tanque2.getA1())
			return true;
		else
			return false;
	}
	/**
	* Es la altura que va perdiendo el tanque1 cada vez que sale liquido 
	* @param tanque
	* @return
	*/
	public static double alturaCaeAdentro(Tanque tanque){
		return tanque.getN1()-nuevoN1(tanque);
	}
	/**
	* Es cuando el liquido cae dentro del tanque2  
	* @param tanque
	* @return
	*/
	public static boolean desbordamiento(Tanque tanque){
		if(tanque.getN1()>tanque.getH1())
			return true;
		else
			return false;	
	}
	/**
	* desbordamiento   
	* @param tanque
	* @return
	*/
	public static double volumenDesbordamiento(Tanque tanque){
		return alturaCaeAdentro(tanque)*areaTanque(tanque);
	}
	/**
	* Tiqmpo total en que  se tarda en desocupar  el tanque a una  altura  del orificio  
	* @param tanque
	* @return
	*/
	public static  double tiempoTotalllenado(Tanque tanque){
		return (areaTanque(tanque)/areaOrificio(tanque))*(Math.sqrt((2*(tanque.getN1()-tanque.getHh1()))/(GRAVEDAD)));
	}
/**
	* Tiempo en que tarde en caer un volumen de agua al otro tanque  
	* @param tanque
	* @return
	*/
	public static  double tiempoChorrito(Tanque tanque){
		return Math.sqrt((2/GRAVEDAD)*(tanque.getHh1()+tanque.getH3()));
	}
	public static double redondear(double numero){
		return Math.rint(numero*1000)/1000;
	}
}
