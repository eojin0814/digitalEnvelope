package key;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.SecretKey;

public class SaveAndLoadKey {
	public void savePublicKey(PublicKey key, String fileName) {
		try(FileOutputStream fileStream = new FileOutputStream(fileName);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileStream))
		{
			 objectOutputStream.writeObject(key);
			 System.out.println(key.getEncoded());
			 
		}catch(IOException e) 
			{
			e.printStackTrace();
			}
		
	}
	public void savePrivateKey(PrivateKey key, String fileName) {
		try(FileOutputStream fileStream = new FileOutputStream(fileName);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileStream))
		{
			 objectOutputStream.writeObject(key);
			 System.out.println(key.getEncoded());
			 
		}catch(IOException e) 
			{
			e.printStackTrace();
			}
		
	}
	public PrivateKey PrivateloadKey(String fileName) throws ClassNotFoundException {
		PrivateKey key = null;
		try(FileInputStream fileStream = new FileInputStream(fileName); // 직렬화해서 썼던 파일을 다시 읽오는 역할
				ObjectInputStream objectInputStream = new ObjectInputStream(fileStream))
		{
			Object secretKey= objectInputStream.readObject();
			key =(PrivateKey)secretKey;
			
			System.out.println(key.getEncoded());
			return key;
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		return key;
	}
	public PublicKey PublicloadKey(String fileName) throws ClassNotFoundException {
		PublicKey key = null;
		try(FileInputStream fileStream = new FileInputStream(fileName); // 직렬화해서 썼던 파일을 다시 읽오는 역할
				ObjectInputStream objectInputStream = new ObjectInputStream(fileStream))
		{
			Object secretKey= objectInputStream.readObject();
			key =(PublicKey)secretKey;
			
			System.out.println(key.getEncoded());
			return key;
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		return key;
	}
	
	   public void saveSecretKey(SecretKey secretKey, String filename) {
	      try (FileOutputStream fstream = new FileOutputStream(filename)) {
	         try (ObjectOutputStream ostream = new ObjectOutputStream(fstream)) {
	            ostream.writeObject(secretKey);
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }

	  
	   //@SuppressWarnings("finally")
	public SecretKey loadSecretKey(String filename) throws FileNotFoundException, IOException {
	      SecretKey key = null;
	      try (FileInputStream fis = new FileInputStream(filename)) {
	         try (ObjectInputStream ois = new ObjectInputStream(fis)) {
	            Object obj = ois.readObject();
	            key = (SecretKey) obj;
	         } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	         } catch (FileNotFoundException e) {
	            e.printStackTrace();
	         } catch (IOException e) {
	            e.printStackTrace();
	         } finally {
	            return key;
	         }
	      }
	   }

}
