
/**
 * Write a description of WordPlay here.
 * 
 * @WendySun
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch) {
        char lowerChar=Character.toLowerCase(ch);
        if(lowerChar=='a' || lowerChar=='e' || lowerChar=='i' || lowerChar=='o' || lowerChar=='u')
            return true;
        else return false;
    }
    
    public String replaceVowels(String phrase, char ch) {
        StringBuilder newPhrase=new StringBuilder(phrase);
        for(int i=0; i<newPhrase.length();i++) {
            if(isVowel(newPhrase.charAt(i))) {
                newPhrase.setCharAt(i,ch);
            }
        }
        return newPhrase.toString();
    }
    
    public String emphasize(String phrase, char ch) {
        StringBuilder newPhrase=new StringBuilder(phrase);
        for(int i=0;i<newPhrase.length();i++) {
            if(Character.toLowerCase(newPhrase.charAt(i))==Character.toLowerCase(ch)) {
                if(i%2==0) newPhrase.setCharAt(i,'*');
                else newPhrase.setCharAt(i, '+');
            }
        }
        return newPhrase.toString();
    }
    
    public void test() {
        // test isVowel()
        System.out.println(isVowel('h'));
        // test replaceVowels()
        String phrase="Hello World";
        String newPhrase=replaceVowels(phrase,'*');
        System.out.println(newPhrase);
        
        //test emphasize()
        String phrase2="dna ctgaaactga";
        System.out.println(emphasize(phrase2,'A'));
        String phrase3="Mary Bella Abracadabra";
        System.out.println(emphasize(phrase3,'a'));
    }
    
               
}
