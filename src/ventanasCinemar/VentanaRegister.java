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

public class VentanaRegister extends JFrame implements ActionListener{
	
	private Container back;
	private Color cback;
	private VentanaPrincipal vPrincipal;
	private JLabel tNombre;
	private JLabel tApellido;
	private JLabel tDNI;
	private JLabel tCelular;
	private JLabel tEdad;
	private JLabel tMail;
	private JLabel tPass;
	private JLabel tConfirmPass;
	private JFormattedTextField iNombre;
	private JFormattedTextField iApellido;
	private JFormattedTextField iEdad;
	private JFormattedTextField iDNI;
	private JFormattedTextField iCelular;
	private JFormattedTextField iMail;
	private JPasswordField iPass;
	private JPasswordField iConfirmPass;
	private JButton iniciar;
	private JButton cancelar;
	private MaskFormatter mNombre;
	private MaskFormatter mApellido;
	private MaskFormatter mEdad;
	private MaskFormatter mDNI;
	private MaskFormatter mCelular;
	private MaskFormatter mMail;
	private MaskFormatter mPass;
	private Boolean validar;
	
	public VentanaRegister() throws ParseException, IOException{
		iniciador();
		
		Image Icono = ImageIO.read(new File("C:\\Users\\Faust\\eclipse-workspace\\ProyectoCinemar\\imagenes\\rsz_logocinemar.png"));
		this.setIconImage(Icono);
		
		setSize(300,270);
		setTitle("Registrarse");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void iniciador() throws ParseException{
		cback = new Color(175,175,175);
		
		mNombre = new MaskFormatter("???????????????????");
		mApellido = new MaskFormatter("?????????????????");
		mEdad = new MaskFormatter("##/##/####");
		mDNI = new MaskFormatter("##.###.###");
		mCelular = new MaskFormatter("+54 ### # ######");
		mMail = new MaskFormatter("AAAAAAAAAAAAAAAAAAAAAA@gmail.com");
		
		back = getContentPane();
		back.setLayout(null);
		back.setBackground(cback);
		
		tNombre = new JLabel();
		tNombre.setBounds(10,10,100,15);
		tNombre.setFont(new Font("Serif",Font.PLAIN,13));
		tNombre.setText("Nombre/s: ");
		
		tApellido = new JLabel();
		tApellido.setBounds(160,10,100,15);
		tApellido.setFont(new Font("Serif",Font.PLAIN,13));
		tApellido.setText("Apellido/s:");
		
		tEdad = new JLabel();
		tEdad.setBounds(10,60,150,15);
		tEdad.setFont(new Font("Serif",Font.PLAIN,13));
		tEdad.setText("Fecha de Nacimiento:");
		
		tDNI = new JLabel();
		tDNI.setBounds(160,60,100,15);
		tDNI.setFont(new Font("Serif",Font.PLAIN,13));
		tDNI.setText("Documento:");
		
		tCelular = new JLabel();
		tCelular.setBounds(10,110,100,15);
		tCelular.setFont(new Font("Serif",Font.PLAIN,13));
		tCelular.setText("Celular:");
		
		tMail = new JLabel();
		tMail.setBounds(160,110,100,15);
		tMail.setFont(new Font("Serif",Font.PLAIN,13));
		tMail.setText("Correo:");
		
		tPass = new JLabel();
		tPass.setBounds(10,160,100,15);
		tPass.setFont(new Font("Serif",Font.PLAIN,13));
		tPass.setText("Contraseña:");
		
		tConfirmPass = new JLabel();
		tConfirmPass.setBounds(160,160,150,15);
		tConfirmPass.setFont(new Font("Serif",Font.PLAIN,13));
		tConfirmPass.setText("Confirmar Contraseña:");				
		
		iNombre = new JFormattedTextField(mNombre);
		iNombre.setFocusLostBehavior(JFormattedTextField.PERSIST);
		iNombre.setBounds(10, 30, 120, 15);
		iNombre.setBorder(null);
		
		iApellido = new JFormattedTextField(mApellido);
		iApellido.setFocusLostBehavior(JFormattedTextField.PERSIST);
		iApellido.setBounds(160, 30, 120, 15);
		iApellido.setBorder(null);
		
		iEdad = new JFormattedTextField(mEdad);
		iEdad.setBounds(10, 80, 120, 15);
		iEdad.setBorder(null);
		
		iDNI = new JFormattedTextField(mDNI);
		iDNI.setBounds(160, 80, 120, 15);
		iDNI.setBorder(null);
		
		iCelular = new JFormattedTextField(mCelular);
		iCelular.setBounds(10, 130, 120, 15);
		iCelular.setBorder(null);
		
		iMail = new JFormattedTextField(mMail);
		iMail.setFocusLostBehavior(JFormattedTextField.PERSIST);
		iMail.setBounds(160, 130, 120, 15);
		iMail.setBorder(null);
		
		iPass = new JPasswordField();
		iPass.setBounds(10, 180, 120, 15);
		iPass.setBorder(null);
		
		iConfirmPass = new JPasswordField();
		iConfirmPass.setBounds(160, 180, 120, 15);
		iConfirmPass.setBorder(null);
		
		iniciar = new JButton();
		iniciar.setBounds(40, 205, 100, 15);
		iniciar.setText("Registrarse");
		iniciar.setFont(new Font("Serif",Font.PLAIN,15));
		iniciar.addActionListener(this);
		
		cancelar = new JButton();
		cancelar.setBounds(150, 205, 100, 15);
		cancelar.setText("Cancelar");
		cancelar.setFont(new Font("Serif",Font.PLAIN,15));
		cancelar.addActionListener(this);
		
		back.add(tNombre);
		back.add(tApellido);
		back.add(tEdad);
		back.add(tDNI);
		back.add(tCelular);
		back.add(tMail);
		back.add(tPass);
		back.add(tConfirmPass);
		back.add(iNombre);
		back.add(iApellido);
		back.add(iEdad);
		back.add(iDNI);
		back.add(iCelular);
		back.add(iMail);
		back.add(iPass);
		back.add(iConfirmPass);
		back.add(iniciar);
		back.add(cancelar);
		
	}
	
	public JFrame getFrame(){
		return this;
	}	
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e){
		
		char[] tpass = iPass.getPassword();
		
		String pass = new String(tpass);
				
		char[] tconfirmpass = iConfirmPass.getPassword();
		
		String confirmpass = new String(tconfirmpass);
		
		if(e.getSource()==iniciar){
			
			if((iNombre.getText().replace(" ", "").equals(""))||(iApellido.getText().replace(" ", "").equals(""))||(iEdad.getText().replace(" ", "").equals("//"))||(iDNI.getText().replace(" ", "").equals(".."))||(iCelular.getText().replace(" ", "").equals("+54"))||(iMail.getText().replace(" ", "").equals("@gmail.com"))||(pass.replace(" ", "").equals(""))||(confirmpass.replace(" ", "").equals(""))){
				
				JOptionPane.showMessageDialog(null, "No puede ingresar campos vacios");
				
			}else{
				
				String nombre = iNombre.getText().replace(" ", "");
				
				String apellido = iApellido.getText().replace(" ", "");
				
				String edad = iEdad.getText().replace(" ", "");
				
				String dni = iDNI.getText().replace(" ", "");
				
				String celular = iCelular.getText().replace(" ", "");
				
				String mail = iMail.getText().replace(" ", "");
				
				pass.replace(" ", "");
				
				confirmpass.replace(" ", "");
				
				Integer verificarEdad = Integer.parseInt(edad.replace("/",""));
				
				verificarEdad%=10000;
			
					ConectBDD conectBDD = new ConectBDD();
					
					try {
						validar = conectBDD.verificar(mail);
					} catch (SQLException e3){
						e3.printStackTrace();
					}
				
					if(!validar){
					
						if(confirmpass.equals(pass)){	
							
							if((verificarEdad>1997)&&(verificarEdad<2009)){
								
								try {
									conectBDD.register(nombre, apellido, edad, dni, celular, mail, pass);
								} catch (SQLException e2) {
									e2.printStackTrace();
								}
							
								JOptionPane.showMessageDialog(null, "Registo Exitoso");
							
								try{
								
									vPrincipal = new VentanaPrincipal();
						
								}catch (IOException e1){
						
									e1.printStackTrace();
						
								}
					
								vPrincipal.setVisible(true);
					
								getFrame().dispose();
					
								}else{
									
									JOptionPane.showMessageDialog(null, "No cumple los requisitos de edad");
									
								}
							
							
						}else{
							
							JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
							
						}
						
					}else{
						
					JOptionPane.showMessageDialog(null, "El correo ingresado está ocupado");
					
					}
					
				}
			
			
		}else{
			
			try {
				vPrincipal = new VentanaPrincipal();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			vPrincipal.setVisible(true);
			
			getFrame().dispose();
		}
		
	}

}