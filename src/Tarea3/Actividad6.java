package Tarea3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Actividad6 {
    public static void main(String[] args) {
        Path ruta = Path.of("./");

        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce los dias");
        int numeroDias = scan.nextInt();
        Instant dias = Instant.now().minus(Duration.ofDays(numeroDias));


        try (Stream<Path> stream = Files.find(ruta, Integer.MAX_VALUE,
                (p, attr) -> attr.lastModifiedTime().toInstant().isAfter(dias))){
            List<Path> ficheros = stream.sorted((p1, p2) -> {
                try {
                    FileTime t1 = Files.getLastModifiedTime(p1);
                    FileTime t2 = Files.getLastModifiedTime(p2);
                    return t2.compareTo(t1);
                } catch (IOException e) {
                    return 0;
                }
            }).toList();

            for (Path path: ficheros){
                System.out.println(path + "ultima fecha de modificacion: " + Files.getLastModifiedTime(path));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
