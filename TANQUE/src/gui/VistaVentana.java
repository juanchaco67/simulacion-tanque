package gui;

public interface VistaVentana {
	void addDatos();
	void limpiarDatos();
	void habilitarCampos(boolean habilitar);
	void addTabla(String titulo,double dato,String unidades);
	void habilitarBtn(boolean habilitar);
	void eliminarDatosTabla();
}
