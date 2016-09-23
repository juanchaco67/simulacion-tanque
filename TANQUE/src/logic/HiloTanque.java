package logic;

public class HiloTanque extends Thread {
	private Tanque tanque1,tanque2;
	private boolean iniciar;
	private int tiempo;
	private double vol1,vol2;
	private double auxN1;
	private double aux;
	public HiloTanque(Tanque tanque1,Tanque tanque2,int tiempo) {
		// TODO Auto-generated constructor stub
		this.tanque1=tanque1;
		this.tanque2=tanque2;
		this.tiempo=tiempo;
		iniciar=true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int i=1;		
		while(true){
			if(iniciar){	

				try {
					if(Calculo.volumentT(tanque1, i)>=Calculo.volumenMinimo(tanque1)){	
					vol1+=Calculo.volumenC(tanque1, i);				
						desagueTanque1(i);									
					}else{
						auxN1=0.0;
						if(Calculo.volumentT(tanque2, i)>Calculo.volumenMinimo(tanque2)){	
							desagueTanque2(i);
						}else{
							System.out.println("VOLUMEN "+Calculo.volumenh1(tanque1));
							System.out.println("TOTAL AUX "+aux);													
							System.out.println("TOTAL DESAGUE  TANQUE1 "+vol1);
							System.out.println("TOTAL DESAGUE  TANQUE2 "+vol2);
							System.out.println("TIEMPO DEL SISTEMA "+Calculo.tiempoTotalSistema(tanque1));
							System.out.println("TOTAL DE AGUA DESPERDICIADA "+(vol1+vol2));
							this.iniciar=false;
							break;
						}
					}
					i++;

					Thread.sleep(tiempo);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void desagueTanque1(int i){

		// System.out.println("N1 "+tanque1.getN1());
		// System.out.println("velocidad "+Calculo.velocidadC(tanque1));
		//System.out.print("vc "+Calculo.volumenC(tanque1, i));
		// System.out.println("vq "+Calculo.volumenQ(tanque1));
		// System.out.println("area chorrito "+Calculo.areaOrificio(tanque1));
		// System.out.println("area tanque "+Calculo.areaTanque(tanque1));
		// System.out.println("volumet total "+Calculo.volumentT(tanque1, i));
		// System.out.println("nuevo n1 "+Calculo.nuevoN1(tanque1, i));
		// System.out.println("caudal "+Calculo.caudal(tanque1, i));
		// System.out.println("VOLUMEN CHORRITO "+(Calculo.caudal(tanque1, i)*i));
		//System.out.println(" distancia "+Calculo.distanciaC(tanque1, i)+" "+tanque1.getN1());
		auxN1=tanque1.getN1()-Calculo.nuevoN1(tanque1, i);
		if(!(Calculo.distanciaC(tanque1, i)>=tanque1.getA3() && Calculo.distanciaC(tanque1, i)<=tanque1.getA3() +tanque2.getA1())){	
			//vol1+=Calculo.volumenC(tanque1, i);		
		}else{
			aux+=Calculo.volumenC(tanque1, i);
			desagueTanque2(i);
		}
	
		tanque1.setN1(Calculo.nuevoN1(tanque1, i));
		//System.out.println("VOLUMEN DESPERDICIADO "+vol1+" "+vol2);
		//System.out.println("SUMA DE VOLUMENES "+(vol1+vol2));
		//System.out.println("VOLUMEN "+Calculo.volumenh1(tanque1));
		//System.out.println("-----------------------------");
	}
	public void desagueTanque2(int i){
		// System.out.println("TAMQUE 2------------------"+auxN1+"   "+i);
		// System.out.println("N1 "+tanque2.getN1());
		// System.out.println("velocidad "+Calculo.velocidadC(tanque2));
		// System.out.println("vc "+Calculo.volumenC(tanque2, i));
		// System.out.println("vq "+Calculo.volumenQ(tanque2));
		// System.out.println("area chorrito "+Calculo.areaOrificio(tanque2));
		// System.out.println("area tanque "+Calculo.areaTanque(tanque2));
		// System.out.println("volumet total "+Calculo.volumentT(tanque2, i));
		// System.out.println("nuevo n1 "+Calculo.nuevoN1(tanque2, i));
		// System.out.println("caudal "+Calculo.caudal(tanque2, i));
		// System.out.println("distancia "+Calculo.distanciaC(tanque2, i));
		
		// System.out.println("nuevo n1 despues "+Calculo.nuevoN1(tanque2, i));
		if(tanque2.getN1()>tanque2.getH1())
			vol2+=Calculo.desbordamiento(tanque2,auxN1);
		//vol2+=Calculo.volumenC(tanque2, i);
		tanque2.setN1(Calculo.nuevoN1(tanque2, i)+auxN1);
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
	public boolean isIniciar() {
		return iniciar;
	}
	public void setIniciar(boolean iniciar) {
		this.iniciar = iniciar;
	}



}
