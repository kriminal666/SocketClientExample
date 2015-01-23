# SocketClientExample
Simple Socket client example for android.
# Compile this java server
```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServer {
 
 public static void main(String[] args){
  ServerSocket serverSocket = null;
  Socket socket = null;
  DataInputStream dataInputStream = null;
  DataOutputStream dataOutputStream = null;
  
  try {
   serverSocket = new ServerSocket(8888);
   System.out.println("Listening :8888");
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
  while(true){
   try {
    socket = serverSocket.accept();
    dataInputStream = new DataInputStream(socket.getInputStream());
    dataOutputStream = new DataOutputStream(socket.getOutputStream());
    System.out.println("ip: " + socket.getInetAddress());
    System.out.println("message: " + dataInputStream.readUTF());
    dataOutputStream.writeUTF("Hello!");
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   finally{
    if( socket!= null){
     try {
      socket.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
    
    if( dataInputStream!= null){
     try {
      dataInputStream.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
    
    if( dataOutputStream!= null){
     try {
      dataOutputStream.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
   }
  }
 }
}
```
Try later the client using it's IP andn 8888 port:
![alt text](https://github.com/kriminal666/SocketClientExample/blob/master/1.png)
# Try using netcat :
```
 # apt-get install netcat-traditional
 # update-alternatives --config nc
```
Select:
```
 /bin/nc.traditional
```
Create a new server:
```
 # nc -l -p PUT_HERE_YOUR_PORT
```
And test the client using your server IP and Port.
![alt text]((https://github.com/kriminal666/SocketClientExample/blob/master/2.png)

