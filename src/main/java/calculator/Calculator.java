package calculator ;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    // default constructor
    public Calculator() {
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        int x;
        double numm;
        do {
            System.out.println("You are using Scientific Calculator. Choose the corresponding number for a function you want to use and enjoy!!");
            System.out.print("Enter 1 for getFactorial.\n");
            System.out.print("Enter 2 for square root.\n");
            System.out.print("Enter 3 for XpowerY function.\n");
            System.out.print("Enter 4 for logarithmic function.\n");
            System.out.print("Enter 5 to exit.\n");
            int function;

            // handling the input mismatch error
            try {
                function = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            if(function == 1){
                System.out.print("Write number for which you want to find a getFactorial : ");
                x = scanner.nextInt();
                System.out.println("Factorial: " + calculator.getFactorial(x) + "\n");
            }
            else if(function == 2){
                System.out.print("Write a number to find sqaure root for : ");
                x = scanner.nextInt();
                System.out.println("Square root:" +  calculator.getSquareRoot(x) + "\n");
            }
            else if(function == 3){
                System.out.print("Base: ");
                numm = scanner.nextDouble();
                System.out.print("Power: ");
                double numm2 = scanner.nextDouble();
                System.out.println(numm+ "^"+numm2+ ": " + calculator.XpowerY(numm, numm2) + "\n");
            }
            else if(function == 4){
                System.out.print("Write a number to find natural log for : ");
                numm = scanner.nextDouble();
                System.out.println("Natural log:  "+numm+" is : " + calculator.getNaturalLog(numm));
                System.out.println("\n");

            }
            else{
                System.out.print("Will see you later. \n~Scientific Calculatror");
                break;
            }
        } while (true);
    }


    public double getFactorial(int x) {
        if (x == 1 || x == 0)
            return 1;
        return getFactorial(x - 1) * x;
    }

    public double getSquareRoot(int n ) {
        return Math.sqrt(n);
    }



    public double getNaturalLog(double numm) {

        double answer = 0;
        try {
            if (numm <= 0 ) {
                answer = Double.NaN;
                // throw new ArithmeticException("Cannot find natural log of negative numbers (<=0)");
            }
            else {
                answer = Math.log(numm);
            }
        } catch (ArithmeticException error) {
            System.out.println("Cannot find natural log of negative numbers (<=0)" + error.getLocalizedMessage());
        }
        return answer;
    }

    public double XpowerY(double numm, double number2) {
        double answer = Math.pow(numm,number2);
        return answer;
    }

}
