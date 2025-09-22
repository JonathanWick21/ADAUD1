package Tarea3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Actividad1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce una ruta");
        Path path = Path.of(scan.nextLine());
        if (Files.exists(path)){
            try (Stream<Path> stream = Files.walk(path, 2)){
                stream.forEach(path1 -> {
                    System.out.println(Files.isDirectory(path1) ? path1 + " es directorio" : path1 + " es fichero");
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else
            System.out.println("No existe tal directorio");

    }
}
