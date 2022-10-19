public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated)*/

    public LinearEquation(int x1, int y1, int x2, int y2){
            //initializes variables
            this.x1=x1;
            this.x2=x2;
            this.y1=y1;
            this.y2=y2;
    }


/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    public double distance(){
        //uses distance formula to output the distance
        return roundedToHundredth(Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1, 2)));
    }



    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept(){
        //calculates y int
        double slope= slope();
        return roundedToHundredth(y1-slope*x1);
    }



    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope(){
        //calculates slope
        double slope= (double)(y2-y1)/(double)(x2-x1);
        return roundedToHundredth(slope);
    }



    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation(){
        int changeX= x2-x1;
        int changeY= y2-y1;
        //x is a counter variable
        int x=1;
        String slope="";
        String yInt="";
        String beforeYIntSign;
        //checks if line is horizontal
        if(y2==y1){
            x=0;
            return "y= "+y1;
        }
        //checks if delta x is negative and switches it to the absolute value and multiplies delta y by -1
        if (changeX<0) {
            changeX= Math.abs(changeX);
            changeY= changeY*-1;
        }
        //checks if delta y and delta x is divisible. also checks if they equal to 1 or -1, so they can initialize slope
        if(changeY%changeX == 0){
            x=0;
            slope= changeY/changeX +"";
            if (changeY/changeX == 1){
                slope="";
            }
            if (changeY/changeX==-1){
                slope= "-";
            }
        }
        if (x==1){
            slope= changeY+"/"+ changeX;
        }

        if (yIntercept()<0){
            beforeYIntSign= " - ";
            yInt= Math.abs(yIntercept())+ "";
        } else if (yIntercept()==0.0) {
            yInt="";
            beforeYIntSign="";
        } else{
            beforeYIntSign =" + ";
            yInt=yIntercept()+ "";
        }
        return "y= "+ slope +"x" + beforeYIntSign+ yInt;
    }





    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue){
        //finds coordinate with x value inputted
        double xCor= (double)xValue;
        double yCor= roundedToHundredth(slope()*xCor+yIntercept());
        return "("+xCor+", "+ yCor+")";
    }





    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    public double roundedToHundredth(double toRound){
            //rounds to hundredth
        return Math.round(toRound*100.0)/100.0;
    }



    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo(){
        //prints out all info
        return "The two points are: ("+ x1+", "+ y1+") and ("+ x2+ ", "+ y2+")\n"+
                "The equation of the line between the points is: "+ equation()+"\n"+
                "The slope of this line is: "+ slope()+"\n"+
                "The y-intercept of the line is: "+ yIntercept()+"\n"+
                "The distance between the two points is: "+ distance()+"\n\n";

    }

}
