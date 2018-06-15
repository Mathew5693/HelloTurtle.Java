package cop2513.helloturtles;

import edu.gatech.mediacomp.Turtle;
import edu.gatech.mediacomp.World;
import edu.ventura.support.AnimatedTurtle;
import edu.ventura.support.EndWorld;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.awt.Color;

public class HelloTurtles {

    /**
     * Use the given turtle to draw your name.
     * @param t the turtle to use for drawing.
     */
    public static void drawName(Turtle t) {
        // TODO: your implementation here


        //draws M
        t.penUp();
        t.moveTo(50,240);
        t.penDown();
        t.forward(100);
        t.turn(135);
        t.forward(50);
        t.turn(-90);
        t.forward(50);
        t.turn(135);
        t.forward(100);
        t.penUp();


        //draws A
        t.moveTo(200,240);
        t.penDown();
        t.turn(200);
        t.forward(100);
        t.turn(135);
        t.forward(50);
        t.turn(115);
        t.forward(35);
        t.turn(180);
        t.forward(35);
        t.turn(65);
        t.forward(54);
        t.penUp();

        //draws T
        t.moveTo(350,240);
        t.penDown();
        t.turn(205);
        t.forward(100);
        t.turn(-90);
        t.forward(50);
        t.turn(180);
        t.forward(100);
        t.turn(180);
        t.forward(50);
        t.turn(-90);
        t.forward(100);
        t.penUp();

        //draws second T

        t.moveTo(500,240);
        t.penDown();
        t.turn(180);
        t.forward(100);
        t.turn(-90);
        t.forward(50);
        t.turn(180);
        t.forward(100);
        t.turn(180);
        t.forward(50);
        t.turn(-90);
        t.forward(100);




    } // end drawName


    /**
     * Draws the specified number of lines, rotating 360.0 / n between
     * each line.  The color of each line is determined by the angle
     * the turtle is facing when drawing that line.
     * A line drawn at angle ang has the HSB/HSV color of (ang / 360, 1, 1).
     * You may want to refer to
     * https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html#getHSBColor-float-float-float-
     *
     * @param t the turtle to use to draw.
     * @param numLines the number of line segments.
     * @param lineLength the length of each line segment.
     */



    public static void radial(Turtle t, int numLines, int lineLength) {
        // TODO: your implementation here



       for(int n = 1; n <= numLines; n++){


        }
        for(float ang = 1; ang <= 360; ang++) {
            t.forward(lineLength);
            t.backward(lineLength);
            t.setPenColor(Color.getHSBColor((ang / 360), 1, 1));
            t.turn(360 / numLines);

        }


    } // end radial



    /**
     * Draws the specified number of regular polygons,
     * each starting at the same place, however,
     * after each polygon is drawn the turtle turns 360 / numPolys degrees
     *
     * @param t the turtle to use to draw.
     * @param numPolys the number of polygons to draw.
     * @param numSides the number of sides of each polygon.
     * @param sideLen the length of each side of each polygon.
     */
    public static void manyPolygons(Turtle t, int numPolys, int numSides, int sideLen) {
        // TODO: your implementation here

        //test with randoms



        int count = 0;
        double turneR = 180.0/(numPolys/2);

        for(int i = 0; i != numPolys; i++ ){

            if(count != numPolys);
            t.turn(0);
            drawPolygon(t, numSides, sideLen);
            count++;
            t.turn(turneR);


        }



    } // end manyPolygons


    /**
     * Draws a regular polygon of the specified number of sides and length of side.
     *
     * @param t the turtle to use to draw.
     * @param numSides the number of sides of each polygon.
     * @param sideLen the length of each side of each polygon.
     */
    public static void drawPolygon(Turtle t, int numSides, int sideLen) {
        // TODO: your implementation here

            for(int i = 0; i != numSides; i++ ){

                double numOfSides = 180.0/(numSides/2.0);
                t.forward(sideLen);
                t.turn(numOfSides);

            }

    } // end drawPolygon

    /**
     * Entry point of the program.
     */
    public static void main(String[] args) {

        // TODO: your implementation here

        EndWorld w = new EndWorld();
        AnimatedTurtle t = new AnimatedTurtle(w);
        String choice = menu();

        if (choice.equals("Name")){
            drawName(t);
        }
        if (choice.equals("Many Polygons")){
            manyPolygons(t, 15,10,25);
        }
        if(choice.equals("Polygon")){
            drawPolygon(t, 9, 50);
        }
        if(choice.equals("Radial")){
            radial(t,360,50);

        }


    } // end main

    /**
     * Returns a random number between low (inclusive) and high (exclusive).
     * @param low the lower (inclusive) part of the range.
     * @param high the upper (exclusive) part of the range.
     * @return a random number between low (inclusive) and high (exclusive).
     */
    public static int rand(int low, int high) {

        Random rand = new Random();
        low = rand.nextInt((high - low) + 1) + high;

        return ThreadLocalRandom.current().nextInt(low, high);

    }

    /**
     * Displays the menu and returns the value the user selected.
     * Quits the program if the user selects Cancel.
     *
     * NOTE: Remember to compare strings using the .equals method.
     *
     * @return one of "Name", "Polygon", "Many Polygons", "Radial"
     */
    public static String menu() {
        JPanel panel = new JPanel();
        panel.add(new JRadioButton("radio"));
        String values[] = {"Name", "Polygon", "Many Polygons", "Radial"};
        Object choice = JOptionPane.showInputDialog(null,
                "Choose the demo to show", "Choose Demo",
                JOptionPane.DEFAULT_OPTION, null, values, "0");
        if (choice == null) {
            System.exit(0);
        }
        return choice.toString();
    } // end menu

} // end class HelloTurtles
