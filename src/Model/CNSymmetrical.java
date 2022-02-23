package Model;

import javax.crypto.*;

/**
 * Cifrado de un mensaje utilizando la clase Cipher En este ejemplo se usa el
 * algoritmo DES
 **/
public class CNSymmetrical {
	
	public static String funcionSymmCN(String contrase�a) {
		String contrase�aCifrada = null;
		try {
			System.out.println("Obteniendo generador de claves con cifrado AES");
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			System.out.println("Generando la clave");
			SecretKey key = keygen.generateKey();
			System.out.println("Obteniendo objeto Cipher con cifrado AES");
			Cipher aesCipher = Cipher.getInstance("AES");
			System.out.println("Configurando Cipher para encriptar");
			aesCipher.init(Cipher.ENCRYPT_MODE, key);
			System.out.println("mensaje original: " + contrase�a);
			contrase�aCifrada = new String(aesCipher.doFinal(contrase�a.getBytes()));
			System.out.println("Mensaje cifrado: " + contrase�aCifrada);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contrase�aCifrada;
	}
	
	public static String desencryptionCN(String contrase�aCifrada) {
		String mensajeDescifrado = null;
		try {
			System.out.println("Configurando Cipher para desencriptar");
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			SecretKey key = keygen.generateKey();
			Cipher aesCipher = Cipher.getInstance("AES");
			aesCipher.init(Cipher.ENCRYPT_MODE, key);
			String mensajeCifrado = new String(aesCipher.doFinal(contrase�aCifrada.getBytes()));
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