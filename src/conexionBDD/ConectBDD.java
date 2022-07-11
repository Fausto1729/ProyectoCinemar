package conexionBDD;

import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class ConectBDD{
	
	 final  String JDBC_Driver="com.mysql.cj.jdbc.Driver";
	 final String DB_URL="jdbc:mysql://localhost:3306/cinemar";
	 final String USER="root";
	 final String PASS="PASS";
	 	Connection conn = null;
	 	Statement stmt=null;
	 private String rol; 
	
	public ConectBDD(){
		
		try {
			
			Class.forName(JDBC_Driver);
			conn = DriverManager.getConnection (DB_URL,USER,PASS);
			
			}catch(SQLException e){
			
			e.printStackTrace();
			
			}catch(Exception e) {
			
			e.printStackTrace();
			}
	}
	
	public void register(String nombre,String apellido, String edad, String dni, String celular, String mail, String pass) throws SQLException{
		
		stmt = conn.createStatement();
		
	   String sql="INSERT INTO persona(nombre,apellido,nacimiento,documento,telefono,correo,contraseña,roll)"
				 +" VALUES ('"+nombre+"','"+apellido+"','"+edad+"','"+dni+"','"+celular+"','"+mail+"','"+pass+"','cliente')";
	   
	    stmt.executeUpdate(sql);
		
	}

	public Boolean verificar(String correo)throws SQLException{
		
		Boolean validar=false;
		
		stmt= conn.createStatement();
		
		String sql="SELECT correo FROM persona";
		
		ResultSet rs= stmt.executeQuery(sql);
		
		while((rs.next())&&(!validar)){
			
				if(correo.equals(rs.getString("correo"))){
					
						validar = true;
								
				}
				
		}
		
		return validar;
		
	}
	
	public Boolean loginValidar(String mail, String pass) throws SQLException{
		
		Boolean validar = false;
		
		stmt = conn.createStatement();
		
		String sql = "select roll from persona where correo='"+mail+"' and contraseña='"+pass+"'" ;
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			
		if(!(rs.getString("roll").equals(""))){
			validar = true;
			
			this.rol=rs.getString("roll");
			
		}
		
		}
		
		return validar;
		
	}
	
	public String getRol(){
		
		return this.rol;
		
	}
	
	public int getCantPeliculas() throws SQLException{
		
		int cant=0;
		
		stmt = conn.createStatement();
		
		String sql = "select max(id) from pelicula";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			cant = rs.getInt("max(id)");
		}
		
		
		return cant;
	}
	
	public ArrayList<String> getNombrePelicula() throws SQLException{
		ArrayList <String> nombre = new ArrayList<String>();
		
		stmt = conn.createStatement();
		
		String sql = "select * from pelicula";
		
		ResultSet rs = stmt.executeQuery(sql);
		
			while(rs.next()){
				nombre.add(rs.getString("nombre"));
			}
		
		return nombre;
	}
	
	public ArrayList<String> getGeneroPelicula() throws SQLException{
		
		ArrayList <String> genero = new ArrayList<String>();
		
		stmt = conn.createStatement();
		
		String sql = "select * from pelicula";
		
		ResultSet rs = stmt.executeQuery(sql);
		
			while(rs.next()){
				genero.add(rs.getString("genero"));
			}
		
		return genero;
	}
	
	public ArrayList<String> getDuracionPelicula() throws SQLException{
		ArrayList <String> duracion = new ArrayList<String>();
		
		stmt = conn.createStatement();
		
		String sql = "select * from pelicula";
		
		ResultSet rs = stmt.executeQuery(sql);
		
			while(rs.next()){
				duracion.add(rs.getString("duracion"));
			}
		
		return duracion;
	}
	
	public ArrayList<String> getIdiomaPelicula() throws SQLException{
		ArrayList <String> idioma = new ArrayList<String>();
		
		stmt = conn.createStatement();
		
		String sql = "select * from pelicula";
		
		ResultSet rs = stmt.executeQuery(sql);
		
			while(rs.next()){
				idioma.add(rs.getString("idioma"));
			}
		
		return idioma;
	}
	
	public ArrayList<String> getFechas(String pelicula) throws SQLException{
		
		ArrayList <String> fechas = new ArrayList<String>();
		
		stmt = conn.createStatement();
		
		String sql = "select * from funcion where pelicula='"+pelicula+"'";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			fechas.add(rs.getString("fecha"));
		}
		
		return fechas;
	}
	
	public ArrayList<String> getFuncion(String dia, String pelicula) throws SQLException{
		
		ArrayList <String> funcion = new ArrayList<String>();
		
		stmt = conn.createStatement();
		
		String sql = "select * from funcion where fecha= '"+dia+"' and pelicula= '"+pelicula+"'";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			funcion.add(rs.getString("sala"));
			funcion.add(rs.getString("hora"));
		}
		
		return funcion;
	}
	
	public int getIdFuncion(String pelicula, String dia, String hora) throws SQLException{
		
		int funcion=0;
		
		stmt=conn.createStatement();
		
		String sql = "select * from funcion where (pelicula= '"+pelicula+"') and (fecha= '"+dia+"') and (hora= '"+hora+"')";

		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			funcion=rs.getInt("id");
		}
		
		return funcion;
	}
	
	public ArrayList<Boolean> getEstSala(int idFuncion) throws SQLException{
	
		ArrayList<Boolean> estSala = new ArrayList<Boolean>();
		
		stmt = conn.createStatement();
		
		String sql = "select * from butaca where funcion="+idFuncion;
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			estSala.add(rs.getBoolean("estado"));
		}
		
		return estSala;
		
	}
	
	public void setButacas(ArrayList<Boolean> valorButacas, int funcion) throws SQLException, ClassNotFoundException{
				byte c=0;
		for(byte i=0;i<=4;i++){
			
			stmt = conn.createStatement();
			
	
			
			String sql1 = "update butaca set estado="+valorButacas.get(c)+" where (butaca='a"+(i+1)+"') and (funcion="+funcion+")";
			String sql2 = "update butaca set estado="+valorButacas.get(c+1)+" where (butaca='b"+(i+1)+"') and (funcion="+funcion+")";
			String sql3 = "update butaca set estado="+valorButacas.get(c+2)+" where (butaca='c"+(i+1)+"') and (funcion="+funcion+")";
			String sql4 = "update butaca set estado="+valorButacas.get(c+3)+" where (butaca='d"+(i+1)+"') and (funcion="+funcion+")";
			String sql5 = "update butaca set estado="+valorButacas.get(c+4)+" where (butaca='e"+(i+1)+"') and (funcion="+funcion+")";
		
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			stmt.executeUpdate(sql5);
		
			c+=5;
		
		}
	}
	
	public ArrayList<String> getConfirmFuncion(int idFuncion) throws SQLException{
		
		ArrayList <String> funcion = new ArrayList<String>();
		
		stmt = conn.createStatement();
		
		String sql="select * from funcion where id="+idFuncion;
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()){
			funcion.add(rs.getString("pelicula"));
			funcion.add(rs.getString("sala"));
			funcion.add(rs.getString("fecha"));
			funcion.add(rs.getString("hora"));
		}
		
		return funcion;
		
	}
	
	public void setReserva(int cant, String correo) throws SQLException{
		
		stmt = conn.createStatement();
		
		String sql = "insert into reserva(butacas, titular) values ("+cant+",'"+correo+"')";
		
		stmt.executeUpdate(sql);
		
	}
	
	public int getSala(int idFuncion) throws SQLException{
		
		int cant = 0;
		
		stmt = conn.createStatement();
		
		String sql="select * from butaca where funcion= "+idFuncion;
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			cant = rs.getInt("funcion");
		}
		
		return cant;
	}
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	
    public void cargarPelicula(String nombre,String genero, String duracion, String idioma) throws SQLException{
		
		stmt = conn.createStatement();
		
	    String sql="INSERT INTO pelicula(nombre,genero,duracion,idioma)"
				 +" VALUES ('"+nombre+"','"+genero+"','"+duracion+"','"+idioma+"')";
	   
	    stmt.executeUpdate(sql);
		
	}
    public void eliminacion(String nombre, String tabla ) throws SQLException{
	
	stmt = conn.createStatement();
	
    String sql="DELETE FROM "+tabla+" WHERE nombre='"+nombre+"'";
			
    stmt.executeUpdate(sql);
	
}

    public void cargarFuncion(String nombre,String pelicula, String fecha, String hora,String sala) throws SQLException{
	
	stmt = conn.createStatement();
	
    String sql="INSERT INTO funcion (nombre,pelicula,fecha,hora, sala)"
			 +" VALUES ('"+nombre+"','"+pelicula+"','"+fecha+"','"+hora+"','"+sala+"')";
   
    stmt.executeUpdate(sql);
    
    }
    public Boolean verificarFuncion(String nombre,String tabla) throws SQLException {
    	boolean value=false;
    	stmt = conn.createStatement();
    	String sql="SELECT nombre FROM pelicula WHERE nombre='"+nombre+"'";
    	ResultSet rs=stmt.executeQuery(sql);
    	while(rs.next()) {
    		if (rs!=null) {
    			
    			value=true;
    			
    		}
    		}	
    	return value;
    }
    
    public ResultSet verFuncion(String nombre) throws SQLException {
    	stmt=conn.createStatement();
    	String sql="SELECT * FROM funcion WHERE nombre='"+nombre+"'";
    	ResultSet rs=stmt.executeQuery(sql);
    	return rs;
    }
}
	

