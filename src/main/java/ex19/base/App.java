package ex19.base;
import java.util.Scanner;
/*
 *  UCF COP3330 Summer 2021 Assignment 19 Solution
 *  Copyright 2021 William Weatherlow
 */
public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        App myApp = new App();
        System.out.print("What is your weight in pounds? ");
        double weight = myApp.readInput();
        System.out.print("What is your height in inches? ");
        double height = myApp.readInput();

        String output = myApp.bmiCheck(myApp.doMath(weight,height));

        myApp.displayOutput(output);
    }
    private double readInput(){
        double num;
        while (true) {
            try {
                num = Double.parseDouble(in.next());
                break;

            } catch (NumberFormatException e) {
            }
            System.out.println("Error, please enter a number!");
        }
        return num;
    }
    private String bmiCheck(double bmi){
        if(bmi > 18.5 && bmi < 25){
            return "Your BMI is " + String.format("%.1f",bmi)+"\nYou are within the ideal weight range.";
        }
        if(bmi <= 18.5){
            return "Your BMI is " + String.format("%.1f",bmi)+"\nYou are underweight. You should see your doctor.";
        }
        if(bmi >=25){
            return "Your BMI is " + String.format("%.1f",bmi)+"\nYou are overweight. You should see your doctor.";
        }
        return "Error on BMI calculation";
    }
    private double doMath(double weight, double height){
        //bmi = (weight / (height × height)) * 703
        double bmi=(weight/(height * height))* 703;
        return bmi;
    }
    private void displayOutput(String output){
        System.out.println(output);
    }
}
