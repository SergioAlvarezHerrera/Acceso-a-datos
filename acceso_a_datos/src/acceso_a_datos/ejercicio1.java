package acceso_a_datos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ejercicio1 {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.bin"))) {
            dos.writeInt(123);
            dos.writeDouble(45.67);
            dos.writeBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream("datos.bin"))) {
            int valorInt = dis.readInt();
            double valorDouble = dis.readDouble();
            boolean valorBoolean = dis.readBoolean();
            System.out.println("Int: " + valorInt);
            System.out.println("Double: " + valorDouble);
            System.out.println("Boolean: " + valorBoolean);
        } catch (IOException e) {
            e.printStackTrace();
}}}
