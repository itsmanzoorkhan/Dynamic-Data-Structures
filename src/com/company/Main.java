package com.company;

import com.company.Input;import java.util.HashMap;
import java.util.Scanner; // This needs to be added(Step 1 of 2) to use "Scanner" function in code.


public class Main {
    public static Scanner scanner = new Scanner(System.in); // This is Step 2 of connecting "scanner" to ALL of the classes.
    public static Input input = new Input();  // ****  connects Input class to com.company.Main(Game) class. **//
    public static HashMap<String, Double> name = new HashMap ();




    public static void main(String[] args) throws Exception { //Need to add in main to use Exceptions


        boolean Option = true;

        System.out.println("Welcome to MB Corp. ATM");

        while (true) {
            input.chooseName();




            while (Option == true) {
                Option = input.choosePrompt();
            }

        }




    }
}
