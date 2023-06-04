package key;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.PrivateKey;

public class SaveAndLoadKey {
	public void saveKey(Key key, String fileName) {
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
	public Key loadKey(String fileName) throws ClassNotFoundException {
		Key key = null;
		try(FileInputStream fileStream = new FileInputStream(fileName); // 직렬화해서 썼던 파일을 다시 읽오는 역할
				ObjectInputStream objectInputStream = new ObjectInputStream(fileStream))
		{
			Object secretKey= objectInputStream.readObject();
			key =(Key)secretKey;
			
			System.out.println(key.getEncoded());
			return key;
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		return key;
	}
	

}
