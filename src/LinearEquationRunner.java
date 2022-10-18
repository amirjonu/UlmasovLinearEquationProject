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

    }
}
