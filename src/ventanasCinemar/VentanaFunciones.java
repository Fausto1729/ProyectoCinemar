package ventanasCinemar;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import conexionBDD.ConectBDD;

public class VentanaFunciones extends JFrame implements ActionListener{

	private Container back;
	private JComboBox<String> selectDia;
	private JComboBox<String> selectSala;
	private JButton verificar;
	private JButton completar;
	private JButton cancelar;
	private VentanaFunciones vFunciones;
	private VentanaPrincipalCliente vCliente;
	private VentanaSalas vSalas;
	private String nombre;
	private String dia;
	private String hora;
	private String correo;
	
	public VentanaFunciones(Boolean vision1, Boolean vision2, String nombre, String fecha, String correo) throws IOException, SQLException{
		
		Image Icono = ImageIO.read(new File("C:\\Users\\Faust\\eclipse-workspace\\ProyectoCinemar\\imagenes\\rsz_logocinemar.png"));
		this.setIconImage(Icono);
		
		this.nombre = nombre;
		this.dia=fecha;
		
		iniciarComponentes(nombre, fecha);
		selectDia.setVisible(vision2);;
		selectSala.setVisible(vision1);
		verificar.setVisible(vision2);
		completar.setVisible(vision1);
		
		setSize(300,100);
		setTitle("Cinemar - Reservas");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void iniciarComponentes(String nombre, String fecha) throws SQLException{
		
		ConectBDD dia = new ConectBDD();
		
		back = getContentPane();
		back.setLayout(null);
		
		selectDia = new JComboBox<String>();
		selectDia.setBounds(10, 10, 270, 20);	
		
		for(int i=0; i<dia.getFechas(nombre).size();i++){
		selectDia.addItem(dia.getFechas(nombre).get(i));
		}
		
		verificar = new JButton();
		verificar.setBounds(10, 40,110, 20);
		verificar.setText("Verificar");
		verificar.addActionListener(this);
		
		selectSala = new JComboBox<String>();
		selectSala.setBounds(10, 10, 270, 20);	
		
		ArrayList<String> insert = new ArrayList<String>();
		
		insert = dia.getFuncion(fecha, nombre);
		
		for(int i=0;i<insert.size();i+=2){
			selectSala.addItem("Sala: "+insert.get(i)+" / hora: "+insert.get(i+1));
		}
		
		cancelar = new JButton();
		cancelar.setBounds(170, 40,110, 20);
		cancelar.setText("Cancelar");
		cancelar.addActionListener(this);
		
		completar = new JButton();
		completar.setBounds(10, 40,110, 20);
		completar.setText("Completar");
		completar.addActionListener(this);
		
		back.add(selectSala);
		back.add(selectDia);
		back.add(verificar);
		back.add(cancelar);
		back.add(completar);
		
	}
	
	private JFrame getFrame(){
		return this;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==verificar){	
			
			String dia = (String) selectDia.getSelectedItem();
			this.dia = dia;
			
			try {
				vFunciones = new VentanaFunciones(true, false, nombre, this.dia, correo);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			vFunciones.setVisible(true);
			getFrame().dispose();
			
		}else { 
			
		if(e.getSource()==completar){
			
			ConectBDD search = new ConectBDD();
			
			String hora = (String) selectSala.getSelectedItem();
			
			StringBuilder hora1 = new StringBuilder();
			
			hora1 = hora1.append(hora);
			
			hora1 = hora1.deleteCharAt(6);
			
			this.hora = hora1.toString();
			
			this.hora = this.hora.replace("Sala: ", "");
			this.hora = this.hora.replace(" / hora: ", "");
			
			
			int funcion=0;
			int sala=0;
			
			try {
				
				funcion = search.getIdFuncion(nombre, dia, this.hora);
				sala = search.getSala(funcion);
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			if(sala!=0){
			try {
				vSalas = new VentanaSalas(funcion, correo);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (SQLException e1){
				e1.printStackTrace();
			}
			vSalas.setVisible(true);
			getFrame().dispose();
			
			}else{
				JOptionPane.showMessageDialog(null, "No hay funciones disponibles");
				
				try {
					vCliente = new VentanaPrincipalCliente(correo);
					vCliente.setVisible(true);
					getFrame().dispose();
				} catch (IOException e1){
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}else{
			
			try {
				vCliente = new VentanaPrincipalCliente(correo);
				vCliente.setVisible(true);
				getFrame().dispose();
			} catch (IOException e1){
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				
			}
		}
		}
	}

}
