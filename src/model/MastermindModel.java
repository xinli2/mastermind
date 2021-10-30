package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Xin Li
 *
 */
public class MastermindModel {
	//private variable(s) to store the answer
	private char[] s;
	// Only these methods may be public - you may not create any additional 
	// public methods (and NO public fields)
    public MastermindModel() { 
    	// TODO Make the answer
    	char[] colors = new char[]{'r', 'o', 'y', 'g', 'b', 'p'};
        s = getRandomArray(colors, 4);
    }
    
    /**
     * This method is a special constructor to allow us to use JUnit to test our model.
     * 
     * Instead of creating a random solution, it allows us to set the solution from a 
     * String parameter.
     * 
     * 
     * @param answer A string that represents the four color solution
     */
    public MastermindModel(String answer) {
    	// TODO Take answer and somehow store it as your answer. Make sure the getColorAt method 
    	// still works
    	s = new char[4];
        for (int i = 0; i < 4; i++) {
            s[i] = answer.charAt(i);
        }
    }


    public char getColorAt(int index) {
          /* Return color at position index as a char
           (first converted if stored as a number) */
    	
    	return s[index]; //Just returning something to make sure the code compiles
    }
    
    // Create as many private methods as you like
    private static char[] getRandomArray(char[] paramArray, int count) {
        if (paramArray.length < count) {
            return paramArray;
        }
        char[] newArray = new char[count];
        Random random = new Random();
        int temp = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            temp = random.nextInt(paramArray.length);
            if (!(list.contains(temp))) {
                newArray[i] = paramArray[temp];
                list.add(temp);
            } else {
                i--;
            }
        }
        return newArray;
    }

}
