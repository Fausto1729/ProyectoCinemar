package ventanasCinemar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import conexionBDD.ConectBDD;

public class VentanaPrincipalAdmin extends JFrame implements ActionListener{

	private Container back;
	private JPanel crearPelicula;
	private JPanel eliminarPelicula;
	private JPanel crearFuncion;
	private JPanel eliminarFuncion;
	private JPanel verFuncion;
	private JPanel modificarDescuento;
	private JButton bcPelicula;
	private JButton bePelicula;
	private JButton bcFuncion;
	private JButton beFuncion;
	private JButton bvFuncion;
	private JButton bmDescuento;
	private JLabel cNombre;
	private JLabel cGenero;
	private JLabel cDuracion;
	private JLabel cIdioma;
	private JLabel cNombres;
	private JLabel cNombresi;
	private JLabel cnombreFuncion;
	private JLabel cpelicula;
	private JLabel cfecha;
	private JLabel chora;
	private JLabel csala;
	private JLabel cNombreFuncione;
	private JLabel cverFuncion;
	private JTextField iNombre;
	private JTextField iGenero;
	private JTextField iDuracion;
	private JTextField iIdioma;
	private JTextField iNombres;
	private JTextField inombreFuncion;
	private JTextField ipelicula;
	private JTextField ifecha;
	private JTextField ihora;
	private JTextField isala;
	private JTextField iNombreFuncione;
	private JTextField iverFuncion;
	
