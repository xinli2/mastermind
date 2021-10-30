package controller;
import model.MastermindModel;

/**
 * 
 * @author Xin Li
 *
 */
public class MastermindController {
	
	// Only these methods may be public - you may not create any additional 
	// public methods (and NO public fields)
	private final MastermindModel m;
	
	public MastermindController(MastermindModel model) {
		m = model;
	}
 

    public boolean isCorrect(String guess) {
    	for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) != m.getColorAt(i)) {
            	return false; //Just something for now to make sure the code compiles
            }
    	}
        return true;
    }


    public int getRightColorRightPlace(String guess) { 
    	int num = 0;
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == m.getColorAt(i)) {
                num += 1;
            }
        }
    	return num; //Just something for now to make sure the code compiles
    }


    public int getRightColorWrongPlace(String guess) {
    	//record position j counted
        boolean[] counted = new boolean[]{false, false, false, false};
        int num = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //not right color right place
                if (i == j) continue;
                if (guess.charAt(j) == m.getColorAt(j)) {
                    continue;
                }
                if (guess.charAt(i) == m.getColorAt(j) && !counted[j]) {
                    num += 1;
                    counted[j] = true;
                    break;
                }
            }
        }
    	return num; //Just something for now to make sure the code compiles
    }

    // Create as many private methods as you like

}
