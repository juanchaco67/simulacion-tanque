package main;
import javax.swing.JOptionPane;

import gui.VentanaTanque;
public class Test {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,
				"EL SISTEMA UTILIZAR EL SISTEMA INTERNACIONAL DE UNIDADES .\n"
				+ "VOLUMEN (METROS CUBICOS):m^3 \n"
				+ "LONGITUD (METROS): m \n"
				+ "TIEMPO: s");		
		new VentanaTanque();
	 }
}
