package clasesPrincipalesCinemar;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;

import conexionBDD.ConectBDD;

public class CalculosDimensionales{
	
	public CalculosDimensionales(){
		
	}
	
	public int tamañoYPanel() throws SQLException{
		
			ConectBDD cantPelicula = new ConectBDD();
			
			int panelY = cantPelicula.getCantPeliculas();
			panelY*=200;
			
		return panelY;
	}
	
}
