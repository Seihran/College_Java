import java.io.*;
import java.net.*;

public class UDPServer
{
  private DatagramPacket sendPacket, receivePacket;
  private DatagramSocket socket;

  public UDPServer()
  {
    try {
      socket = new DatagramSocket( 5000 );
    }

    catch( SocketException socketException ) {
      socketException.printStackTrace();
      System.exit( 1 );
    }

  }

  public void waitForPackets()
  {
    while ( true )
    {
      try
      {
        byte data[] = new byte[ 100 ];
        receivePacket =
        new DatagramPacket( data, data.length );

        socket.receive( receivePacket );

        sendPacketToClient();
      }

      catch( IOException ioException )
      {
        ioException.printStackTrace();
      }

    }

  }

  private void sendPacketToClient() throws IOException
  {
    sendPacket = new DatagramPacket( receivePacket.getData(),
    receivePacket.getLength(), receivePacket.getAddress(),
    receivePacket.getPort() );

    socket.send( sendPacket );
  }
  
  public static void main( String args[] )
  {
    UDPServer application = new UDPServer();

    application.waitForPackets();
  }
}
