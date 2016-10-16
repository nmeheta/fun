import java.net.*;
import java.io.*;
class Echoserver
{
public static void main(String args[])
{
try
{
ServerSocket ss=new ServerSocket(7000);
System.out.println("server started");
Socket s=ss.accept();
DataInputStream ifc=new DataInputStream(s.getInputStream());
DataOutputStream ofc=new DataOutputStream(s.getOutputStream());
String input;
while((input=ifc.readLine())!=null)
{
System.out.println("server"+input);
ofc.writeBytes(input+"\n");
if(input.equals("bye"));
break;
}
ofc.close();
ifc.close();
s.close();
ss.close();
}
catch (Exception e)
{
e.printStackTrace();
}
}
}
