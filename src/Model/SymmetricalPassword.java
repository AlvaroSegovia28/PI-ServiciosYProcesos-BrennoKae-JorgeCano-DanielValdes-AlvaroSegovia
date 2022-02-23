package Model;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
	
/**
 * Cifrado de un mensaje utilizando la clase Cipher En este ejemplo se usa el
 * algoritmo DES
 **/
public class SymmetricalPassword {
	public static void main(String[] args) {
		try {
			System.out.println("Obteniendo generador de claves con cifrado DES");
			KeyGenerator keygen = KeyGenerator.getInstance("DES");
			System.out.println("Generando la clave");
			SecretKey key = keygen.generateKey();
			System.out.println("Obteniendo objeto Cipher con cifrado DES");
			Cipher desCipher = Cipher.getInstance("DES");
			System.out.println("Configurando Cipher par encriptar");
			desCipher.init(Cipher.ENCRYPT_MODE, key);
			System.out.println("Preparando mensaje");
			String mensaje = "Mensaje de prueba";
			System.out.println("mensaje original: " + mensaje);
			System.out.println("Cifrando mensaje");
			String mensajeCifrado = new String(desCipher.doFinal(mensaje.getBytes()));
			System.out.println("Mensaje cifrado: " + mensajeCifrado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}		