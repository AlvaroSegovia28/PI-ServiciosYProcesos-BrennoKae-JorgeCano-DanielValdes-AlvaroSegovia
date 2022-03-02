package Model;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class CNAsymmetrical {
	
	Conexion bd = new Conexion();
	KeyPair keypair;
	PublicKey publicKeypair;
	PrivateKey privateKeypair;
	KeyPairGenerator keygen;
	public String prvkey;
	Cipher rsaCipher;
	byte [] mensaje;
	
	public void generarClaveANC(String user) {
		try {
			System.out.println("Obteniendo generador de claves con cifrado RSA");
			keygen = KeyPairGenerator.getInstance("RSA");
			System.out.println("Generando par de claves");
			keypair = keygen.generateKeyPair();
			publicKeypair = keypair.getPublic();
			privateKeypair = keypair.getPrivate();
			prvkey = Base64.getEncoder().encodeToString(privateKeypair.getEncoded());
			//bd.ingresarKey(keypair.getPrivate(), user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String encriptarCN(String contrase�a) {
		try {
			System.out.println("Obteniendo objeto Cipher con cifrado RSA");
			rsaCipher = Cipher.getInstance("RSA");
			System.out.println("Configurando Cipher para encriptar con clave privada");
			rsaCipher.init(Cipher.ENCRYPT_MODE, keypair.getPublic());
			mensaje = contrase�a.getBytes();
			System.out.println("Mensaje original: " + new String(mensaje));
			System.out.println("Cifrando mensaje");
			mensaje = rsaCipher.doFinal(mensaje);
			System.out.println("Mensaje cifrado: " + new String(mensaje));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(mensaje);
	}
	
	public String desencriptarCN(String contrase�a) {
		try {
			System.out.println("Configurando Cipher para desencriptar usando clave p�blica");
			rsaCipher.init(Cipher.DECRYPT_MODE, keypair.getPrivate());
			System.out.println("Descifrando mensaje");
			System.out.println("Mensaje descifrado: " + new String(rsaCipher.doFinal(mensaje)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contrase�a;
	}
}