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
		mostrar(tanque1);
		iniciar=false;
	}
	private void mostrar(Tanque tanque){


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
