import java.net.*;
import java.io.*;
class Echoclient
{
public static void main(String args[])
{
try
{
Socket cs=new Socket("LocalHost",7000);
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
DataInputStream ifs=new DataInputStream(cs.getInputStream());
DataOutputStream ofs=new DataOutputStream(cs.getOutputStream());
String uinput;
System.out.println("enter bye to stop");
System.out.println("input");
while((uinput=br.readLine())!=null)
{
ofs.writeBytes(uinput+"\n");
System.out.println("echo:"+ifs.readLine());
if(uinput.equals("Bye"))
break;
System.out.println("input");
}
ofs.close();
ifs.close();
br.close();
cs.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
}