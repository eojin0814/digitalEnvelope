package digitalSign;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

import javax.crypto.Cipher;

import javax.crypto.SecretKey;

import key.SaveAndLoadKey;


public class DigitSign {
  
   final static String SIGNALGORITHM = "SHA256withRSA";
   //private static final String AES_ALGO = "AES";
   protected static FileInputOutput fileIO = new FileInputOutput();
   public static String sign(String fileName,String PrivateKeyName) throws ClassNotFoundException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException {
       
    	   SaveAndLoadKey saveloadkey = new SaveAndLoadKey();
           PrivateKey privateKey = saveloadkey.PrivateloadKey(PrivateKeyName);
           Signature privateSignature = Signature.getInstance("SHA256withRSA");
           privateSignature.initSign(privateKey);
           byte[] datafile = fileIO.readFile(fileName);
           privateSignature.update(datafile);
           byte[] signature = privateSignature.sign();
           return Base64.getEncoder().encodeToString(signature);
   }
   public static boolean verifySignarue(String fileName, String signature, String PublicKeyName) throws ClassNotFoundException, IOException {
       Signature sig;
       try {
    	   SaveAndLoadKey saveloadkey = new SaveAndLoadKey();
           PublicKey publicKey = saveloadkey.PublicloadKey(PublicKeyName);
           sig = Signature.getInstance("SHA256withRSA");
           sig.initVerify(publicKey);
           byte[] datafile = fileIO.readFile(fileName);
           sig.update(datafile);
           if (!sig.verify(Base64.getDecoder().decode(signature)));
       } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
           throw new RuntimeException(e);
       }
       return true;
   }
}
