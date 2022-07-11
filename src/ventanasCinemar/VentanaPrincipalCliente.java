package ventanasCinemar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import clasesPrincipalesCinemar.CalculosDimensionales;
import conexionBDD.ConectBDD;

public class VentanaPrincipalCliente extends JFrame implements ActionListener{

	JTabbedPane vCliente;
	JPanel pCartelera;	
	JPanel pCuenta;
	JPanel historialCompra;
	JPanel modificarCompra;
	JPanel datosCuenta;
	JButton hacerReserva;
	JButton cerrarSesion;
	JLabel tHistorialCompra;
	JLabel tModificarCompra;
	JLabel tDatosCuenta;
	JLabel titulo;
	JLabel genero;
	JLabel duracion, idioma;
	JSeparator separadorCarteleraV1;
	JSeparator separadorCarteleraV2;
	JSeparator separadorCarteleraH;
	JSeparator ingreso;
	JTextField ingPelicula;
	JLabel textPelicula;
	Color cback = new Color(175,175,175);
	JScrollPane sCartelera = new JScrollPane();
	VentanaPrincipal vPrincipal;
	VentanaFunciones vDias;
	private String correo;
	
	public VentanaPrincipalCliente(String correo) throws IOException, SQLException{
		
		vCliente = new JTabbedPane();
		
		this.correo=correo;
		
		Image Icono = ImageIO.read(new File("C:\\Users\\Faust\\eclipse-workspace\\ProyectoCinemar\\imagenes\\rsz_logocinemar.png"));
		this.setIconImage(Icono);
		
		componentesCartelera();
		componentesCuenta();
		
		vCliente.addTab(" Cartelera ", sCartelera);
		vCliente.addTab(" Cuenta ", pCuenta);
	
		getContentPane().add(vCliente);
		setTitle("Cinemar - Sesion");
		setSize(400,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void componentesCartelera() throws IOException, SQLException{	
	
		CalculosDimensionales panelY = new CalculosDimensionales();
		
		pCartelera = new JPanel();
		pCartelera.setLayout(null);
		pCartelera.setBackground(Color.black);
		pCartelera.setPreferredSize(new Dimension(350,panelY.tamañoYPanel()));
		
		sCartelera.setBounds(0, 0, 400, 300);
		sCartelera.setViewportView(pCartelera);
		
		separadorCarteleraV1 = new JSeparator();
		separadorCarteleraV1.setOrientation(javax.swing.SwingConstants.VERTICAL);
		separadorCarteleraV1.setBounds(310,0,5,panelY.tamañoYPanel());
		separadorCarteleraV1.setForeground(Color.black);
		separadorCarteleraV1.setForeground(new Color(255, 205, 0));
		separadorCarteleraV1.setBackground(new Color(255, 205, 0));
		
		separadorCarteleraV2 = new JSeparator();
		separadorCarteleraV2.setOrientation(javax.swing.SwingConstants.VERTICAL);
		separadorCarteleraV2.setBounds(50,0,5,panelY.tamañoYPanel());
		separadorCarteleraV2.setForeground(Color.black);
		separadorCarteleraV2.setForeground(new Color(255, 205, 0));
		separadorCarteleraV2.setBackground(new Color(255, 205, 0));
	
		iniciarPeliculas();
		
		pCartelera.add(separadorCarteleraV2);
		pCartelera.add(separadorCarteleraV1);
		add(sCartelera);
		
	}
	
	public void iniciarPeliculas() throws SQLException{
		
			ConectBDD call = new ConectBDD();
			
			ArrayList <String> nombre1 = call.getNombrePelicula();
			ArrayList <String> genero1 = call.getGeneroPelicula();
			ArrayList <String> duracion1 = call.getDuracionPelicula();
			ArrayList <String> idioma1 = call.getIdiomaPelicula();
		  
		 	int acum=0;
		 	
		 	textPelicula = new JLabel();
		 	textPelicula.setBounds(70,5,220,20);
		 	textPelicula.setForeground(Color.white);
		 	textPelicula.setBackground(Color.white);
		 	textPelicula.setText("Ingrese el nombre de la pelicula: ");
		 	
		 	ingPelicula = new JTextField();
		 	ingPelicula.setBounds(70,25,220,20);
		 	ingPelicula.setBorder(null);
		 	
		 	hacerReserva = new JButton();
		 	hacerReserva.setBounds(70,50,220,20);
		 	hacerReserva.setText("Reservar");
		 	hacerReserva.setBackground(Color.black);
		 	hacerReserva.setForeground(Color.white);
		 	hacerReserva.addActionListener(this);
		 	
		 	ingreso = new JSeparator();
		 	ingreso.setBounds(50,75,260,5);
		 	ingreso.setForeground(new Color(255, 205, 0));
			ingreso.setBackground(new Color(255, 205, 0));
			
			for(int i=0;i<call.getCantPeliculas();i++){	
			
			titulo = new JLabel();
			genero = new JLabel();
			duracion = new JLabel();
			idioma = new JLabel();
			
			titulo.setBounds(80, 90+acum, 200, 20);
			genero.setBounds(80, 130+acum, 200, 20);
			duracion.setBounds(80, 170+acum, 200, 20);
			idioma.setBounds(80, 210+acum, 200, 20);
			
			titulo.setText("PELICULA: "+nombre1.get(i));
			titulo.setForeground(new Color(255, 205, 0));
			genero.setText("GENERO: "+genero1.get(i));
			genero.setForeground(new Color(255, 205, 0));
			duracion.setText("DURACION: "+duracion1.get(i));
			duracion.setForeground(new Color(255, 205, 0));
			idioma.setText("IDIOMA: "+idioma1.get(i));
			idioma.setForeground(new Color(255, 205, 0));
			
			separadorCarteleraH = new JSeparator();
			separadorCarteleraH.setBounds(0,250+acum,400,5);
			separadorCarteleraH.setForeground(new Color(255, 205, 0));
			separadorCarteleraH.setBackground(new Color(255, 205, 0));
			
			pCartelera.add(titulo);
			pCartelera.add(genero);
			pCartelera.add(duracion);
			pCartelera.add(idioma);
			pCartelera.add(separadorCarteleraH);
			
			acum=acum+180;
			
			}
			
			pCartelera.add(ingPelicula);
			pCartelera.add(textPelicula);
			pCartelera.add(hacerReserva);
			pCartelera.add(ingreso);

		}
	
	private void componentesCuenta(){
		
		pCuenta = new JPanel();
		pCuenta.setLayout(null);
		pCuenta.setBackground(new Color(255, 205, 0));
		
		datosCuenta();
		
		add(pCuenta);
		
	}
	
	private void datosCuenta(){
		
		datosCuenta = new JPanel();
		datosCuenta.setLayout(null);
		datosCuenta.setBounds(5, 5, 370, 425);
		datosCuenta.setBackground(Color.black);
		
		tDatosCuenta = new JLabel();
		tDatosCuenta.setBounds(100,30,300,18);
		tDatosCuenta.setText("Datos de la Cuenta");
		tDatosCuenta.setFont(new Font("Serif",Font.PLAIN,20));
		tDatosCuenta.setBackground(Color.white);
		tDatosCuenta.setForeground(Color.white);
		
		cerrarSesion = new JButton();
		cerrarSesion.setBounds(100, 380, 150, 30);
		cerrarSesion.setText("Cerrar Sesion");
		cerrarSesion.addActionListener(this);
		
		datosCuenta.add(cerrarSesion);	
		pCuenta.add(datosCuenta);
		datosCuenta.add(tDatosCuenta);
	}
	
	
	private JFrame getFrame(){
		return this;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){	
		if(e.getSource()==cerrarSesion){
			try {
				vPrincipal = new VentanaPrincipal();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			vPrincipal.setVisible(true);
			getFrame().dispose();
		}else{
			
			ConectBDD call = new ConectBDD();
			
			ArrayList<String> nombre1 = new ArrayList<String>();
			try {
				nombre1 = call.getNombrePelicula();
			} catch (SQLException e2){
				e2.printStackTrace();
			}
			
			Boolean band=false;
			
			for(int i=0; i<nombre1.size();i++){
				if(ingPelicula.getText().equals(nombre1.get(i))){
					band=true;
				}
			}
			
			if(e.getSource()==hacerReserva){
				
				if(band){
					
						try {
							vDias = new VentanaFunciones(false, true, ingPelicula.getText(), "",correo);
						} catch (IOException | SQLException e1){
							e1.printStackTrace();
						}
						
						vDias.setVisible(true);
						
						getFrame().dispose();
						
				}else{
						
					JOptionPane.showMessageDialog(null, "El nombre ingresado no es válido");
						
				}
				
				
			}
			
		}
	}

}


