
/**
 * Write a description of CaesarCipher here.
 * 
 * @WendySun
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher {

    //This method returns a string that has been encrypted using the Caesar
    // Cipher Algorithm explained in the videos
    public String encrypt(String input, int key) {
        StringBuilder encrypted=new StringBuilder(input);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        for(int i=0;i<encrypted.length();i++) {
            char ch=encrypted.charAt(i);
            int idx=alphabet.indexOf(ch);
            if(idx!=-1) {
                char newChar=shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
        }
        return encrypted.toString();
    }
    
    // Modify the encrypt method to be able to handle both uppercase and lowercase letters
    public String encrypt2(String input, int key) {
        StringBuilder encrypted=new StringBuilder(input);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        for(int i=0;i<encrypted.length();i++) {
            char ch=encrypted.charAt(i);
            // Transfer to upperCase to compare
            int idx=alphabet.indexOf(Character.toUpperCase(ch));
            if(idx!=-1) {
                char newChar=shiftedAlphabet.charAt(idx);
                // if current char is lowerCase, set newChar to lowerCase
                if(Character.isLowerCase(ch)==true)
                    newChar=Character.toLowerCase(newChar);
                encrypted.setCharAt(i,newChar);   
            }
        }
        return encrypted.toString();
    }
    
    //​This method returns a String that has been encrypted using the following algorithm. 
    //Parameter key1​is used to encrypt every other character with the Caesar Cipher algorithm, 
    //starting with the first character, and key2​is used to encrypt every other character, 
    //starting with the second character. 
    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted=new StringBuilder(input);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
        
        for(int i=0;i<encrypted.length();i++) {
            char ch=encrypted.charAt(i);
            int idx=alphabet.indexOf(Character.toUpperCase(ch));
            if(idx!=-1) {
                char newChar;
                if(i%2==0) newChar=shiftedAlphabet1.charAt(idx);
                else newChar=shiftedAlphabet2.charAt(idx);
                if(Character.isLowerCase(ch)==true)
                    newChar=Character.toLowerCase(newChar);
                encrypted.setCharAt(i,newChar); 
            }
        }
        return encrypted.toString();
    }
    
    // test function
    public void testCaesar() {
        FileResource fr=new FileResource();
        String message=fr.asString();
        int key=23;
        int key2=17;
        String encrypted1=encrypt(message,key);
        System.out.println("1.Key is "+key+"\n" +encrypted1);
        
        String encrypted2=encrypt2(message,key);
        System.out.println("2.Key is "+key+"\n" +encrypted2);
        
        String encrypted3=encryptTwoKeys(message,key,key2);
        System.out.println("3.Key1 is "+key+", Key2 is "+key2+"\n" +encrypted3);
    }
}
