import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class FicherosCaracteres {

    //FileReader, FileWriter, BufferedReader, BufferedWriter
    //Files.read...


    public static void main(String[] args) {
        //regex
        //[0123456789]{3}

        //Files.readAllLines() --> List
        //Files.readString() --> String
        //Files.lines()
        //try(BufferedReader br = Files.newBufferedReader())


        //Files.write(list)
        //Files.writeString(String)
        //BufferedWriter bw = Files.newBufferedWriter()

        //preposiciones palabras longitud hasta 3
        //contar cuantas preposiciones hay en el texto

        try(Stream<String> stream =
                Files.lines(Path.of("Files/texto.txt"))){
            long numero = stream
                    .flatMap(linea -> Arrays.stream(linea.split("\\s")))
                    .filter(s -> s.matches("[A-Za-z]{1,3}"))
                    .count();
            System.out.println(numero);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        try(Stream<String> stream =
//                Files.lines(Path.of("Files/texto.txt"))){
//            stream
//                    .flatMap(linea -> Arrays.stream(linea.split(" ")))
//                    .filter(s -> s.matches(".*[0-9].*"))
//                    .map(s -> 2)
//                    .forEach(System.out::println);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }

    public static void mainLectBuffer(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("Files/texto.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void mainEscBuffer(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Files/texto.txt", true))){
            bw.write("Pedro Sanchez");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void mainLecturaSinBuffer(String[] args) {
        try(FileReader fr = new FileReader("Files/texto.txt")){
            int c;
            while ((c = fr.read()) != -1){
                System.out.print
                        ((char) c);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
//        try(FileWriter fw = new FileWriter("Files/texto.txt", true)){
//            fw.write("Estoy en clase de ada");
//            fw.write("\n");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
