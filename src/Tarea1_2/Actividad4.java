package Tarea1_2;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Actividad4 {
    public static void main(String[] args) {
        byte[] millon = new byte[1000000];
        new Random(42).nextBytes(millon);

        Path path = Path.of("./salida");

        try {
            //FOS -> Va escribiendo directamente en la memoria del disco, es mas lento
            long inicio1 = System.nanoTime();
            try (FileOutputStream fos = new FileOutputStream(path.toFile())){
                fos.write(millon);
            }
            long fin1 = System.nanoTime();
            System.out.println("Tiempo FileOutPutStream = " + (fin1-inicio1) / 1000000);

            long inicio2 = System.nanoTime();

            //BOS este -> Los va guardando en el buffer y lo va volcando, va mas rapido
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path.toFile()))){
                bos.write(millon);
            }
            long fin2 = System.nanoTime();
            System.out.println("Tiempo BufferedOutputStream = " + (fin2 - inicio2) / 1000000);


            //Files.write -> Usa buffers de optimizados de NIO, es el mas eficiente normalmente
            long inicio3 = System.nanoTime();
            Files.write(path, millon);
            long fin3 = System.nanoTime();
            System.out.println("Tiempo Files.write = " + (fin3-inicio3) / 1000000);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
