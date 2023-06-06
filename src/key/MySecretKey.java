package key;

import java.security.Key;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MySecretKey {
   private static final String AESALGORITHM = "AES";
   public void generateAndSaveKey(String secretKeyFilename) throws Exception {
	   KeyGenerator keygen = KeyGenerator.getInstance("AES");
	   keygen.init(128);
	   SecretKey secretKey = keygen.generateKey();
	   SaveAndLoadKey salk = new SaveAndLoadKey();
	   salk.saveSecretKey(secretKey, secretKeyFilename);
   }

}