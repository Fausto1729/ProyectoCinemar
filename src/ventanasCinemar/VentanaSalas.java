package ventanasCinemar;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import conexionBDD.ConectBDD;

public class VentanaSalas extends JFrame implements ActionListener{

	private Container contenedor;
	private JButton completar;
	private VentanaConfirmarReserva vConfirmar;
	private JCheckBox a1,a2,a3,a4,a5,b1,b2,b3,b4,b5,c1,c2,c3,c4,c5,d1,d2,d3,d4,d5,e1,e2,e3,e4,e5;
	private JLabel nombreSala;
	private int idFuncion;
	private String correo;
	private JButton cancelar;
	private VentanaPrincipalCliente vPrincipal;
	
	public VentanaSalas(int idFuncion, String correo) throws IOException, SQLException{
		
		iniciarComponentes(idFuncion);
		
		this.correo = correo;
		
		this.idFuncion=idFuncion;
		
		Image Icono = ImageIO.read(new File("C:\\Users\\Faust\\eclipse-workspace\\ProyectoCinemar\\imagenes\\rsz_logocinemar.png"));
		this.setIconImage(Icono);
		
		setSize(290,270);
		setTitle("Cinemar - Salas");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniciarComponentes(int idFuncion) throws SQLException{
		
		contenedor = getContentPane();
		contenedor.setLayout(null);
		
		a1 = new JCheckBox();a2= new JCheckBox();a3= new JCheckBox();a4= new JCheckBox();a5= new JCheckBox();
		b1= new JCheckBox();b2= new JCheckBox();b3= new JCheckBox();b4= new JCheckBox();b5= new JCheckBox();
		c1= new JCheckBox();c2= new JCheckBox();c3= new JCheckBox();c4= new JCheckBox();c5= new JCheckBox();
		d1= new JCheckBox();d2= new JCheckBox();d3= new JCheckBox();d4= new JCheckBox();d5= new JCheckBox();
		e1= new JCheckBox();e2= new JCheckBox();e3= new JCheckBox();e4= new JCheckBox();e5= new JCheckBox();
		
		ConectBDD butacas = new ConectBDD();
		
		ArrayList <Boolean> estButacas = new ArrayList<Boolean>();
		
		estButacas = butacas.getEstSala(idFuncion);
		
		a1.setBounds(20,40,40,20);
		a1.setText("a1");
		contenedor.add(a1);
		
		b1.setBounds(70,40,40,20);
		b1.setText("b1");
		b1.addActionListener(this);
		contenedor.add(b1);
		
		c1.setBounds(120,40,40,20);
		c1.setText("c1");
		contenedor.add(c1);
		
		d1.setBounds(170,40,40,20);
		d1.setText("d1");
		contenedor.add(d1);
		
		e1.setBounds(220,40,40,20);
		e1.setText("e1");
		contenedor.add(e1);
		
		a2.setBounds(20,70,40,20);
		a2.setText("a2");
		contenedor.add(a2);
		
		b2.setBounds(70,70,40,20);
		b2.setText("b2");
		contenedor.add(b2);
		
		c2.setBounds(120,70,40,20);
		c2.setText("c2");
		contenedor.add(c2);
		
		d2.setBounds(170,70,40,20);
		d2.setText("d2");
		contenedor.add(d2);
		
		e2.setBounds(220,70,40,20);
		e2.setText("e2");
		contenedor.add(e2);
		
		a3.setBounds(20,100,40,20);
		a3.setText("a3");
		contenedor.add(a3);
		
		b3.setBounds(70,100,40,20);
		b3.setText("b3");
		contenedor.add(b3);
		
		c3.setBounds(120,100,40,20);
		c3.setText("c3");
		contenedor.add(c3);
		
		d3.setBounds(170,100,40,20);
		d3.setText("d3");
		contenedor.add(d3);
		
		e3.setBounds(220,100,40,20);
		e3.setText("e3");
		contenedor.add(e3);
		
		a4.setBounds(20,130,40,20);
		a4.setText("a4");
		contenedor.add(a4);
		
		b4.setBounds(70,130,40,20);
		b4.setText("b4");
		contenedor.add(b4);
		
		c4.setBounds(120,130,40,20);
		c4.setText("c4");
		contenedor.add(c4);
		
		d4.setBounds(170,130,40,20);
		d4.setText("d4");
		contenedor.add(d4);
		
		e4.setBounds(220,130,40,20);
		e4.setText("e4");
		contenedor.add(e4);
		
		a5.setBounds(20,160,40,20);
		a5.setText("a5");
		contenedor.add(a5);
		
		b5.setBounds(70,160,40,20);
		b5.setText("b5");
		contenedor.add(b5);
		
		c5.setBounds(120,160,40,20);
		c5.setText("c5");
		contenedor.add(c5);
		
		d5.setBounds(170,160,40,20);
		d5.setText("d5");
		contenedor.add(d5);
		
		e5.setBounds(220,160,40,20);
		e5.setText("e5");
		contenedor.add(e5);
		
		nombreSala = new JLabel();
		nombreSala.setBounds(110, 5, 100, 40);
		nombreSala.setText("Sala: ");
		
		completar = new JButton();
		completar.setBounds(40, 200, 100, 20);
		completar.setText("Reservar");
		completar.addActionListener(this);
		
		contenedor.add(completar);
		contenedor.add(nombreSala);
		
		a1.setVisible(estButacas.get(0));
		b1.setVisible(estButacas.get(1));
		c1.setVisible(estButacas.get(2));
		d1.setVisible(estButacas.get(3));
		e1.setVisible(estButacas.get(4));
		a2.setVisible(estButacas.get(5));
		b2.setVisible(estButacas.get(6));
		c2.setVisible(estButacas.get(7));
		d2.setVisible(estButacas.get(8));
		e2.setVisible(estButacas.get(9));
		a3.setVisible(estButacas.get(10));
		b3.setVisible(estButacas.get(11));
		c3.setVisible(estButacas.get(12));
		d3.setVisible(estButacas.get(13));
		e3.setVisible(estButacas.get(14));
		a4.setVisible(estButacas.get(15));
		b4.setVisible(estButacas.get(16));
		c4.setVisible(estButacas.get(17));
		d4.setVisible(estButacas.get(18));
		e4.setVisible(estButacas.get(19));
		a5.setVisible(estButacas.get(20));
		b5.setVisible(estButacas.get(21));
		c5.setVisible(estButacas.get(22));
		d5.setVisible(estButacas.get(23));
		e5.setVisible(estButacas.get(24));
		
		cancelar = new JButton();
		cancelar.setBounds(150,200,100,20);
		cancelar.setText("cancelar");
		cancelar.addActionListener(this);
		
		contenedor.add(cancelar);		
	}
	
	private JFrame getFrame(){
		return this;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==completar){
			
			ArrayList <Boolean> valor = new ArrayList<Boolean>();
			
			valor.add(!a1.isSelected());
			valor.add(!b1.isSelected());
			valor.add(!c1.isSelected());
			valor.add(!d1.isSelected());
			valor.add(!e1.isSelected());
			valor.add(!a2.isSelected());
			valor.add(!b2.isSelected());
			valor.add(!c2.isSelected());
			valor.add(!d2.isSelected());
			valor.add(!e2.isSelected());
			valor.add(!a3.isSelected());
			valor.add(!b3.isSelected());
			valor.add(!c3.isSelected());
			valor.add(!d3.isSelected());
			valor.add(!e3.isSelected());
			valor.add(!a4.isSelected());
			valor.add(!b4.isSelected());
			valor.add(!c4.isSelected());
			valor.add(!d4.isSelected());
			valor.add(!e4.isSelected());
			valor.add(!a5.isSelected());
			valor.add(!b5.isSelected());
			valor.add(!c5.isSelected());
			valor.add(!d5.isSelected());
			valor.add(!e5.isSelected());
			
			ConectBDD butacas = new ConectBDD();
			
			ArrayList <Boolean> estButacas = new ArrayList<Boolean>();
			
			try {
				estButacas = butacas.getEstSala(idFuncion);
			} catch (SQLException e7) {
				e7.printStackTrace();
			}
			
			for(byte i=0;i<25;i++){
				if((valor.get(i))&&(!estButacas.get(i))){
					valor.set(i, false);
				}
			}
				
			try {
				butacas.setButacas(valor, this.idFuncion);
			} catch (SQLException e6) {
				e6.printStackTrace();
			} catch (ClassNotFoundException e6) {
				e6.printStackTrace();
			}
			
			byte cont=0;
			
			for(byte i=0;i<=24;i++){
				
				if(!valor.get(i)){
					cont++;
				}
			}
			
			try {
				vConfirmar = new VentanaConfirmarReserva(this.idFuncion,cont, correo);
			} catch (IOException | SQLException e1) {
				e1.printStackTrace();
			}
			vConfirmar.setVisible(true);
			getFrame().dispose();
		}
		if(e.getSource()==cancelar){
		
			try {
				vPrincipal = new VentanaPrincipalCliente(correo);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			vPrincipal.setVisible(true);
			getFrame().dispose();
		}
		
		
		
	}
	
	

}
