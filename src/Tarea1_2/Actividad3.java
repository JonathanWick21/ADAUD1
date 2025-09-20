package Tarea1_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Actividad3 {
    public static void main(String[] args) {
        Path path = Path.of("./salida.bin");

        try {
            byte [] bytes = Files.readAllBytes(path);
            Path salida = Path.of("./salidaCopia.bin");

            if (!Files.exists(salida) && !Files.isDirectory(salida))
                Files.createFile(salida);
            Files.write(salida, bytes);
            System.out.println("Tamaño del fichero: " + Files.size(salida));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
