package Model;

import javax.crypto.*;

/**
 * Cifrado de un mensaje utilizando la clase Cipher En este ejemplo se usa el
 * algoritmo DES
 **/
public class CNSymmetrical {


	public SecretKey key;
	KeyGenerator keygen;
	Cipher aesCipher;
	private String mensajeCifrado;
	private String mensajeDescifrado;
	
	public String funcionSymmCN(String contrase�a) {
		try {
			System.out.println("Obteniendo generador de claves con cifrado AES");
			keygen = KeyGenerator.getInstance("AES");
			System.out.println("Generando la clave");
			key = keygen.generateKey();
			System.out.println("Obteniendo objeto Cipher con cifrado AES");
			aesCipher = Cipher.getInstance("AES");
			System.out.println("Configurando Cipher para encriptar");
			aesCipher.init(Cipher.ENCRYPT_MODE, key);
			String mensaje = contrase�a;
			System.out.println("mensaje original: "+mensaje);
			mensajeCifrado = new String(aesCipher.doFinal(contrase�a.getBytes()));
			System.out.println("Mensaje cifrado: "+mensajeCifrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mensajeCifrado;
	}

	public String desencryptionCN(String contrase�aCifrada) {
		try {
			aesCipher = Cipher.getInstance("AES");
			System.out.println("Configurando Cipher para desencriptar");
			aesCipher.init(Cipher.DECRYPT_MODE, key);
			String mensajeDescifrado = new String(aesCipher.doFinal(contrase�aCifrada.getBytes()));
			System.out.println("Mensaje descifrado: "+mensajeDescifrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mensajeDescifrado;
	}
} 