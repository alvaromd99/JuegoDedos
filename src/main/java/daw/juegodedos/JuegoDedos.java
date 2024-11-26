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
        
        fingUser = getNumberFromUser(0, text1);
        totalUser = getNumberFromUser(fingUser, text2);
        
        fingMach = getNumberFromMachine();
        totalMach = getNumberFromMachine(fingMach);
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
}
