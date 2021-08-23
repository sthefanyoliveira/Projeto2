/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author victo
 */
public class Client {
    public static void main(String[] args) {
        File f = new File("\\Users\\Thety\\Desktop\\sponte.pdf");
        try {
            Socket socket = new Socket("127.0.0.1",9696);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Transferindo arquivo: "+f.getName());
            out.writeUTF(f.getName());
            out.writeLong(f.length());
            FileInputStream in = new FileInputStream(f);
            byte[] buf = new byte[4096];
            while (true) {                
                int len = in.read(buf);
                if(len == -1){
                    break;
                }
                out.write(buf,0,len);
                
            }
            out.close();
                socket.close();
                System.out.println("Pronto");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