	public VentanaPrincipalAdmin() throws IOException{
		
		iniciarComponentes();
		
		Image Icono = ImageIO.read(new File("C:\\Users\\faust\\eclipse-workspace\\ProyectoCinemar\\imagenes\\rsz_logocinemar.png"));
		this.setIconImage(Icono);
		
		setSize(862,686);
		setTitle("Cinemar");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniciarComponentes(){
		
		back = getContentPane();
		back.setLayout(null);
		back.setBackground(new Color(255, 205, 0));
		
		crearPelicula = new JPanel();
		crearPelicula.setBounds(5, 5, 276, 317);
		crearPelicula.setBackground(Color.black);
		
		iniciarCrearPelicula();
		
		eliminarPelicula = new JPanel();
		eliminarPelicula.setBounds(286, 5, 276, 317);
		eliminarPelicula.setBackground(Color.black);
		
		iniciarEliminarPelicula();
		
		crearFuncion = new JPanel();
		crearFuncion.setBounds(567, 5, 276, 317);
		crearFuncion.setBackground(Color.black);
		
		iniciarCrearFuncion();
		
		eliminarFuncion = new JPanel();
		eliminarFuncion.setBounds(5, 327, 276, 317);
		eliminarFuncion.setBackground(Color.black);
		
		iniciarEliminarFuncion();
		
		verFuncion = new JPanel();
		verFuncion.setBounds(286, 327, 276, 317);
		verFuncion.setBackground(Color.black);
		
		iniciarVerFuncion();
		
		modificarDescuento = new JPanel();
		modificarDescuento.setBounds(567, 327, 276, 317);
		modificarDescuento.setBackground(Color.black);
		
		iniciarModificarDescuento();

		back.add(crearPelicula);
		back.add(eliminarPelicula);
		back.add(crearFuncion);
		back.add(eliminarFuncion);
		back.add(verFuncion);
		back.add(modificarDescuento);
		
	}
	
	private void iniciarCrearPelicula(){
		
		crearPelicula.setLayout(null);
		
		cNombre = new JLabel();
		cNombre.setBounds(100,10,150,20);
		cNombre.setFont(new Font("Serif",Font.PLAIN,16));
		cNombre.setText("NOMBRE:");
		cNombre.setForeground(new Color(253, 254, 254));
		
		iNombre = new JTextField();
		iNombre.setBounds(45, 40, 190, 15);
		iNombre.setBorder(null);
		
		cGenero = new JLabel();
		cGenero.setBounds(100,65,150,20);
		cGenero.setFont(new Font("Serif",Font.PLAIN,16));
		cGenero.setText("GENERO:");
		cGenero.setForeground(new Color(253, 254, 254));
		
		iGenero = new JTextField();
		iGenero.setBounds(45, 100, 190, 15);
		iGenero.setBorder(null);
		
		cDuracion = new JLabel();
		cDuracion.setBounds(95,125,150,20);
		cDuracion.setFont(new Font("Serif",Font.PLAIN,16));
		cDuracion.setText("DURACION:");
		cDuracion.setForeground(new Color(253, 254, 254));
		
		iDuracion = new JTextField();
		iDuracion.setBounds(45, 160, 190, 15);
		iDuracion.setBorder(null);

		cIdioma = new JLabel();
		cIdioma.setBounds(105,190,150,20);
		cIdioma.setFont(new Font("Serif",Font.PLAIN,16));
		cIdioma.setText("IDIOMA:");
		cIdioma.setForeground(new Color(253, 254, 254));
		
		iIdioma = new JTextField();
		iIdioma.setBounds(45, 220, 190, 15);
		iIdioma.setBorder(null);
		
		bcPelicula = new JButton();
		bcPelicula.setBounds(60,260,150,40);
		bcPelicula.setText("Crear Pelicula");
		bcPelicula.setFont(new Font("Serif", Font.BOLD,16));
		bcPelicula.setBorder(null);
		bcPelicula.addActionListener(this);
		bcPelicula.setBackground(new Color(175, 175, 175));
		
		back.add(cIdioma);
		back.add(iIdioma);
		back.add(cDuracion);
		back.add(iDuracion);
		back.add(iGenero);
		back.add(iNombre);
		back.add(cGenero);
		back.add(cNombre);
		crearPelicula.add(bcPelicula);
		
	}
	
	private void iniciarEliminarPelicula(){
		
		eliminarPelicula.setLayout(null);
		
		cNombres = new JLabel();
		cNombres.setBounds(390,80,150,20);
		cNombres.setFont(new Font("Serif",Font.PLAIN,16));
		cNombres.setText("INGRESE ");
		cNombres.setForeground(new Color(253, 254, 254));
		
		cNombresi = new JLabel();
		cNombresi.setBounds(370,100,150,20);
		cNombresi.setFont(new Font("Serif",Font.PLAIN,16));
		cNombresi.setText("LA PELICULA :");
		cNombresi.setForeground(new Color(253, 254, 254));
		
		iNombres = new JTextField();
		iNombres.setBounds(330, 160, 190, 15);
		iNombres.setBorder(null);
		
		bePelicula = new JButton();
		bePelicula.setBounds(60,260,150,40);
		bePelicula.setText("Eliminar Pelicula");
		bePelicula.setFont(new Font("Serif", Font.BOLD,16));
		bePelicula.setBorder(null);
		bePelicula.addActionListener(this);
		bePelicula.setBackground(new Color(175,175,175));
		
		back.add(cNombresi);
		back.add(cNombres);
		back.add(iNombres);
		eliminarPelicula.add(bePelicula);
		
	}
	
	private void iniciarCrearFuncion(){
		
		crearFuncion.setLayout(null);
		
		cnombreFuncion = new JLabel();
		cnombreFuncion.setBounds(610,10,200,20);
		cnombreFuncion.setFont(new Font("Serif",Font.PLAIN,16));
		cnombreFuncion.setText("NOMBRE DE LA FUNCION :");
		cnombreFuncion.setForeground(new Color(253, 254, 254));
		
		inombreFuncion = new JTextField();
		inombreFuncion.setBounds(610, 40, 190, 15);
		inombreFuncion.setBorder(null);
		
		cpelicula = new JLabel();
		cpelicula.setBounds(660, 65, 150, 20);
		cpelicula.setFont(new Font("Serif",Font.PLAIN,16));
		cpelicula.setText("PELICULA :");
		cpelicula.setForeground(new Color(253, 254, 254));
		
		ipelicula = new JTextField();
		ipelicula.setBounds(610, 90, 190, 15);
		ipelicula.setBorder(null);
		
		csala = new JLabel();
		csala.setBounds(675, 110, 150, 20);
		csala.setFont(new Font("Serif",Font.PLAIN,16));
		csala.setText("SALA :");
		csala.setForeground(new Color(253, 254, 254));
		
		isala = new JTextField();
		isala.setBounds(610, 135, 190, 15);
		isala.setBorder(null);
		
		cfecha = new JLabel();
		cfecha.setBounds(670, 155, 150, 20);
		cfecha.setFont(new Font("Serif",Font.PLAIN,16));
		cfecha.setText("FECHA :");
		cfecha.setForeground(new Color(253, 254, 254));
		
		ifecha = new JTextField();
		ifecha.setBounds(610, 180, 190, 15);
		ifecha.setBorder(null);
		
		
		chora = new JLabel();
		chora.setBounds(675, 200, 150, 20);
		chora.setFont(new Font("Serif",Font.PLAIN,16));
		chora.setText("HORA :");
		chora.setForeground(new Color(253, 254, 254));
		
		ihora = new JTextField();
		ihora.setBounds(610, 230, 190, 15);
		ihora.setBorder(null);
		
		bcFuncion = new JButton();
		bcFuncion.setBounds(60,260,150,40);
		bcFuncion.setText("Crear Funcion");
		bcFuncion.setFont(new Font("Serif", Font.BOLD,16));
		bcFuncion.setBorder(null);
		bcFuncion.addActionListener(this);
		bcFuncion.setBackground(new Color(175,175,175));
		
		back.add(chora);
		back.add(ihora);
		back.add(cfecha);
		back.add(ifecha);
		back.add(csala);
		back.add(isala);
		back.add(cpelicula);
		back.add(ipelicula);
		back.add(cnombreFuncion);
		back.add(inombreFuncion);
		crearFuncion.add(bcFuncion);
		
	}
	
	private void iniciarEliminarFuncion(){
		
		eliminarFuncion.setLayout(null);
		
		cNombreFuncione = new JLabel();
		cNombreFuncione.setBounds(45, 430, 200, 20);
		cNombreFuncione.setFont(new Font("Serif",Font.PLAIN,16));
		cNombreFuncione.setText("NOMBRE DE LA FUNCION :");
		cNombreFuncione.setForeground(new Color(253, 254, 254));
		
		iNombreFuncione = new JTextField();
		iNombreFuncione.setBounds(45, 480, 190, 15);
		iNombreFuncione.setBorder(null);
		
		beFuncion = new JButton();
		beFuncion.setBounds(60,260,150,40);
		beFuncion.setText("Eliminar Funcion");
		beFuncion.setFont(new Font("Serif", Font.BOLD,16));
		beFuncion.setBorder(null);
		beFuncion.addActionListener(this);
		beFuncion.setBackground(new Color(175,175,175));
		
		back.add(cNombreFuncione);
		back.add(iNombreFuncione);
		eliminarFuncion.add(beFuncion);
		
	}
	
	private void iniciarVerFuncion(){
		
		verFuncion.setLayout(null);
		
		cverFuncion = new JLabel();
		cverFuncion.setBounds(330, 350, 200, 20);
		cverFuncion.setFont(new Font("Serif",Font.PLAIN,16));
		cverFuncion.setText("NOMBRE DE LA FUNCION :");
		cverFuncion.setForeground(new Color(253, 254, 254));
		
		iverFuncion = new JTextField();
		iverFuncion.setBounds(330, 380, 190, 15);
		iverFuncion.setBorder(null);
		
		
		
		
		bvFuncion = new JButton();
		bvFuncion.setBounds(60,260,150,40);
		bvFuncion.setText("Ver Funcion");
		bvFuncion.setFont(new Font("Serif", Font.BOLD,16));
		bvFuncion.setBorder(null);
		bvFuncion.addActionListener(this);
		bvFuncion.setBackground(new Color(175,175,175));
		
		back.add(cverFuncion);
		back.add(iverFuncion);
		verFuncion.add(bvFuncion);
		
	}
	
	private void iniciarModificarDescuento(){
		
		modificarDescuento.setLayout(null);
		
		
		
		bmDescuento = new JButton();
		bmDescuento.setBounds(60,260,150,40);
		bmDescuento.setText("Modificar Descuento");
		bmDescuento.setFont(new Font("Serif", Font.BOLD,16));
		bmDescuento.setBorder(null);
		bmDescuento.addActionListener(this);
		bmDescuento.setBackground(new Color(175,175,175));
		
		
		modificarDescuento.add(bmDescuento);
		
	}
	
	private JFrame getFrame(){
		return this;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ConectBDD conn= new ConectBDD();
		if(e.getSource()==bcPelicula){
			
			if((iNombre.getText().equals(""))||(iGenero.getText().equals(""))||(iDuracion.getText().equals("//"))||(iIdioma.getText().equals(".."))){
				
				JOptionPane.showMessageDialog(null, "No puede ingresar campos vacios");
				
			}else{
				
				String nombre=iNombre.getText();
				String genero=iGenero.getText();
				String duracion=iDuracion.getText();
				String idioma=iIdioma.getText();
				
				try {
					conn.cargarPelicula(nombre, genero, duracion, idioma);
					
					JOptionPane.showInternalMessageDialog(null, "Pelicula guardada con exito");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
			
		}if(e.getSource()==bePelicula){
			
			if(iNombres.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "No se pueden ingresar campos vacios");
				
			}else {
				boolean value=false;
				String tabla="pelicula";
				String nombre=iNombres.getText();
				try {
					value=conn.verificarFuncion(nombre,tabla);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				if (value==true) {
				try {
					
					conn.eliminacion(nombre, tabla);
					JOptionPane.showMessageDialog(null, "Pelicula eliminada");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}else {
					JOptionPane.showMessageDialog(null, "Pelicula no encontrada");
				}
			}
			
		}if(e.getSource()==bcFuncion){
			if((inombreFuncion.getText().equals(""))||(ipelicula.getText().equals(""))||(ifecha.getText().equals(""))||(ihora.getText().equals(""))||(isala.getText().equals(""))) {
				JOptionPane.showMessageDialog(null, "No se pueden ingresar campos vacios");
				
			}else {
				
				boolean value=false;
				String tabla="funcion";
				String nombre=inombreFuncion.getText();
				try {
					value=conn.verificarFuncion(nombre,tabla);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				if(value==false) {
					String pelicula= ipelicula.getText();
					String fecha= ifecha.getText();
					String sala= isala.getText();
					String hora=ihora.getText();
					try {
					conn.cargarFuncion(nombre, pelicula, fecha, hora, sala);
					JOptionPane.showMessageDialog(null, "Funcion guardada con exito");
					} catch (SQLException e1) {
					e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Funcion ya existente.");
				}
				
			}
			
			
			
		}if(e.getSource()==beFuncion){
			if(iNombreFuncione.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "No se pueden ingresar campos vacios");
				
			}else {
				boolean value=false;
				String tabla="funcion";
				String nombre=iNombreFuncione.getText();
				try {
					value=conn.verificarFuncion(nombre,tabla);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				if(value==true) {
					
					try {
						conn.eliminacion(nombre, tabla);
						JOptionPane.showMessageDialog(null, "Funcion eliminada");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {
					
					JOptionPane.showMessageDialog(null, "Funcion no encontrada");
				}
				
			}
	
		}if(e.getSource()==bvFuncion){
			if(iverFuncion.getText().equals("")) {
				
				JOptionPane.showMessageDialog(null, "No se pueden ingresar campos vacios");
				
				
			}else {
				boolean value=false;
				String tabla="funcion";
				String nombre=iverFuncion.getText();
				try {
					value=conn.verificarFuncion(nombre,tabla);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				if(value==true) {
					
					JOptionPane.showMessageDialog(null, "Funcion  encontrada");
					
				
				
				}else {
					
					JOptionPane.showMessageDialog(null, "Funcion no encontrada");
					
				}
				
			}
			
		}if(e.getSource()==bmDescuento){
			
			
			getFrame().dispose();
		}
	
	}

}