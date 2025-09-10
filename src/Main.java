import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //java.io

        File f = new File("Files/ada.txt");
        System.out.println(f.isFile());

        boolean exist = f.exists();

        //java.nio
        Path ruta = Path.of("Files/ada.txt");
        Path ruta2 = Paths.get("Files/ada.txt");

        boolean existeRuta = Files.exists(ruta);
        try {
            Path nuevoFile = Path.of("files/nuevo.txt");
            if (!Files.exists(nuevoFile))
                Files.createFile(nuevoFile);
            Files.copy(ruta, nuevoFile);

            //solo devuelve el tamaño de ficheros, no directorios
            Long tam = Files.size(Path.of(""));

            //operaciones con directorios
            Path dir = Paths.get("dir");
            Path newDir = Files.createDirectory(dir);
            System.out.println(newDir);

            Files.createDirectories(Path.of("newDir/a/b"));



            try (DirectoryStream<Path> stream = Files.newDirectoryStream(Path.of("Files"));){
                Consumer<Path> c = p -> System.out.println(p);

                stream.forEach(p -> System.out.println(p));
            }


        } catch (IOException e) {
            System.err.println("Error al crear el fichero" + e.getMessage());
            e.printStackTrace();
        }


    }
}