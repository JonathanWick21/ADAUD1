package Tarea1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Actividad7 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce la ruta");
        Path ruta = Path.of(scan.nextLine());
        Pattern regexJava = Pattern.compile(".*\\.java$");

        if (Files.exists(ruta) && Files.isDirectory(ruta)){
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)) {
                for (Path path : stream){
                    if (Files.isRegularFile(path) && regexJava.matcher(path.getFileName().toString()).matches())
                        System.out.println("Nombre: " + path.getFileName() + " - Tamaño: " + Files.size(path));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
