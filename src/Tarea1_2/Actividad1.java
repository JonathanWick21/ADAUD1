package Tarea1_2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Actividad1 {
    public static void main(String[] args) {
        byte[] datos = {65, 66, 67};
        Path path = Path.of("./salida.bin");


        //Version FileOutputStream se SOBRESCRIBEN los datos del fichero-+
        try (FileOutputStream fos = new FileOutputStream(path.toFile())){
            fos.write(datos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Version Files.write en este caso con el APPEND se AÑADEN los datos al fichero
        try {
            Files.write(path, datos, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
