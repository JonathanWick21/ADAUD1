package Tarea3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Actividad4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce una ruta base: ");
        Path path = Path.of(scan.nextLine());

        System.out.println("Introduce un prefijo: ");
        String prefijo = scan.nextLine();

        System.out.println("Introduce la extension: ");
        String extension = scan.nextLine();


        try (Stream<Path> stream = Files.walk(path)){
            stream.filter(Files::isRegularFile)
                    .filter(path1 -> {
                        String nombre = path1.getFileName().toString();
                        return nombre.startsWith(prefijo) && nombre.endsWith(extension);
                    })
                    .forEach(p -> {
                        try {
                            System.out.println("Ruta: " + path.relativize(p) + " -- Tamaño: " + Files.size(p) / 1024);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
