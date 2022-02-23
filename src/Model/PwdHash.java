package Model;

import java.security.MessageDigest;

/**
 * Creaci�n de una clave utilizando el algoritmo DES. En este ejemplo se usa *
 * adem�s SecretKey que implementa la interfaz Key, y la clase SecretKeyFactory
 * que est� dise�ada para operar con objetos SecretKey
 */
public class PwdHash {

	public String funcionHash(String contrase�a) {
		String contrase�aHash = null;
		try {
			System.out.println("1.- Obteniendo la instancia con algoritmo MD5");
			MessageDigest md = MessageDigest.getInstance("MD5");
			System.out.println("2.- Actualizando el contenido de la instancia");
			byte[] c1 = contrase�a.getBytes();
			md.update(c1);
			System.out.println("3.- Calculando el resumen");
			byte[] resumen = md.digest();
			System.out.println("Resumen 1: " + new String(resumen));
			contrase�aHash = new String(resumen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contrase�aHash;

	}
}