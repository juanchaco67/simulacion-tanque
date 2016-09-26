package gui;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame; 
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
@SuppressWarnings({ "unused", "serial" })
public class VentanaTanque extends JFrame implements VistaVentana,ActionListener,ItemListener {
	private javax.swing.JButton btnGuardar;
	private javax.swing.JButton btnSimular;
	private javax.swing.JMenuItem itemSalir;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2; 
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel jlabel8;
	private javax.swing.JLabel lblImagen;
	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox listaTanque;
	private javax.swing.JTable tablaEstadistica;
	private javax.swing.JTextField txtA1;
	private javax.swing.JTextField txtA3;
	private javax.swing.JTextField txtH1;
	private javax.swing.JTextField txtH3;
	private javax.swing.JTextField txtN1;
	private javax.swing.JTextField txtd1;
	private javax.swing.JTextField txth1;
	private javax.swing.table.DefaultTableModel modelo;
	private VistaPresentador presentador;
	private double datos[];
	public VentanaTanque(){
		setTitle("SIMULACION TANQUES");
		setSize(700,700);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		iniciar();
		setVisible(true);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void iniciar(){
		datos=new double[7];
		presentador=new ImplementarPresentador(this);
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		listaTanque = new javax.swing.JComboBox();
		jPanel4 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		txtA1 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtH1 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtN1 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		txth1 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		txtd1 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		txtH3 = new javax.swing.JTextField();
		jlabel8 = new javax.swing.JLabel();
		txtA3 = new javax.swing.JTextField();
		btnGuardar = new javax.swing.JButton();
		btnSimular = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		lblImagen = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tablaEstadistica = new javax.swing.JTable();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		itemSalir = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

		jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

		jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jPanel2.setPreferredSize(new java.awt.Dimension(366, 383));
		jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

		listaTanque.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR TANQUE", "TANQUE1", "TANQUE2" }));
		listaTanque.setMaximumSize(new java.awt.Dimension(32767, 300));
		listaTanque.setMinimumSize(new java.awt.Dimension(77, 100));
		listaTanque.setPreferredSize(new java.awt.Dimension(77, 20));
		jPanel2.add(listaTanque);

		jPanel4.setLayout(new java.awt.GridLayout(8, 2));

		jLabel2.setText("DIAMETRO TANQUE A1:");
		jPanel4.add(jLabel2);
		jPanel4.add(txtA1);

		jLabel3.setText("ALTURA TANQUE H1:");
		jPanel4.add(jLabel3);
		jPanel4.add(txtH1);

		jLabel4.setText("ALTURA LIQUIDO N1:");
		jPanel4.add(jLabel4);
		jPanel4.add(txtN1);

		jLabel5.setText("ALTURA DEBAJO ORIFICIO h1:");
		jPanel4.add(jLabel5);
		jPanel4.add(txth1);

		jLabel6.setText("DIAMETRO ORIFICIO d1:");
		jPanel4.add(jLabel6);
		jPanel4.add(txtd1);

		jLabel7.setText("ALTURA H3:");
		jPanel4.add(jLabel7);
		jPanel4.add(txtH3);

		jlabel8.setText("DISTANCIA A3:");
		jPanel4.add(jlabel8);
		jPanel4.add(txtA3);

		btnGuardar.setText("GUARDAR TANQUE");
		jPanel4.add(btnGuardar);

		btnSimular.setText("SIMULAR");
		jPanel4.add(btnSimular);

		jPanel2.add(jPanel4);

		jPanel1.add(jPanel2);

		jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jPanel3.setPreferredSize(new java.awt.Dimension(209, 456));
		jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));
		String path = "/img/tanques.png"; 
		URL url = this.getClass().getResource(path); 
		ImageIcon imagen = new ImageIcon(url); 
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(600,
				500,
				Image.SCALE_DEFAULT));
		lblImagen.setIcon(icono);
	
		jPanel3.add(lblImagen);

		modelo=new DefaultTableModel();
		modelo.addColumn("");
		modelo.addColumn("");

		tablaEstadistica.setModel(modelo);
		jScrollPane1.setViewportView(tablaEstadistica);

		jPanel3.add(jScrollPane1);

		jPanel1.add(jPanel3);

		getContentPane().add(jPanel1);

		jMenu1.setText("ARCHIVO");

		itemSalir.setText("Salir");
		jMenu1.add(itemSalir);

		jMenuBar1.add(jMenu1);

		setJMenuBar(jMenuBar1);
		habilitarCampos(false);
		btnGuardar.addActionListener(this);
		btnSimular.addActionListener(this);
		listaTanque.addItemListener(this);
		itemSalir.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnGuardar){
			if(listaTanque.getSelectedIndex()==1){			
				addDatos();
				limpiarDatos();
				presentador.addTanque(datos,1);
				habilitarCampos(false);
			}
			if(listaTanque.getSelectedIndex()==2){
				addDatos();
				limpiarDatos();			
				presentador.addTanque(datos, 2);
				habilitarCampos(false);
			}
		}
		if(e.getSource()==btnSimular){
			eliminarDatosTabla();
			limpiarDatos();
			habilitarCampos(false);
			habilitarBtn(false);
			presentador.iniciar();
			listaTanque.setSelectedIndex(0);
		}
		if(e.getSource()==itemSalir)
			System.exit(0);
	}

	@Override
	public void addDatos() {
		// TODO Auto-generated method stub
	
		datos[0]=Double.parseDouble(txtA1.getText());
		datos[1]=Double.parseDouble(txtH1.getText());
		datos[2]=Double.parseDouble(txtN1.getText());
		datos[3]=Double.parseDouble(txth1.getText());
		datos[4]=Double.parseDouble(txtd1.getText());
		datos[5]=Double.parseDouble(txtH3.getText());
		datos[6]=Double.parseDouble(txtA3.getText());

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub		
		if (e.getSource()==listaTanque) {          
			if(listaTanque.getSelectedIndex()==1){
				habilitarCampos(true);
				habilitarBtn(true);
				limpiarDatos();
			}else if(listaTanque.getSelectedIndex()==2){
				habilitarCampos(true);
				habilitarBtn(true);
				limpiarDatos();			
			}
		}
	}

	@Override
	public void limpiarDatos() {
		// TODO Auto-generated method stub
		txtA1.setText("");
		txtH1.setText("");
		txtN1.setText("");
		txth1.setText("");
		txtd1.setText("");
		txtH3.setText("");
		txtA3.setText("");		
	}

	@Override
	public void habilitarCampos(boolean habilitar) {
		// TODO Auto-generated method stub
		txtA1.setEnabled(habilitar);
		txtH1.setEnabled(habilitar);
		txtN1.setEnabled(habilitar);
		txth1.setEnabled(habilitar);
		txtd1.setEnabled(habilitar);
		txtH3.setEnabled(habilitar);
		txtA3.setEnabled(habilitar);			
	}

	@Override
	public void addTabla(String titulo,double dato,String unidades) {
		// TODO Auto-generated method stub
		Object obj[]={
				titulo,dato,unidades
		};
		modelo.addRow(obj);
		tablaEstadistica.setModel(modelo);

	}

	@Override
	public void habilitarBtn(boolean habilitar) {
		// TODO Auto-generated method stub
		btnGuardar.setEnabled(habilitar);
		btnSimular.setEnabled(habilitar);
		
	}

	@Override
	public void eliminarDatosTabla() {
		// TODO Auto-generated method stub
		for (int i = 0; i < tablaEstadistica.getRowCount(); i++) {
	           modelo.removeRow(i);
	           i-=1;
	       }
	}



}