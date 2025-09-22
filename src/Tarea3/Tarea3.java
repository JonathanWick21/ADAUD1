package Tarea3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Tarea3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el minimo de MBs");

        int minimo = scan.nextInt();

        try (Stream<Path> stream = Files.find(Path.of("."), Integer.MAX_VALUE,
                (path, basicFileAttributes) -> basicFileAttributes.size() > minimo * 1_000_000)){
            stream.sorted((p1, p2) -> {
                try {
                    return Long.compare(Files.size(p2), Files.size(p1));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).forEach(path -> {
                try {
                    System.out.printf("%s | %.2f \n", path.toString(), (double)(Files.size(path) / 1_000_000));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
