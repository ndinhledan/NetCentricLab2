import java.net.*;

public class Client {
    private static int PORT = 3000;

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ADDRESS = InetAddress.getByName("127.0.0.1");

        String str = "Nguyen Dinh Le Dan, TS4, 127.0.0.1";

        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ADDRESS, PORT);

        System.out.println("Sent data to server");
        ds.send(dp);

        byte[] receivedData = new byte[1024];

        DatagramPacket received = new DatagramPacket(receivedData, 1024);
        ds.receive(received);
        
        String receivedString = new String(received.getData(), 0, received.getLength());

        System.out.println("Received back from server: " + receivedString);
        
        ds.close();
    }
}