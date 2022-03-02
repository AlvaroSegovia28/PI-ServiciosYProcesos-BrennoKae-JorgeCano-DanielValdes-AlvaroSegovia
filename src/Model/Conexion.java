package Model;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.*;

public class Conexion {
	// Atributos de la clase
	private String bd = "bankaccount";
	private String login = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost/" + bd;
	private Connection conexion;
	CNSymmetrical CNSym = new CNSymmetrical();

	// Constructor que crea la conexi�n
	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, login, pwd);
			System.out.println(" - Conexi�n con MySQL establecida -");
			if (conexion != null) {
				System.out.println("Conexion al a bd" + url + "...ok!!");
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println(" Driver JDBC no encontrador");
			cnfe.printStackTrace();

		} catch (SQLException sqle) {
			System.out.println(" Error al conectarse a la BD");
			sqle.printStackTrace();

		} catch (Exception e) {
			System.out.println(" Error general");
			e.printStackTrace();
		}
	}

	// Register
	
	public void insertar(String miUser,String miPwd,String miNombre, String miSurname, String cardNumber, String key, String secretNumber) {
		try {
			String sql = "INSERT INTO `bankaccount` (`username`, `password`, `name`, `surname`, `cardnumber`, `keyS`, `sn`) VALUES ('"+miUser+"', '"+miPwd+"', '"+miNombre+"', '"+miSurname+"', '"+cardNumber+"', '"+key+"','"+secretNumber+"');";
			Statement stmt = conexion.createStatement();
			int filas = stmt.executeUpdate(sql);
			System.out.println("Se han insertado " + filas + "filas/s");
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	// Querys para modificar o deletear
	
//	public void modificar(String miUser,String miPwd,String miNombre, String miSurname, String cardNumber) {
//		String sql = "UPDATE `bankaccount` SET `x` = 'x' WHERE `x` = x";
//	}
//
//	public void delete(String miUser) {
//		String sql = "DELETE FROM bankaccount WHERE `username` = '"+miUser+"'";
//	}

	// Sacar contrase�a para hasheado
	
	public String sacarContrase�a(String miUser) {
		String codedPwd = "";
		try {
		String sql = "SELECT password FROM bankaccount WHERE `username` = '"+miUser+"'";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {				
			codedPwd = rs.getString("password");
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		return codedPwd;
	}

	public String sacarUser(String miUser) {
		String myUsr = "";
		try {
		String sql = "SELECT username FROM bankaccount WHERE `username` = '"+miUser+"'";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {				
			myUsr = rs.getString("username");
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		return myUsr;
	}
	
	public String sacarNombre(String miUser) {
		String myName = "";
		try {
		String sql = "SELECT name FROM bankaccount WHERE `username` = '"+miUser+"'";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {				
			myName = rs.getString("name");
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		return myName;
	}
	
	public String sacarApellido(String miUser) {
		String myLastName = "";
		try {
		String sql = "SELECT surname FROM bankaccount WHERE `username` = '"+miUser+"'";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {				
			myLastName = rs.getString("surname");
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		return myLastName;
	}
	
	public String sacarTarjeta(String miUser) {
		String myCN = "";
		String myCNDecoded = "";
		try {
		String sql = "SELECT cardnumber FROM bankaccount WHERE `username` = '"+miUser+"'";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {				
			myCN = rs.getString("cardnumber");
			}
			stmt.close();
			//myCNDecoded = CNSym.desencryptionCN(myCN);
			
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		return myCN;
	}
	public String sacarNum(String miUser) {
		String myCN = "";
		String myCNDecoded = "";
		try {
		String sql = "SELECT cardnumber FROM bankaccount WHERE `username` = '"+miUser+"'";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {				
			myCN = rs.getString("cardnumber");
			}
			stmt.close();
			//myCNDecoded = CNSym.desencryptionCN(myCN);
			
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		return myCN;
	}
	
	// Ingresar Key para cifrado asim�trico
	
	public void ingresarKey(PrivateKey privateKey, String miUser) {
		try {
		String sql = "INSERT INTO `bankaccount` (`keyA`) VALUES ('"+privateKey+"') WHERE `username` = '"+miUser+"'";
			Statement stmt = conexion.createStatement();
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
	}

	// Sacar Key para cifrado asim�trico
	
	public String sacarKey(String miUser) {
		String keyAs = "";
		try {
		String sql = "SELECT keyA FROM bankaccount WHERE `username` = '"+miUser+"'";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {				
				keyAs = rs.getString("password");
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		return keyAs;
	}

}