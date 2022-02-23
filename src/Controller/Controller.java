package Controller;

import Model.Conexion;
import vistas.Detail;
import vistas.Login;
import vistas.Register;

public class Controller {
	public static void main(String[] args) {
//		Conexion bd = new Conexion();
		new Login().setVisible(true);
	}
}
