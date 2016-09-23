package logic;

public class CopyOfCalculo {
	private Tanque tanque1;
	private Tanque tanque2;
	private int tiempo;
	private static final double GRAVEDAD=9.8;

	public CopyOfCalculo(Tanque tanque1, Tanque tanque2,int tiempo) {
		this.tiempo=tiempo;
		this.tanque1 = tanque1;
		this.tanque2 = tanque2;
		iniciar();

	}
	
	private double areaOrificio(Tanque tanque){
		return Math.PI*Math.pow((tanque.getD1()/2), 2);
	}
	private double areaTanque(Tanque tanque){
		return Math.PI*Math.pow(tanque.getA1()/2,2);
	}
	/**
	 * volumen que queda en el tanque
	 * @param tanque
	 * @param N1
	 * @return
	 */
	private double volumenQ(Tanque tanque){
		//		System.out.println("adentro n1 "+tanque.getN1());
		return Math.PI*Math.pow(tanque.getA1()/2,2)*tanque.getN1();
	}

	/**
	 * velocidad del chorrito
	 * @param tanque
	 * @param N1
	 * @return
	 */
	private double velocidadC(Tanque tanque){
		return Math.sqrt(2*GRAVEDAD*(tanque.getN1()-tanque.getHh1()));
	}
	/**
	 * volumen del chorrito
	 * @param tanque
	 * @param N1
	 * @param tiempo
	 * @return
	 */
	private double volumenC(Tanque tanque,int tiempo){
		return velocidadC(tanque)*areaOrificio(tanque)*tiempo;
	}
	/**
	 * volumen total del tanque en un determinado tiempo
	 * @param tanque
	 * @param N1
	 * @param tiempo
	 * @return
	 */
	private double volumentT(Tanque tanque,int tiempo){	
		return volumenQ(tanque)-volumenC(tanque, tiempo);
	}
	/**
	 * nuevo alturea del fluido
	 * @param tanque
	 * @param tiempo
	 * @return
	 */
	private double nuevoN1(Tanque tanque,int tiempo){
		return volumentT(tanque, tiempo)/areaTanque(tanque);
	}
	/**
	 * caudal en ese instante de tiempo
	 * @param tanque
	 * @param tiempo
	 * @return
	 */
	private double caudal(Tanque tanque,int tiempo){
		return areaOrificio(tanque)*velocidadC(tanque);
	}
	/**
	 * distancia de chorro
	 * @param tanque
	 * @param tiempo
	 * @return
	 */
	private double distanciaC(Tanque tanque,int tiempo){
		return 2*Math.sqrt(tanque.getHh1()*(tanque.getN1()-tanque.getHh1()));
	}
	/**
	 * volumen minimo de tanques
	 * @param tanque
	 * @return
	 */
	private double volumenMinimo(Tanque tanque){
		return areaTanque(tanque)*(tanque.getH1()-tanque.getHh1());
	}

	/**
	 * tiempo en que  cae el chorro. lo que se demora de  la avertura hasta caer  a la altura del otro tanque
	 * @param tanque
	 * @param tiempo
	 * @return
	 */
	private double tiempoC(Tanque tanque){				
		return Math.sqrt((2*((tanque.getN1()-tanque.getHh1())+tanque.getH3()))/(GRAVEDAD));
	}
	private double volumenh1(Tanque tanque){
		return areaTanque(tanque)*tanque.getHh1();
	}
	public void iniciar(){
		int i=0;
		double vol1=0.0,vol2=0.0;
		double auxN1=0.0;
		while(volumentT(tanque1, i)>=volumenMinimo(tanque1)){
			//		for (int i = 1; i < 10; i++) {

			System.out.println("N1 "+tanque1.getN1());
			System.out.println("velocidad "+velocidadC(tanque1));
			System.out.println("vc "+volumenC(tanque1, i));
			System.out.println("vq "+volumenQ(tanque1));
			System.out.println("area chorrito "+areaOrificio(tanque1));
			System.out.println("area tanque "+areaTanque(tanque1));
			System.out.println("volumet total "+volumentT(tanque1, i));
			System.out.println("nuevo n1 "+nuevoN1(tanque1, i));
			System.out.println("caudal "+caudal(tanque1, i));
			System.out.println("VOLUMEN CHORRITO "+(caudal(tanque1, i)*i));
			System.out.println("distancia "+distanciaC(tanque1, i)+" "+tanque1.getN1());
			//			if(distanciaC(tanque1, i)>=0.0 && distanciaC(tanque1, i)<=tanque1.getA3())
			//				System.out.println("SI");
			//			else
			//				System.out.println("NO");
			auxN1=tanque1.getN1()-nuevoN1(tanque1, i);
			tanque1.setN1(nuevoN1(tanque1, i));	
			if(!(distanciaC(tanque1, i)>=tanque1.getA3() && distanciaC(tanque1, i)<=tanque1.getA3() +tanque2.getA1())){		
				if(!String.valueOf(volumenC(tanque1, i)).equals("NaN"))
					vol1+=volumenC(tanque1, i);

			}else{
					
				System.out.println("TAMQUE 2------------------"+auxN1+"   "+i);
				System.out.println("N1 "+tanque2.getN1());
				System.out.println("velocidad "+velocidadC(tanque2));
				System.out.println("vc "+volumenC(tanque2, i));
				System.out.println("vq "+volumenQ(tanque2));
				System.out.println("area chorrito "+areaOrificio(tanque2));
				System.out.println("area tanque "+areaTanque(tanque2));
				System.out.println("volumet total "+volumentT(tanque2, i));
				System.out.println("nuevo n1 "+nuevoN1(tanque2, i));
				System.out.println("caudal "+caudal(tanque2, i));
				System.out.println("distancia "+distanciaC(tanque2, i));
				tanque2.setN1(nuevoN1(tanque2, i)+auxN1);
				System.out.println("nuevo n1 despues "+nuevoN1(tanque2, i));
				vol2+=volumenC(tanque2, i);
			}		

			System.out.println("--------------------------------");
			i++;
		}
		System.out.println("volumen h1 "+(volumenh1(tanque1)));
		System.out.println("volumen h1 "+(volumenh1(tanque2)));
		System.out.println("tanque uno volumen desperdiciado "+vol1);
		System.out.println("tanque uno volumen desperdiciado "+vol2);
	}

	public Tanque getTanque1() {
		return tanque1;
	}
	public void setTanque1(Tanque tanque1) {
		this.tanque1 = tanque1;
	}
	public Tanque getTanque2() {
		return tanque2;
	}
	public void setTanque2(Tanque tanque2) {
		this.tanque2 = tanque2;
	}	
}
