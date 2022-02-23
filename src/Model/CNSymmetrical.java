package Model;

import javax.crypto.*;

/**
 * Cifrado de un mensaje utilizando la clase Cipher En este ejemplo se usa el
 * algoritmo DES
 **/
public class CNSymmetrical {

	public static String funcionSymmCN(String contraseña) {
		String contraseñaCifrada = null;
		try {
			System.out.println("Obteniendo generador de claves con cifrado AES");
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			System.out.println("Generando la clave");
			SecretKey key = keygen.generateKey();
			System.out.println("Obteniendo objeto Cipher con cifrado AES");
			Cipher aesCipher = Cipher.getInstance("AES");
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
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			SecretKey key = keygen.generateKey();
			Cipher aesCipher = Cipher.getInstance("AES");
			aesCipher.init(Cipher.ENCRYPT_MODE, key);
			String mensajeCifrado = new String(aesCipher.doFinal(contraseñaCifrada.getBytes()));
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