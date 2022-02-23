package Model;

import javax.crypto.*;

/**
 * Cifrado de un mensaje utilizando la clase Cipher En este ejemplo se usa el
 * algoritmo DES
 **/
public class CNSymmetrical {


	static SecretKey key;
	static Cipher aesCipher;
	private static String mensajeCifrado;
	private static String mensajeDescifrado;
	
	public static String funcionSymmCN(String contraseña) {
		try {
			System.out.println("Obteniendo generador de claves con cifrado AES");
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			System.out.println("Generando la clave");
			SecretKey key = keygen.generateKey();
			System.out.println("Obteniendo objeto Cipher con cifrado AES");
			Cipher aesCipher = Cipher.getInstance("AES");
			System.out.println("Configurando Cipher para encriptar");
			aesCipher.init(Cipher.ENCRYPT_MODE, key);
			String mensaje = contraseña;
			System.out.println("mensaje original: "+mensaje);
			mensajeCifrado = new String(aesCipher.doFinal(mensaje.getBytes()));
			System.out.println("Mensaje cifrado: "+mensajeCifrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mensajeCifrado;
	}

	public static String desencryptionCN(String contraseñaCifrada) {
		try {
			System.out.println("Configurando Cipher para desencriptar");
			aesCipher.init(Cipher.DECRYPT_MODE, key);
			String mensajeDescifrado = new String(aesCipher.doFinal(contraseñaCifrada.getBytes()));
			System.out.println("Mensaje descifrado: "+mensajeDescifrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mensajeDescifrado;
	}
}