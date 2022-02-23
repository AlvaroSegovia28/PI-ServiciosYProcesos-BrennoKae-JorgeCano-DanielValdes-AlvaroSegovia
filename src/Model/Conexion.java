package Model;
import java.sql.*;

public class Conexion {
	// Atributos de la clase
	private String bd = "bankaccount";
	private String login = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost/" + bd;
	private Connection conexion;

	// Constructor que crea la conexión
	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, login, pwd);
			System.out.println(" - Conexión con MySQL establecida -");
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

	public void Consulta(int id) {
		String procedimiento = "{call jugadores.nombre(?)}";
		try {
			CallableStatement ctmt = conexion.prepareCall(procedimiento);
			ctmt.setInt(1, id);
			ctmt.execute();
			ResultSet rset = ctmt.getResultSet();
			rset.next();
			System.out.println(rset.getString(1));
			rset.close();
			ctmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertar() {
		try {
			String sql = "INSERT INTO `jugadores` (`codigo`, `Nombre`, `Procedencia`, `Altura`, `Peso`, `Posicion`, `Nombre_equipo`) VALUES ('614', 'Brenno', 'Brasil', '172', '60', 'Base', '76ers');";
			Statement stmt = conexion.createStatement();
			int filas = stmt.executeUpdate(sql);
			System.out.println("Se han insertado " + filas + "filas/s");
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void modificar() {
		String sql = "UPDATE `jugadores` SET `Nombre` = 'Brennoooo' WHERE `codigo` = 614";
	}

	public void delete() {
		String sql = "DELETE FROM jugadores WHERE `Nombre` = 'Brennoooo'";
	}

	public void columnas() {
		try {
			String sql = "SELECT * FROM jugadores";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM AUTOR");
			ResultSetMetaData rsmd = rs.getMetaData();

			int nColumnas = rsmd.getColumnCount();
			System.out.println("Nombre tabla: " + rsmd.getTableName(1));
			System.out.println("La tabla tiene: " + rsmd.getColumnCount() + " columnas.");

			for (int i = 0; i < nColumnas + 1; i++) {
				System.out.println(rsmd.getCatalogName(i));
			}
			rs.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Conexion prueba = new Conexion();
		prueba.modificar();
	}

}