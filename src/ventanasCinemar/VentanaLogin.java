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
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import conexionBDD.ConectBDD;

public class VentanaLogin extends JFrame implements ActionListener{
	
	private Container back;
	private Color cback;
	private VentanaPrincipal vPrincipal;
	private VentanaPrincipalCliente vCliente;
	private VentanaPrincipalAdmin vAdmin;
	private JLabel tMail;
	private JLabel tPass;
	private JButton iniciar;
	private JButton cancelar;
	private JFormattedTextField iMail;
	private JPasswordField iPass;	
	private MaskFormatter mMail;
	private String contraseña;
	private String correo;
	private char[] ccontraseña;
	
	public VentanaLogin() throws ParseException, IOException{ 
		
		iniciador();
		
		Image Icono = ImageIO.read(new File("C:\\Users\\Faust\\eclipse-workspace\\ProyectoCinemar\\imagenes\\rsz_logocinemar.png"));
		this.setIconImage(Icono);
		
		setSize(250,180);
		setTitle("Ingresar");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void iniciador() throws ParseException{
		
		cback = new Color(175,175,175);
		
		mMail = new MaskFormatter("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA@gmail.com");
		
		back = getContentPane();
		back.setLayout(null);
		back.setBackground(cback);
		
		tMail = new JLabel();
		tMail.setBounds(10,10,200,15);
		tMail.setFont(new Font("Serif",Font.PLAIN,15));
		tMail.setText("Correo Electronico:");
		
		tPass = new JLabel();
		tPass.setBounds(10,60,100,15);
		tPass.setFont(new Font("Serif",Font.PLAIN,15));
		tPass.setText("Contraseña:");
		
		iMail = new JFormattedTextField(mMail);
		iMail.setFocusLostBehavior(JFormattedTextField.PERSIST);
		iMail.setBounds(10, 30, 200, 15);
		iMail.setBorder(null);
		
		iPass = new JPasswordField();
		iPass.setBounds(10, 80, 200, 15);
		iPass.setBorder(null);
		
		iniciar = new JButton();
		iniciar.setBounds(15, 110, 90, 15);
		iniciar.setText("Ingresar");
		iniciar.setFont(new Font("Serif",Font.PLAIN,15));
		iniciar.addActionListener(this);
		
		cancelar = new JButton();
		cancelar.setBounds(120, 110, 90, 15);
		cancelar.setText("Cancelar");
		cancelar.setFont(new Font("Serif",Font.PLAIN,15));
		cancelar.addActionListener(this);
		
		back.add(tMail);
		back.add(tPass);
		back.add(iMail);
		back.add(iPass);
		back.add(iniciar);
		back.add(cancelar);
		
	}
	
	private JFrame getFrame(){
		return this;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		ccontraseña = iPass.getPassword();
		contraseña = new String(ccontraseña).replace(" ", "");
		
		correo = iMail.getText().replace(" ","");
		
		Boolean login=false;
		
		String rol;
		
		if(e.getSource()==iniciar){
			
			ConectBDD validar = new ConectBDD();
			
			try {
				login = validar.loginValidar(correo, contraseña);
			} catch (SQLException e1){
				e1.printStackTrace();
			}
			
			if(login){
				
				rol = validar.getRol();
				
					if(rol.equals("administrador")){
						
						try {
							vAdmin = new VentanaPrincipalAdmin();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						vAdmin.setVisible(true);
						getFrame().dispose();
					}else{
						
						try {
							vCliente = new VentanaPrincipalCliente(correo);
						} catch (IOException | SQLException e1) {
							e1.printStackTrace();
						}
						
						vCliente.setVisible(true);
						getFrame().dispose();
						
					}
					
			}else{
				JOptionPane.showMessageDialog(null, "el correo o la contraseña ingresada es incorrecta");
			}
		
		}else{
			try {
				vPrincipal = new VentanaPrincipal();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
			
			vPrincipal.setVisible(true);
			
			getFrame().dispose();
		}
			
		}
		
		
	}


