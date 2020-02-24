import java.net.*;

public class Server {
    public static int PORT = 3000;
    public static String response = "Yeah yeah boi";

    public static void main(String[] args) throws Exception {
        
        DatagramSocket ds = new DatagramSocket(PORT);

        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, 1024);

        System.out.println("Listening on port 3000...");

        while (true){
            try {
                ds.receive(dp);

                String str = new String(dp.getData(), 0, dp.getLength());
                System.out.println("Received from client: " + str);
                
                DatagramPacket returnDp = new DatagramPacket(response.getBytes(), response.length(), dp.getAddress(), dp.getPort());

                ds.send(returnDp);  
                System.out.println("Sent to client");
            } catch (Exception e) {
                //TODO: handle exception
            } finally {
                ds.close();
            }
        }
    }
}