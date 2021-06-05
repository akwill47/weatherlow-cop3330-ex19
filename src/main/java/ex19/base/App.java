package ex19.base;
import java.util.Scanner;
/*
Exercise 19 - BMI Calculator
You’ll often need to see if one value is within a certain range and alter the flow of a program as a result.

Create a program to calculate the body mass index (BMI) for a person using the person’s height in inches and weight in pounds.
The program should prompt the user for weight and height.

Calculate the BMI by using the following formula:

bmi = (weight / (height × height)) * 703
If the BMI is between 18.5 and 25, display that the person is at a normal weight. If they are out of that range, tell them if they are underweight or overweight and tell them to consult their doctor.

Example Output
Your BMI is 19.5.
You are within the ideal weight range.
or

Your BMI is 32.5.
You are overweight. You should see your doctor.
Constraint
Ensure your program takes only numeric data. Don’t let the user continue unless the data is valid.
Challenges
Make the user interface accept height and weight in Imperial or metric units. You’ll need a slightly different formula for metric units.
For Imperial measurements, prompt for feet and inches and convert feet to inches so the user doesn’t have to.
Use a GUI interface with sliders for height and weight. Update the user interface on the fly. Use colors as well as text to indicate health.
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
