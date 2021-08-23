/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author victo
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serv = new ServerSocket(9696);
            while (true) {
                System.out.println("Aguardando cliente...");
                Socket socket = serv.accept();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                String filename = in.readUTF();
                long size = in.readLong();
                FileOutputStream fos = new FileOutputStream("Arquivos\\" + filename);
                byte[] buf = new byte[4096];
                while (true) {
                    int len = in.read(buf);
                    if (len == -1) {
                        break;
                    }
                    fos.write(buf, 0, len);

                }
                fos.flush();
                fos.close();
                System.out.println("Arquivo recebido.");

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
