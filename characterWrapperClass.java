//N.K Nkidi 45979278
/**
 * Write a description of class characterWrapperClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class characterWrapperClass
{
    private char character;
    private boolean guessed;

    //Constructor
    public characterWrapperClass(char character) {
        this.character = character;
        this.guessed = false;
    }

    //Setter
    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

    
    public boolean isGuessed() {
        return guessed;
    }

    //Getter
    public char getCharacter() {
        return character;
    }

    //Overwriting the toString Method
    @Override
    public String toString() {
        return guessed ? Character.toString(character) : "_";
    }
    
    
}
