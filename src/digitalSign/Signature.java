package digitalSign;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import key.MyKeyPair;
import key.SaveAndLoadKey;

public class Signature {
	private static final String SIG_STAMP = "_SIGNATURED";
	private static final String EXTENTION = ".txt";
	private SaveAndLoadKey saveloadKey;
	private DigitSign digitSign;
	
	public Signature() {
		saveloadKey = new SaveAndLoadKey();
		digitSign = new DigitSign();
	}
	
	
	public void signAndSaveFile(String dataFilename, String keyFilename, String fileSavePath, String signedFileName)
			throws InvalidKeyException, FileNotFoundException, ClassCastException, ClassNotFoundException {
		Key key = saveloadKey.loadKey(keyFilename);
		
		PrivateKey privateKey = (PrivateKey)key;
		
		byte [] signature = digitSign.sign(dataFilename, privateKey);
		
		if(signedFileName.equals("")) {
		
			File file = new File(dataFilename);
			System.out.println(file.getName());
			String [] splited = file.getName().split("\\.");
			System.out.println(splited[0]);
			signedFileName = splited[0] + SIG_STAMP;
		}
		fileSavePath = fileSavePath + "/" + signedFileName + EXTENTION;
		

		digitSign.writeFile(fileSavePath, signature);
	}
	
	
}
