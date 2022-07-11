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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import conexionBDD.ConectBDD;

public class VentanaConfirmarReserva extends JFrame implements ActionListener{
	
	private Container contenedor;
	private JButton cancelar;
	private JButton confirmar;
	private VentanaPrincipalCliente vCliente;
	private JLabel nombre, sala, fecha, hora, cantidad;
	private int cant;
	private String correo;
	
	public VentanaConfirmarReserva(int idFuncion, byte contador, String correo) throws IOException, SQLException{
		
		iniciarComponentes(idFuncion, contador);
		
		this.cant = contador;
		
		Image Icono = ImageIO.read(new File("C:\\Users\\Faust\\eclipse-workspace\\ProyectoCinemar\\imagenes\\rsz_logocinemar.png"));
		this.setIconImage(Icono);
		
		setSize(300,300);
		setTitle("Cinemar - Confirmacion");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniciarComponentes(int idFuncion, byte contador) throws SQLException{
		
		ConectBDD funcion = new ConectBDD();
		
		ArrayList<String> datos = new ArrayList<String>();
		
		datos = funcion.getConfirmFuncion(idFuncion);
		
		JLabel nombre = new JLabel();
		JLabel sala = new JLabel();
		JLabel fecha = new JLabel();
		JLabel hora = new JLabel();
		JLabel cantidad = new JLabel();
		
		nombre.setBounds(10,10,200,20);
		nombre.setText("PELICULA: "+datos.get(0));
		
		sala.setBounds(10,40,200,20);
		sala.setText("SALA DE CINE: "+datos.get(1));
		
		fecha.setBounds(10,70,200,20);
		fecha.setText("FECHA DE FUNCION: "+datos.get(2));
		
		hora.setBounds(10,100,200,20);
		hora.setText("HORA DE FUNCION: "+datos.get(3));
		
		cantidad.setBounds(10, 130, 200, 20);
		cantidad.setText("CANTIDAD DE BUTACAS: "+contador);
		
		contenedor = getContentPane();
		contenedor.setLayout(null);
		
		cancelar = new JButton();
		cancelar.setBounds(20,220,100,20);
		cancelar.setText("cancelar");
		cancelar.addActionListener(this);
		
		confirmar = new JButton();
		confirmar.setBounds(170, 220, 100, 20);
		confirmar.setText("confirmar");
		confirmar.addActionListener(this);
		
		contenedor.add(cancelar);
		contenedor.add(confirmar);
		contenedor.add(nombre);
		contenedor.add(sala);
		contenedor.add(fecha);
		contenedor.add(hora);
		contenedor.add(cantidad);
		
	}
	
	private JFrame getFrame(){
		return this;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==confirmar){
			
			ConectBDD reserva = new ConectBDD();
			
			try {
				reserva.setReserva(this.cant,correo);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null,"Reserva Exitosa","Cinemar - Reserva", JOptionPane.INFORMATION_MESSAGE);
			
			try {
				vCliente = new VentanaPrincipalCliente(correo);
				vCliente.setVisible(true);
				getFrame().dispose();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}else{
			
			JOptionPane.showMessageDialog(null,"Reserva Cancelada","Cinemar - Reserva", JOptionPane.INFORMATION_MESSAGE);
			
			try {
				vCliente = new VentanaPrincipalCliente(correo);
				vCliente.setVisible(true);
				getFrame().dispose();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (SQLException e1){
				e1.printStackTrace();
			}

		}
		
	}

}
