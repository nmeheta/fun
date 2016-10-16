import java.net.*;
import java.io.*;
class tcpserverfact
{
public static void main(String arg[])
{
try
{
ServerSocket ss=new ServerSocket(8001);
System.out.println("Server started");
Socket s=ss.accept();
DataInputStream ifc=new DataInputStream(s.getInputStream());
String str=ifc.readLine();
System.out.println("the number is"+str);
int fact=1;
int a=Integer.parseInt(str);
for(int i=1;i<=a;i++)
{
fact=fact*i;
}
String str1=fact+"\n";
DataOutputStream ofc=new DataOutputStream(s.getOutputStream());
ofc.writeBytes(str1);
}
catch(Exception e)
{
System.out.println(e.toString());
}
}
}