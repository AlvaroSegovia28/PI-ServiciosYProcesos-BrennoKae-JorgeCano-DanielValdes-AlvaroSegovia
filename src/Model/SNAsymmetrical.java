package Model;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class SNAsymmetrical {

	Conexion bd = new Conexion();

	KeyPair keypair;
	KeyPairGenerator keygen;
	Cipher rsaCipher;

	PrivateKey privateKeypair;
	PublicKey publicKeypair;
	public String prvkey;

	byte[] mensaje;

	public void generateKeyASN() {
		try {
			System.out.println("Obteniendo generador de claves con cifrado RSA");
			keygen = KeyPairGenerator.getInstance("RSA");
			System.out.println("Generando par de claves");
			KeyPair keypair = keygen.generateKeyPair();
			publicKeypair = keypair.getPublic();
			privateKeypair = keypair.getPrivate();
			prvkey = Base64.getEncoder().encodeToString(privateKeypair.getEncoded());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String encryptSN(String contraseña) {
		try {
			System.out.println("Obteniendo objeto Cipher con cifrado RSA");
			rsaCipher = Cipher.getInstance("RSA");
			System.out.println("Configurando Cipher para encriptar con clave privada");
			rsaCipher.init(Cipher.ENCRYPT_MODE, publicKeypair);
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

	public static PrivateKey getPrivateKey(String prvKey2) {
		PrivateKey prvKey = null;
		try {
			String privateK = prvKey2;
			byte[] privateBytes = Base64.getDecoder().decode(privateK);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			prvKey = keyFactory.generatePrivate(keySpec);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return prvKey;
	}

	public PrivateKey desencryptSN(PrivateKey privateKey) {
		try {

			System.out.println("Configurando Cipher para desencriptar usando clave pública");
			rsaCipher.init(Cipher.DECRYPT_MODE, keypair.getPrivate());
			System.out.println("Descifrando mensaje");
			System.out.println("Mensaje descifrado: " + new String(rsaCipher.doFinal(mensaje)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return privateKey;
	}
}