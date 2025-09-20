package Tarea1_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class Actividad2 {
    public static void main(String[] args) {
        Path path = Path.of("./salida.bin");

        try (FileInputStream fis = new FileInputStream(path.toFile())){
            int byteLeido;

            while ((byteLeido = fis.read()) != -1){
                System.out.println(byteLeido);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
