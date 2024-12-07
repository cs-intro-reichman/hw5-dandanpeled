/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'e'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        //Setting variables
        String checked_string = str;
        char checked_char = ch;
        int count = 0;
        
        //Check empty input
        if (checked_string == "") {
            return 0;
        }

        //loop to check how many times ch appears
        for (int i = 0; i < checked_string.length(); i++){
            if (checked_string.charAt(i) == checked_char){
                count ++;
            }
        }
        
        return count;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
         //Setting variables
         String ifExist = str1;
         String baseString = str2;
         boolean char_found = false;
         
        if (baseString == "" || ifExist.length() > baseString.length()){
            return false;
        }else if (ifExist == ""){
            return true;
         }

         for (int i = 0; i < ifExist.length(); i++){
            char charToCheck = ifExist.charAt(i);
            int numberOfTimesIfExist = countChar(ifExist, charToCheck);
            int numberOfTimesBaseString = countChar(baseString, charToCheck);
            
            if (numberOfTimesBaseString != numberOfTimesIfExist) {
                return false;
                
            }
         }

    return true;
    }
  

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        //Setting variables
        String inputString = str;
        String newString = "";

        if (inputString == ""){
            return "";
        }

        newString += inputString.charAt(0);

        for (int i = 1; i < inputString.length()-1; i++){
            newString += " " + inputString.charAt(i);
        }

        if (inputString.length() > 1){
            newString += " " + inputString.charAt(inputString.length()-1);

        }
        return newString;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        //Setting variables
        int numOfChars = n;
        String newString = "";

        for (int i = 0; i < numOfChars - 1; i++){
            int randomAscii = (int) (97 + Math.random() * (122 - 97 + 1));
            char randomChar = (char)(randomAscii);
            newString += randomChar;
        }
        return newString;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        //Setting variables
        String baseString = str1;
        String charsToRemove = str2;
        String newString = "";

        if (charsToRemove == ""){
            return baseString;
        }

        for (int i = 0; i < baseString.length(); i++){
            char charToCheck = baseString.charAt(i);
            int countAtToRemove = countChar(charsToRemove, charToCheck);
            int countAtBase = countChar(baseString, charToCheck);
            int countAtNew = countChar(newString, charToCheck);

            if (countAtNew < countAtBase - countAtToRemove ){
                newString += charToCheck;
            }
        }
        return newString;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
