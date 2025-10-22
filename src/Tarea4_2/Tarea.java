package Tarea4_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Tarea {
    private static final Path BASE_PROPERTIES = Path.of("./config/app.properties");
    private static final Path DEV_PROPERTIES = Path.of("./config/app.dev.properties");
    private static final Path PROD_PROPERTIES = Path.of("./config/app.prod.properties");

    private static final Properties CURRENT_PROPERTIES = new Properties();
    private final static String[] filesLoaded = new String[2];

    public static void main(String[] args) {

    }

    public static void exectueProgram(){

    }

    public void showCurrentProperties(){
        try {
            System.out.println("Propiedades actuales: ");
            CURRENT_PROPERTIES.forEach((name, value) ->
                    System.out.println(name.toString() + "=" + value.toString()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadProperties(){
        try {
            CURRENT_PROPERTIES.load(Files.newBufferedReader(BASE_PROPERTIES));

            String env = CURRENT_PROPERTIES.getProperty("app.env");
            if (env.equals("dev"))
                loadDevProperties();
            else if (env.equals("prod")) {
                loadProdProperties();
            } else
                System.out.println("No se ha detectado ninguna variable de entorno externa (dev/prod)");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadDevProperties(){
        try {
            CURRENT_PROPERTIES.load(Files.newBufferedReader(DEV_PROPERTIES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadProdProperties(){
        try {
            CURRENT_PROPERTIES.load(Files.newBufferedReader(PROD_PROPERTIES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
