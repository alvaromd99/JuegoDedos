/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw.juegodedos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alvaro
 */
public class JuegoDedos {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int getNumberFromUser(int min, int max, String text) {
        Scanner sc = new Scanner(System.in);
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
}
