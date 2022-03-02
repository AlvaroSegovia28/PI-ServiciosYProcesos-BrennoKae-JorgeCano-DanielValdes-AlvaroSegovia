package Model;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;

import javax.crypto.Cipher;

import vistas.Register;

public class CNAsymmetrical {
	
	Conexion bd = new Conexion();
	KeyPair keypair;
	PublicKey publicKeypair;
	KeyPairGenerator keygen;
	Cipher rsaCipher;
	byte [] mensaje;
	
	public void generarClaveANC(String user) {
		try {
			System.out.println("Obteniendo generador de claves con cifrado RSA");
			keygen = KeyPairGenerator.getInstance("RSA");
			System.out.println("Generando par de claves");
			keypair = keygen.generateKeyPair();
			publicKeypair = keypair.getPublic();
			bd.ingresarKey(keypair.getPrivate().toString(), user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String encriptarCN(String contraseña) {
		try {
			System.out.println("Obteniendo objeto Cipher con cifrado RSA");
			rsaCipher = Cipher.getInstance("RSA");
			System.out.println("Configurando Cipher para encriptar con clave privada");
			rsaCipher.init(Cipher.ENCRYPT_MODE, keypair.getPublic());
			mensaje = contraseña.getBytes();
			System.out.println("Mensaje original: " + new String(mensaje));
			System.out.println("Cifrando mensaje");
			mensaje = rsaCipher.doFinal(mensaje);
			System.out.println("Mensaje cifrado: " + new String(mensaje));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(mensaje);
	}
	
	public String desencriptarCN(String contraseña) {
		try {
			System.out.println("Configurando Cipher para desencriptar usando clave pública");
			rsaCipher.init(Cipher.DECRYPT_MODE, keypair.getPrivate());
			System.out.println("Descifrando mensaje");
			System.out.println("Mensaje descifrado: " + new String(rsaCipher.doFinal(mensaje)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contraseña;
	}
}