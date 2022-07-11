package programaCinemar;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import conexionBDD.ConectBDD;
import ventanasCinemar.VentanaPrincipal;
import ventanasCinemar.VentanaPrincipalCliente;

public class AppPrincipalCinemar extends JFrame{
	
	public static void main(String[] args) throws IOException, SQLException{
		
		VentanaPrincipal inicio = new VentanaPrincipal();
		inicio.setVisible(true);
		
}
}
	
	

