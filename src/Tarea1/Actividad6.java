package Tarea1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Actividad6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce la ruta de tu carpeta");
        String rutaIntroducida = scan.nextLine();
        Path ruta = Path.of(rutaIntroducida);

        if (!Files.exists(ruta) || !Files.isDirectory(ruta))
            System.out.println("La ruta " + ruta + " no es un directorio valido");
        else
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)) {
                long total = 0;
                for (Path path: stream){
                    if (Files.isRegularFile(path)) {
                        try {
                            System.out.println("Nombre: " + path.getFileName() + " - Tamaño: " + Files.size(path));
                            total += Files.size(path);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                System.out.println("Total del tamaño de los archivos: " + total);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    }

