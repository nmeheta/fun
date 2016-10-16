import java.net.*;
import java.io.*;
class chatclient
{
public static void main(String args[])
{
try
{
Socket s=new Socket("LocalHost",8000);
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
DataOutputStream out=new DataOutputStream(s.getOutputStream());
DataInputStream in=new DataInputStream(s.getInputStream());
String msg;
System.out.println("to stop chatting with server stop");
System.out.println("client says");
while((msg=br.readLine())!=null)
{
out.writeBytes(msg+"\n");
if(msg.equals("stop"))
break;
System.out.println("server says"+in.readLine());
System.out.println("client says");
}
br.close();
in.close();
out.close();
s.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
}