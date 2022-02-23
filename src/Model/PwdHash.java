package Model;

import java.security.MessageDigest;

/**
 * Creación de una clave utilizando el algoritmo DES. En este ejemplo se usa *
 * además SecretKey que implementa la interfaz Key, y la clase SecretKeyFactory
 * que está diseñada para operar con objetos SecretKey
 */
public class PwdHash {

	public static String funcionHash(String contraseña) {
		String contraseñaHash = null;
		try {
			System.out.println("1.- Obteniendo la instancia con algoritmo MD5");
			MessageDigest md = MessageDigest.getInstance("MD5");
			System.out.println("2.- Actualizando el contenido de la instancia");
			byte[] c1 = contraseña.getBytes();
			md.update(c1);
			System.out.println("3.- Calculando el resumen");
			byte[] resumen = md.digest();
			System.out.println("Resumen 1: " + new String(resumen));
			contraseñaHash = new String(resumen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contraseñaHash;

	}
}