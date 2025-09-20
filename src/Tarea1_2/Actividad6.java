package Tarea1_2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Actividad6 {
    public static void main(String[] args) {
        Path path = Path.of("./nota.txt");
        Scanner scan = new Scanner(System.in);

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Introduce una nueva frase");
        String frase = scan.nextLine();
        try (FileWriter fw = new FileWriter(path.toFile(), true)){
            fw.write(frase + System.lineSeparator());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
