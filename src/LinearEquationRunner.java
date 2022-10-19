import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        System.out.println("Welcome");
        //Enters coordinates
        System.out.print("Enter coordinate 1: ");
        String cor1= s.nextLine();
        System.out.print("Enter coordinate 2: ");
        String cor2= s.nextLine();
        System.out.println();

        //"parse out" coordinate 1 x coordinate
        int cor1x= Integer.parseInt(cor1.substring(1, cor1.indexOf(",")));
        //"parse out" coordinate 1 y coordinate
        int cor1y= Integer.parseInt(cor1.substring(cor1.indexOf(",")+2, cor1.length()-1));
        //"parse out" coordinate 2 x coordinate
        int cor2x= Integer.parseInt(cor2.substring(1, cor2.indexOf(",")));
        //"parse out" coordinate 2 y coordinate
        int cor2y= Integer.parseInt(cor2.substring(cor2.indexOf(",")+2, cor2.length()-1));


        //checks if line is horizontal and if not continues with code. if it is it prints out equation and finishes
        if (cor1x==cor2x){
            System.out.println("These points are on a vertical line: x = "+ cor1x);
        }else {
            //Create object and print info
            LinearEquation equation = new LinearEquation(cor1x, cor1y, cor2x, cor2y);
            System.out.println(equation.lineInfo());
            //accept value of x and prints point
            System.out.print("Enter a value for x: ");
            double newX = s.nextDouble();
            System.out.println("The point on the line is " + equation.coordinateForX(newX));

        }

    }
}
