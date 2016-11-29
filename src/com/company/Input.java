package com.company;

/**
 * Created by nawazkhan on 11/16/16.
 */
public class Input {
    private String name;
    private String input;
    private int amount;

    public void chooseName() throws Exception {
        boolean goBack = true;
        while (goBack == true) {
            System.out.println("Please Enter your Name");
            name = Main.scanner.nextLine();
            System.out.println("Welcome, " + name);
            if (name.isEmpty()) {
                throw new Exception("Please enter valid name");
            }

            if (Main.name.containsKey(name)) {
                goBack = false;
            }

            if (!Main.name.containsKey(name)) {
                System.out.println("Would you like to open an account today? [y/n]");
                String answer = Main.scanner.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    Main.name.put(name, 100.0);
                    System.out.println("$" + Main.name.get(name) + " - Account Created!");
                    goBack = false;
                } else if (answer.equalsIgnoreCase("n")) {
                    System.out.println("Have a nice day!");
                    goBack = true;


                }

            }
        }
    }

    public boolean choosePrompt() throws Exception {
        System.out.println("Please Select an option from below:");

        System.out.println("1.Check my balance. 2.Withdraw Funds. 3.Cancel 4.Close Account");

        input = Main.scanner.nextLine();

        if (input.equalsIgnoreCase("Check Balance") || input.equalsIgnoreCase("1")) {
            System.out.println("Your Balance: " + Main.name.get(name));
        } else if (input.equalsIgnoreCase("Withdraw Funds") || input.equalsIgnoreCase("2")) {
            System.out.println("Please enter the amount you would like to withdraw.");
            amount = Main.scanner.nextInt(); // **** Main.scanner.*nextInt()* scanner turns a String to in -int ***

            if (amount > Main.name.get(name)) {
                throw new Exception("Insufficient Funds");
            } else if (amount <= (Main.name.get(name))) {
                System.out.println("Your new balance is " + " $" + (Main.name.get(name) - amount));
                Double balance = (Main.name.get(name) - amount);
                Main.name.put(name, balance);
            }
            System.out.println("$" + amount + " Dispensed Below. Have a Great Day.");
        }

        if (input.equalsIgnoreCase("close account") || input.equalsIgnoreCase("4")) {
            System.out.println("close account [y/n]");
            String response = Main.scanner.nextLine();
            if (response.equalsIgnoreCase("y")) {
                System.out.println("Your account is closed");
                Main.name.remove(name);
                return (false);

            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("What is your name");
            }

        }


        if (input.equalsIgnoreCase("cancel")) {
            System.out.println("Have a nice day");
            return (false);

        }
        return (true);

    }


}