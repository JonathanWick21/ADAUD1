package Tarea1_2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class Actividad5 {
    public static void main(String[] args) {

    }
    public static void esPng(Path path){
        byte[] png = {-119, 80, 78, 71, 13, 10, 26, 10};
        byte [] prueba = new byte[png.length];

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path.toFile()))){
           bis.read(prueba);
            if (Arrays.equals(prueba, png))
                System.out.println("PNG válido");
            else
                System.out.println("No es PNG");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
