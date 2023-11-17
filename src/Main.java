import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int pick;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Pick a Problem: ");
            pick = sc.nextInt();
            switch (pick) {

                case 1:
                    int x, y, z;
                    System.out.println("1. Divide by Zero Problem");

                    try {
                        System.out.print("Enter x: ");
                        x = sc.nextInt();

                        System.out.print("Enter y: ");
                        y = sc.nextInt();

                        z = x / y;

                        System.out.println("x divided by y = " + z);
                    } catch (ArithmeticException e) {
                        System.out.println("Can't do that dawg");
                        System.out.println("x / 0 is undefined");

                    }
                    break;

                case 2:
                    System.out.println("2. Array Index Out of Bounds");
                    String[] colors = {"red", "green","blue"};
                    System.out.println("Array size: " + colors.length);

                    System.out.print("Available Colors: ");
                        for(int i = 0; i < colors.length; i++) {
                            System.out.print(colors[i]);
                            if (i < colors.length - 1) {
                                System.out.print(", ");
                            }
                        }
                    System.out.println();
                    try {
                        System.out.print("Pick a color: ");
                        String choose = sc.next();

                        switch (choose) {
                            case "1":
                            case "red":
                                System.out.println(colors[0]);
                                break;
                            case "2":
                            case "green":
                                System.out.println(colors[1]);
                                break;
                            case "3":
                            case "blue":
                                System.out.println(colors[2]);
                                break;
                            default:
                                throw new NotInChoicesException("None of the above");
                        }

                    } catch (NotInChoicesException e) {
                        System.out.println("Exception Caught here");
                        // You can either just print it out, but it won't alter the program flow
                        // Printing an exception is more about providing information to the developer
                        // or user without altering the program's flow.

                        System.out.println("None of the above");
                        // or You can throw a new exception so that it will alter the program flow
                        // "Throwing an exception is a mechanism to signal an error condition and
                        // affect the program's control flow, potentially causing it to halt execution
                        // or be handled elsewhere in the code."

//                        throw new NotInChoicesException(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("3. Custom Exception");

                    int positiveOnly;
                    System.out.print("Enter a positive number: ");
                    positiveOnly = sc.nextInt();
                    if(positiveOnly == 0) {
                        throw new NumberFormatException("That's a zero");
                    }

                    else if(positiveOnly > 0) {
                        System.out.println("You got it!");
                        break;
                    }
                    throw new NegativeNumberException("That's a Negative Integer");


                default:
                    System.out.println("Try Again");
            }

        } while (pick != 0);



    }
}

class NegativeNumberException extends Exception {
    public NegativeNumberException (String message){
        super(message);
    }
}

class NotInChoicesException extends Exception {
    public NotInChoicesException (String message) {super(message);}
}