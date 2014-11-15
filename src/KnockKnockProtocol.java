
public class KnockKnockProtocol {
        private static final int WAITING = 0;
        private static final int SENTKNOCKKNOCK = 1;
        private static final int SENTCLUE = 2;
        private static final int ANOTHER =3;
	
        private static final int NUMJOKES = 5;

        private int state = WAITING;
        private int currentJoke = 0;

        private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
        private String[] answers = { "Turnip the heat, it�s cold in here!", "I didn�t know you could yodel!", "Bless you!", "Is there an owl In here?", "Is there an echo in here?" };
        
        public String processInput(String theInput) {
            String theOuput = null;

            if (state == WAITING) {
            	theOuput = "Knock! Knock!";
            	state = SENTKNOCKKNOCK;
            } else if (state == SENTKNOCKKNOCK) {
            	if (theInput.equalsIgnoreCase("who's there?")) {
            		theOuput = clues[currentJoke];
            		state = SENTCLUE;
            	} else {            		
            		theOuput = "Youre supposed to say \"Who�s there?\"! " + 
            				"Try again. Knock! Knock!";           
            	}            
	        } else if (state == SENTCLUE) {
	            if (theInput.equalsIgnoreCase(clues[currentJoke] + " who?")) {
	            	theOuput = answers[currentJoke] + "\nWant another? (y/n)";
	                state = ANOTHER;
	             } else {
	            	 theOuput = "You�re supposed to say \"" +
	      			clues[currentJoke] + " who?\"" + 
	      			"! Try again. Knock! Knock!";
	      	state = SENTKNOCKKNOCK;
	              }
	      } else if (state == ANOTHER) {
	            if (theInput.equalsIgnoreCase("y")) {
	            	theOuput = "Knock! Knock!";
	                if (currentJoke == (NUMJOKES -1))
	      	currentJoke = 0;
	                else
	      	currentJoke++;
	                 state = SENTKNOCKKNOCK;
	              } else {
	            	  theOuput = "Bye.";
	      	state = WAITING;
	               }
	      }
	      return theOuput; 
	      }
}