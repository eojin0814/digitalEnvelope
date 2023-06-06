package key;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

public class GenerateKey {
	public static void main(String[] args) throws NoSuchAlgorithmException {
	
		Scanner scan = new Scanner(System.in);
		
		System.out.print("PublicKey FileName : ");
		String publicKeyFile = scan.next();
		
		System.out.print("PrivateKey FileName : ");
		String privateKeyFile = scan.next();
		
		
		MyKeyPair myKeyPair = MyKeyPair.getInstance();
		myKeyPair.createKeys();
		
		SaveAndLoadKey saveloadkey = new SaveAndLoadKey();
		
		saveloadkey.savePublicKey(myKeyPair.getPublicKey(), publicKeyFile);
		saveloadkey.savePrivateKey(myKeyPair.getPrivateKey(), privateKeyFile);
		
	}
}
