package Controller;

import Model.Conexion;
import vistas.Register;

public class Controller {
	public static void main(String[] args) {
//		Conexion bd = new Conexion();
		new Register().setVisible(true);
	}
}
