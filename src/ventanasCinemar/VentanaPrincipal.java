package ventanasCinemar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private Container back;
	private JPanel panelPrincipal;
	private Color clogo;
	private Color cpanel;
	private Color cback;
	private Byte selOpcion;
	private VentanaLogin vLogin;
	private VentanaRegister vRegister;
	JButton login;
	JButton register;
	JLabel nombre; 
	JSeparator sepPanel1;
	JSeparator sepPanel2;
	JSeparator sepLogo1;
	JSeparator sepLogo2;
	
	public VentanaPrincipal() throws IOException{
		
		iniciador();
		
		Image Icono = ImageIO.read(new File("C:\\Users\\Faust\\eclipse-workspace\\ProyectoCinemar\\imagenes\\rsz_logocinemar.png"));
		this.setIconImage(Icono);
		
		setSize(600,300);
		setTitle("Cinemar - Página Principal");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void iniciador(){
		
		cback = new Color(175, 175, 175);
		
		back=getContentPane();
		back.setLayout(null);
		back.setBackground(cback);
		
		sepPanel1 = new JSeparator();
		sepPanel1.setBounds(0, 50, 600, 1);
		sepPanel1.setForeground(Color.black);
		
		sepPanel2 = new JSeparator();
		sepPanel2.setBounds(0, 52, 600, 1);
		sepPanel2.setForeground(Color.black);
		
		panelPrincipal();
		
		back.add(sepPanel1);
		back.add(sepPanel2);
		back.add(panelPrincipal);
		
	}
	
	private void panelPrincipal(){
		
		cpanel = new Color(66, 66, 66);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBounds(0, 0, 600, 50);
		panelPrincipal.setBackground(cpanel);
		
		clogo = new Color(255, 205, 0);
		
		nombre = new JLabel();
		nombre.setText("CINEMAR");
		nombre.setBounds(20, 10, 110, 30);
		nombre.setFont(new Font("Serif",Font.PLAIN , 20));
		nombre.setForeground(clogo);
		
		login = new JButton();
		login.setBounds(350, 15, 100, 20);
		login.setBackground(cback);
		login.setText("Iniciar Sesion");
		login.setFont(new Font("Serif",Font.PLAIN, 12));
		login.addActionListener(this);
		
		register = new JButton();
		register.setBounds(470, 15, 100, 20);
		register.setBackground(cback);
		register.setText("Registrarse");
		register.setFont(new Font("Serif",Font.PLAIN, 12));
		register.addActionListener(this);
		
		sepLogo1 = new JSeparator();
		sepLogo1.setOrientation(javax.swing.SwingConstants.VERTICAL);
		sepLogo1.setBounds(130, 0, 1, 50);
		sepLogo1.setForeground(Color.black);
		
		sepLogo2 = new JSeparator();
		sepLogo2.setOrientation(javax.swing.SwingConstants.VERTICAL);
		sepLogo2.setBounds(132, 0, 1, 50);
		sepLogo2.setForeground(Color.black);
		
		panelPrincipal.add(sepLogo1);
		panelPrincipal.add(sepLogo2);
		panelPrincipal.add(login);
		panelPrincipal.add(register);
		panelPrincipal.add(nombre);
		
	}
	
	private JFrame getFrame(){
		return this;
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==login){
			try {
				vLogin = new VentanaLogin();
			} catch (ParseException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			vLogin.setVisible(true);
			getFrame().dispose();
		}else{
			try {
				vRegister = new VentanaRegister();
				vRegister.setVisible(true);
				getFrame().dispose();
			} catch (ParseException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
		
	}
	
	
}
