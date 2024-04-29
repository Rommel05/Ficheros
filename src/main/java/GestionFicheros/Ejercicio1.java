package GestionFicheros;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        int option;
        File f = File.listRoots()[0];
        do {
            System.out.println("Lista de fucheros y directorios del directorio: /");
            System.out.println("-------------------------------------------------");
            System.out.println("0 - Directorio Padre");
            printDirectoriesAndFiles(f);
            System.out.println();
            System.out.println("Intorduce una opción (-1 para salir)");;
            option = getOption();
            if (option > 0 && option < Arrays.stream(f.listFiles()).count()) {
               if (f.listFiles()[option - 1].isDirectory() && f.listFiles()[option - 1].canRead()) {
                   f = f.listFiles()[option - 1];
               }
            } else if (option == 0 && f.getParentFile() != null) {
                f = f.getParentFile();
            }
        } while (option != -1);

    }
    public static void printDirectoriesAndFiles(File f) {
        int counter = 0;
        try {
            for (File d:f.listFiles()) {
                counter++;
                if (d.isDirectory()) {
                    System.out.println(counter + " - " + d + " - " + "<DIRECTORY>");
                } else if (d.isFile()) {
                    System.out.println(counter + " - " + d + " - " + d.length() + " bytes");
                }
            }
        }catch (NullPointerException iae) {
            System.out.println("This directory is NULL");
        }
    }
    public static int getOption() {
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}
