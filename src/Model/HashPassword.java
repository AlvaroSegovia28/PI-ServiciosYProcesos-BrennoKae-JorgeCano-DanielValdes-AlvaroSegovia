package Model;
import java.security.spec.KeySpec;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * Creaci�n de una clave utilizando el algoritmo DES. En este ejemplo se usa *
 * adem�s SecretKey que implementa la interfaz Key, y la clase SecretKeyFactory
 * que est� dise�ada para operar con objetos SecretKey
 */
public class HashPassword {
	public static void main(String[] args) {
		try {
			System.out.println("Obteniendo generador de claves con cifrado DES");
			KeyGenerator keygen = KeyGenerator.getInstance("DES");
			System.out.println("Generando la clave");
			SecretKey key = keygen.generateKey();
			System.out.println("Obteniendo la factor�a de claves con cifrados DES");
			SecretKeyFactory keyfac = SecretKeyFactory.getInstance("DES");
			System.out.println("Generando keyspec");
			KeySpec keyspec = keyfac.getKeySpec(key, DESKeySpec.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}