package Model;

import javax.crypto.*;

/**
 * Cifrado de un mensaje utilizando la clase Cipher En este ejemplo se usa el
 * algoritmo DES
 **/
public class CNSymmetrical {


	static KeyGenerator keygen;
	static SecretKey key;
	static Cipher aesCipher;
	
	public static String funcionSymmCN(String contraseña) {
		String contraseñaCifrada = null;
		try {
			System.out.println("Obteniendo generador de claves con cifrado AES");
			keygen = KeyGenerator.getInstance("AES");
			System.out.println("Generando la clave");
			key = keygen.generateKey();
			System.out.println("Obteniendo objeto Cipher con cifrado AES");
			aesCipher = Cipher.getInstance("AES");
			System.out.println("Configurando Cipher para encriptar");
			aesCipher.init(Cipher.ENCRYPT_MODE, key);
			System.out.println("mensaje original: " + contraseña);
			contraseñaCifrada = new String(aesCipher.doFinal(contraseña.getBytes()));
			System.out.println("Mensaje cifrado: " + contraseñaCifrada);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contraseñaCifrada;
	}

	public static String desencryptionCN(String contraseñaCifrada) {
		String mensajeDescifrado = null;
		try {
			System.out.println("Configurando Cipher para desencriptar");
			keygen = KeyGenerator.getInstance("AES");
			key = keygen.generateKey();
			aesCipher = Cipher.getInstance("AES");
//			aesCipher.init(Cipher.ENCRYPT_MODE, key);
			String mensajeCifrado = contraseñaCifrada;
			System.out.println("Configurando Cipher para desencriptar");
			aesCipher.init(Cipher.DECRYPT_MODE, key);
			mensajeDescifrado = new String(aesCipher.doFinal(mensajeCifrado.getBytes()));
			System.out.println("Mensaje descifrado: " + mensajeDescifrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mensajeDescifrado;
	}
}