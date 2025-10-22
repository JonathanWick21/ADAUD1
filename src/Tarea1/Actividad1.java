package Tarea1;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Actividad1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce la ruta");

        Path ruta = Paths.get(scan.nextLine());

        if (Files.exists(ruta) && Files.isDirectory(ruta))

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)){
                stream.forEach(path -> {
                    System.out.print(path.getFileName() + "es un ");
                    if (Files.isDirectory(path))
                        System.out.println("directorio");
                    else
                        System.out.println("fichero");
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }
}
