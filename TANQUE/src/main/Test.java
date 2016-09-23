package main;


import logic.HiloTanque;
import logic.Tanque;

public class Test {
	public static void main(String[] args) {
		new HiloTanque(new Tanque(1,2,2,1.5,0.1,0,1),new Tanque(1,2,2,1.5,0.02,0,1),100).start();
		
	}
}
