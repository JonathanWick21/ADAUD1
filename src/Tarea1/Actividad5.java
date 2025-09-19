package Tarea1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Actividad5 {
    public static void main(String[] args) {
        Path entrada = Path.of("./entrada");
        Path textos = Path.of("./textos");
        Path imagenes = Path.of("./imagenes");


        Pattern regexTxt = Pattern.compile(".*\\.txt$");
        Pattern regexJpg = Pattern.compile(".*\\.jpg$");

        if (!Files.exists(textos))
            try {
                Files.createDirectory(textos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        if (!Files.exists(imagenes))
            try {
                Files.createDirectory(imagenes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(entrada)){
            for (Path path: stream){
             if (regexTxt.matcher(path.getFileName().toString()).matches()) {
                 Files.move(path, textos.resolve(path.getFileName()));
                 System.out.println("Se ha copiado el archivo " + path.getFileName() + " a la carpeta textos");
             }
             if (regexJpg.matcher(path.getFileName().toString()).matches()){
                 Files.move(path, imagenes.resolve(path.getFileName()));
                 System.out.println("Se ha copiado el archivo " + path.getFileName() + " a la carpeta de imagenes");
             }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
