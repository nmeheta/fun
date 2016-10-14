import java.security.*;
import javax.crypto.*;
import java.io.*;
public class AES_S
{
Cipher ecipher;
Cipher dcipher;
AES_S(SecretKey key)
	{
	try
	{
	ecipher=Cipher.getInstance("AES");
	dcipher=Cipher.getInstance("AES");
	ecipher.init(Cipher.ENCRYPT_MODE,key);
	dcipher.init(Cipher.DECRYPT_MODE,key);
	}
	catch(Exception e)
	{		
	}
}
public String encrypt(String str)
{
try
{
byte[] utf8=str.getBytes("UTF8");
byte[] enc=ecipher.doFinal(utf8);
return new sun.misc.BASE64Encoder().encode(enc);
}
catch(Exception e)
{
}

return null;
}
public String decrypt(String str)
{
try
{
byte[] dec=new sun.misc.BASE64Decoder().decodeBuffer(str);
byte[] utf8=dcipher.doFinal(dec);
return new String(utf8,"UTF8");
}
catch(Exception e)
{
}
return null;
}
public static void main(String args[])
{
SecretKey key=null;
{
try
{
KeyGenerator KeyGen=KeyGenerator.getInstance("AES");
key=KeyGen.generateKey();
}
catch(Exception e)
{
e.printStackTrace();
}
AES_S disc=new AES_S(key);
String o="Advance Encryption Standard";
String en=disc.encrypt(o);
String dc=disc.decrypt(en);
System.out.println("Original text:"+o);
System.out.println("Encrypted Text:"+en);
System.out.println("Decrypted Text:"+dc);
}
}
}
-------------------------------------------------------------------------------------------------------------------------------
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
class DESalgo
{
public static void main(String args[])
{
try
{
KeyGenerator keygen=KeyGenerator.getInstance("DES");
Key key=keygen.generateKey();
Cipher cipher=Cipher.getInstance("DES/CBC/PKCS5Padding");
cipher.init(cipher.ENCRYPT_MODE,key);
String str="Data Encryption Standard";
System.out.println("\nOriginal string :"+str);
byte[] arr1=str.getBytes();
byte[] arr2=cipher.doFinal(arr1);
byte[] initvector=cipher.getIV();
System.out.println("\nEncrypted String :"+arr2);
IvParameterSpec ps=new IvParameterSpec(initvector);
cipher.init(cipher.DECRYPT_MODE,key,ps);
byte[] arr3=cipher.doFinal(arr2);
String str2=new String(arr3);
System.out.println("\nThe Decrypted String :"+str2);
}
catch(Exception e)
{
System.out.println(""+e);
}
}
}
---------------------------------------------------------------------------------------------------------------------
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
public class BlowFishCipher
{
public static void main(String args[])throws Exception
{
KeyGenerator keygen=KeyGenerator.getInstance("Blowfish");
SecretKey sy=keygen.generateKey();
Cipher cip=Cipher.getInstance("Blowfish");
cip.init(Cipher.ENCRYPT_MODE,sy);
System.out.println("\n Blowfish Cipher");
System.out.println("Enter a string:");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String inputText=br.readLine();
byte[] encrypted=cip.doFinal(inputText.getBytes());
cip.init(Cipher.DECRYPT_MODE,sy);
byte[] decrypted=cip.doFinal(encrypted);
String en=new String(encrypted);
System.out.println("\n");
String de=new String(decrypted);
System.out.println("Encrypted Text is:"+en);
System.out.println("Decrypted Text is:"+de);
}
}
-----------------------------------------------------------------------------------------------------------------------
