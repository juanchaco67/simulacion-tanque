package gui;

public interface VistaVentana {
	void addDatos();
	void limpiarDatos();
	void habilitarCampos(boolean habilitar);
	void addTabla(String titulo,Object dato,String unidades);
	void habilitarBtn(boolean habilitar);
	void eliminarDatosTabla();
	void habilitarCamposT2(boolean habilitar);
	void llenarDatos(String A1,String H1,String N1,String h1,String d1,String H3,String A3);

}
