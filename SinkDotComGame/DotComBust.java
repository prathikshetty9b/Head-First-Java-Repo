package SinkDotComGame;

import java.util.ArrayList;

public class DotComBust {
    GameHelper helper = new GameHelper();
    ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    int numOfGuesses = 0;

    private void setUpGame(){
        //Make three dot.com objects and name them
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("Toys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");

        //Add the objects to the list
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        //Instructions for the user
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, Toys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");
        
        //Place dotCom objects int the list
        for (DotCom obj : dotComList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            obj.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        while(!dotComList.isEmpty()){
            String userGuess = helper.getUserInput("Enter a Guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "Miss";

        for (DotCom obj : dotComList){
            result = obj.checkYourself(userGuess);
            if (result.equals("Hit")){
                break;
            }
            if (result.equals("Kill")){
                dotComList.remove(obj);
                break;
            }
        }
        System.out.println(result);

    }

    private void finishGame() {
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if (numOfGuesses <= 18) {
        System.out.println("It only took you “ + numOfGuesses + “ guesses.");
        System.out.println(" You got out before your options sank.");
        } else { 
        System.out.println("Took you long enough. "+ numOfGuesses + "a1 guesses.");
        System.out.println("Fish are dancing with your options.");
        }
    } // close method

    public static void main(String [] args){
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();

    }
}


