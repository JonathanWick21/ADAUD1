package Tarea3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Actividad7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce una ruta");

        Path ruta = Path.of(scan.nextLine());

        if (!Files.exists(ruta))
            System.out.println("La ruta introducida no es correcta");
        else {
            try (Stream<Path> stream = Files.walk(ruta)){
                long tamañoTotal=0;
                int totalFicheros=0;
                int totalDirectorios=0;
                List<Path> paths = stream.toList();

                for (Path path: paths){
                    tamañoTotal += Files.size(path);
                    if (Files.isRegularFile(path))
                        totalFicheros++;
                    else if (Files.isDirectory(path)) {
                        totalDirectorios++;
                    }
                }
                System.out.println("Base: " + ruta);
                System.out.printf("Tamaño total:  %.2f MB, %.2f KB (%d bytes)%n", tamañoTotal/ (1024.0*1024.0), tamañoTotal/1024.0, tamañoTotal);
                System.out.println("Ficheros: " + totalFicheros);
                System.out.println("Directorios: " + totalDirectorios + " (incluida la base)");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
