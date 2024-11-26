/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw.juegodedos;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alvaro
 */
public class JuegoDedos {

    public static void main(String[] args) {
        String text1 = "Introduce cuantos dedos vas a sacar: ";
        String text2 = "Introduce el total de dedos: ";

        int fingUser = 0, totalUser = 0;
        int fingMach = 0, totalMach = 0;
        int res = 0;
        int winUser = 0, winMach = 0;

        fingUser = getNumberFromUser(0, text1);
        totalUser = getNumberFromUser(fingUser, text2);

        fingMach = getNumberFromMachine();
        totalMach = getNumberFromMachine(fingMach);

        res = getResult(fingUser, totalUser, fingMach, totalMach);
        
        switch (res) {
            case 0 -> {
                showSelected(fingUser, totalUser, fingMach, totalMach);
                System.out.println("El resultado es EMPATE.");
            }
            case 1 -> {
                showSelected(fingUser, totalUser, fingMach, totalMach);
                System.out.println("El ganador es el USUARIO.");

                winUser++;
                winMach = 0;
            }
            case 2 -> {
                showSelected(fingUser, totalUser, fingMach, totalMach);
                System.out.println("El ganador es la MAQUINA.");

                winMach++;
                winUser = 0;
            }
            case 3 -> {
                showSelected(fingUser, totalUser, fingMach, totalMach);
                System.out.println("Ninguno ha acertado.");
            }
            default ->
                System.out.println("Error en el resultado.");
        }
    }

    public static void showSelected(int nUser, int tUser, int nMach,
            int tMach) {
        String text = """
                      Dedos Usuario: %d
                      Total Usuario: %d
                      Dedos Maquina: %d
                      Total Maquina: %d
                      """.formatted(nUser, tUser, nMach, tMach);
        System.out.println(text);
    }

    public static int getNumberFromUser(int min, String text) {
        Scanner sc = new Scanner(System.in);
        int max = min + 6;
        int num = 0;

        do {
            System.out.println(text);
            try {
                num = sc.nextInt();
                if (num < min || num > max) {
                    System.out.println("Error, el numero no tiene sentido.");
                } else {
                    return num;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Error, no has introducido un numero.");
                sc.nextLine();
            }
        } while (true);
    }

    public static int getNumberFromMachine() {
        Random rd = new Random();

        return rd.nextInt(0, 6);
    }

    public static int getNumberFromMachine(int min) {
        Random rd = new Random();

        return rd.nextInt((min + 1), (min + 6));
    }

    public static int getResult(int numUser, int totalUser, int numMach,
            int totalMach) {
        // Si es 0 lo convertimos en 1, porque 0 dedos vale 1
        numUser = numUser == 0 ? 1 : numUser;
        numMach = numMach == 0 ? 1 : numMach;

        System.out.println(numUser);
        System.out.println(numMach);

        int totalNum = numUser + numMach;
        System.out.println(totalNum);
        if (totalNum == totalUser && totalNum == totalMach) {
            return 0;
        } else if (totalNum == totalUser) {
            return 1;
        } else if (totalNum == totalMach) {
            return 2;
        } else {
            return 3;
        }
    }
}
