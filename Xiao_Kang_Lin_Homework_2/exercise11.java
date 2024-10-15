import java.net.InetAddress;

public class exercise11 {
    public static void main(String[] args)
        throws Exception 
        {
        System.out.println("IP of my system is: " + InetAddress.getLocalHost().getHostAddress());
        }
}