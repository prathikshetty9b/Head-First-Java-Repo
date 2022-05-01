package SinkDotComGame;
import java.util.*;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    //Setter Methods
    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }

    public void setName(String n){
        name = n;
    }


    public String checkYourself(String userInput){
        String result = "Miss";

        //Check if the userInput is in the list by asking for
        //it's index. If it's not there it'll return -1
        int index = locationCells.indexOf(userInput);

        if (index >= 0){
            //User guessed the location correctly
            //Remove the element from the list
            locationCells.remove(index);
        
        
            if(locationCells.isEmpty()){
            //If list was empty this was the killing blow
                result = "Kill";
                System.out.println("Ouch! You sunk " + name + " :(");
            }else{
                result = "Hit";
            }
        }
        return result;
    }
}
