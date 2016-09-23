package logic;

public class Calculo {
	private static final double GRAVEDAD=9.8;
	/**
	* area del orificio
	* @param tanque
	* @return
	*/
	public static double areaOrificio(Tanque tanque){
		return Math.PI*Math.pow((tanque.getD1()/2), 2);
	}
	/**
	* area del tanque
	* @param tanque
	* @return
	*/
	public static double areaTanque(Tanque tanque){
		return Math.PI*Math.pow(tanque.getA1()/2,2);
	}
	/**
	 * volumen que queda en el tanque
	 * @param tanque
	 * @param N1
	 * @return
	 */
	public static double volumenQ(Tanque tanque){
		return areaTanque(tanque)*tanque.getN1();
	}

	/**
	 * velocidad del chorrito
	 * @param tanque
	 * @param N1
	 * @return
	 */
	public static double velocidadC(Tanque tanque){
		return Math.sqrt(2*GRAVEDAD*(tanque.getN1()));
	}
	/**
	 * volumen del chorrito
	 * @param tanque
	 * @param N1
	 * @param tiempo
	 * @return
	 */
	public static double volumenC(Tanque tanque,int tiempo){
		return caudal(tanque,tiempo)*tiempo;
	}
	/**
	 * volumen total del tanque en un determinado tiempo
	 * @param tanque
	 * @param N1
	 * @param tiempo
	 * @return
	 */
	public static double volumentT(Tanque tanque,int tiempo){	
		return volumenQ(tanque)-volumenC(tanque, tiempo);
	}
	/**
	 * nuevo altura del fluido
	 * @param tanque
	 * @param tiempo
	 * @return
	 */
	public static double nuevoN1(Tanque tanque,int tiempo){
		return volumentT(tanque, tiempo)/areaTanque(tanque);
	}
	/**
	 * caudal en ese instante de tiempo
	 * @param tanque
	 * @param tiempo
	 * @return
	 */
	public static double caudal(Tanque tanque,int tiempo){
		return areaOrificio(tanque)*velocidadC(tanque);
	}
	/**
	 * distancia de chorro
	 * @param tanque
	 * @param tiempo
	 * @return
	 */
	public static double distanciaC(Tanque tanque,int tiempo){
		return 2*Math.sqrt(tanque.getHh1()*(tanque.getN1()-tanque.getHh1()));
	}
	/**
	 * volumen minimo de tanques
	 * @param tanque
	 * @return
	 */
	public static double volumenMinimo(Tanque tanque){

		return areaTanque(tanque)*((tanque.getH1()-tanque.getHh1()));
	}

	/**
	 * tiempo en que  cae el chorro. lo que se demora de  la avertura hasta caer  a la altura del otro tanque
	 * @param tanque
	 * @param tiempo
     * @return double
	 */
	public static double tiempoC(Tanque tanque){				
		return Math.sqrt((2*((tanque.getN1()-tanque.getHh1())+tanque.getH3()))/(GRAVEDAD));
	}
	/**
	* tiempo total para que se vacie el tanque
	* @param tanque
	* @return double
	*/
	public static double  tiempoTotalSistema(Tanque tanque){
		return (areaTanque(tanque)/areaOrificio(tanque))*Math.sqrt((2*tanque.getHh1())/(GRAVEDAD));
	}
	/**
	* volumen de h1
	* @param tanque
	* @return double
	*/
	public static double volumenh1(Tanque tanque){
		return areaTanque(tanque)*(tanque.getHh1());
	}
	/**
	* calcula el desbordamiento que hay del tanque 2
	* @param tanque
	* @param N1
	* @return double
	*/	
	public static double desbordamiento(Tanque tanque,double N1){
		return areaTanque(tanque)*N1;
	}
	/**
	* convierte los  segundos en milisegundos
	* @param segundo 
	* @return int
	*/
	public static int convertirSM(int segundo){
		return segundo*100;
	}
}
