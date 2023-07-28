import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetWorkingUseInetAdress {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("www.example.com");
        String ipAddress = inetAddress.getHostAddress();
        System.out.println("IP Address: " + ipAddress);

        String hostName = inetAddress.getHostName();
        System.out.println("Host Name: " + hostName);

        boolean reachable = inetAddress.isReachable(5000);
        System.out.println("Reachable: " + reachable);
    }
}

