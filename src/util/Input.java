package util;

import java.util.Scanner;

public class Input {

    private Scanner scan;

    public Input() {
        this.scan = new Scanner(System.in);
    }


    public int getBinary(String binary){
        System.out.println(binary);
        String toBinary = scan.nextLine();
        System.out.println(Integer.parseInt(toBinary,2));
        return Integer.parseInt(toBinary);
    }

    public String getString(String prompt){
        System.out.println(prompt);
        String stringInput = scan.nextLine();
        System.out.println(stringInput);
        return stringInput;
    }

    public boolean yesNo(String prompt){
        System.out.println(prompt);
        String yesOrNo = scan.nextLine();
        return yesOrNo.equalsIgnoreCase("y") || yesOrNo.equalsIgnoreCase("yes");
    }

    public int getInt(String prompt){
        System.out.println(prompt);
        String userInput = scan.nextLine();
        try{
            return Integer.valueOf(userInput);
        } catch(NumberFormatException e){
            System.out.println("Hey that's not a number!");
            return getInt(prompt);
        }

    }

    public int getIntWithinRange(String prompt, int min, int max){
        int newNumber = getInt(prompt);
        try{
            if (newNumber < min || newNumber > max) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("Error - Number must be within range");
            return getIntWithinRange(prompt, min, max);
        }
//        scan.nextLine();
        return newNumber;
    }


    public double getDouble(String prompt){
        System.out.println(prompt);
        String newishDouble = scan.nextLine();
        try{
            return Double.valueOf(newishDouble);
        } catch (NumberFormatException e){
            System.out.println("That isn't a number..");
            return getDouble(prompt);
        }

    }

    public double getDoubleWithinRange(String prompt, double min, double max) {
        double newDouble = getDouble(prompt);
        try {
            if (newDouble >= 10 || newDouble <= 1) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
                getDoubleWithinRange(prompt, min, max);
            }

        return newDouble;
    }

    public String getPhoneNumber(String prompt){
        System.out.println(prompt);
        String stringInput = scan.nextLine();
        if(stringInput.trim().length() != 10){
            System.out.println("Enter a valid number.");
            return getPhoneNumber(prompt);
        }
        System.out.println(stringInput);
        return stringInput;
    }




}
