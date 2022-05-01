package SinkDotComGame;

import java.util.*;
import java.io.*;
public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int comCount = 0;


    public String getUserInput(String userInput){
        String inputLine = null;

        try{

            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0) return null;

        }catch(IOException e){

            System.out.println("IO Exception " + e );

        }

        return inputLine.toLowerCase();

    }

    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<String>(); //Holds the cordinates

        String temp = null; //Temporary string for concat
        int[] coord = new int[comSize]; //Current dotCom Coordinates
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;  //Nth dotCom to place

        int incr = 1;  //Set horizontal increment

        if((comCount % 2 == 1)){
            incr = gridLength;   //Set vertical increment for odd dotCom
        }

        
        while ( !success & attempts++ < 200){  //Main Search loop
            location = (int) (Math.random() * gridSize); //get random starting point
            //System.out.println(" try " + location);
            
            int x = 0; //nth position in dotcom to place
            success = true; //Assume success

            while (success && (x < comSize)){ //look for adjacent unused spot
                if (grid[location] == 0){
                    coord[x++] = location; //Save location
                    location += incr ;//move to next location

                    if(location > gridSize){  //Out of bounds "Bottom"
                        success = false;    
                    }

                    if(x > 0 && (location % gridLength == 0)){
                        success = false; // out of bounds "right"
                    }
                }else{  // found Already used location
                    //System.out.println("Used " + location); 
                    success = false;
                } //end ifelse
            }// end while
            

        }// end main loop

        //turn location into  alpha coord
        int x = 0; 
        int row = 0;
        int column = 0;

        //System.out.println("\n");

        while(x < comSize){
            grid[coord[x]] = 1;
            row = (int) (coord[x] / gridLength);
            column = coord[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            //System.out.print(" Coor " + x + " = " + alphaCells.get(x-1));
        }

        //ystem.out.println("\n");

        return alphaCells;

    }
}
