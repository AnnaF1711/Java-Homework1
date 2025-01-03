import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your ID number ");
        String number = scanner.nextLine();
        String newNumberWith0 = addsZeroesIfLessThan9(number);
        boolean result = isIDValid(newNumberWith0);
        while (result==false){
            System.out.println("The number you have entered is "+newNumberWith0);
            System.out.println("Invalid ID. Please enter a valid ID number ");
            String id = scanner.nextLine();
            newNumberWith0 = addsZeroesIfLessThan9(id);
            result = isIDValid(newNumberWith0);
        }
        System.out.println("Correct!");
        System.out.println("Your ID number is "+newNumberWith0 );
    }
    public static String addsZeroesIfLessThan9 (String ID){
        for(int i=0;i<ID.length();i++){
            if(ID.length()<9){
                ID='0'+ID;
            }
        }
        return ID;
    }
    public static boolean isIDValid(String number){
            String pattern ="";//empty string
        String patternMultiplicationResult ="";//empty string
            for (int i = 0; i < number.length(); i++) {
                if (i % 2 == 0) {
                    pattern+=('1');//fills string with 1 if its an even index
                } else {
                    pattern+=('2');//fills string with 2 if its an odd index
                }
                int idDigit = Character.getNumericValue(number.charAt(i));//receives the digit from the string outside as a number value
                int patternDigit = Character.getNumericValue(pattern.charAt(i));//receives the value number from the pattern string
                int multiplicationPattern = idDigit * patternDigit;
                if (multiplicationPattern> 9) {
                    int sumDigit = (multiplicationPattern % 10) + (multiplicationPattern / 10);//sums the digits if its greater than 9
                    multiplicationPattern = sumDigit;
                }
                patternMultiplicationResult+=(multiplicationPattern);//fills the string after multiplication (and the digit sum)
            }
                int sum =0;
                for(int i=0;i<patternMultiplicationResult.length();i++){
                    sum += Character.getNumericValue(patternMultiplicationResult.charAt(i));
                }
                if(sum%10==0){
                    return true;
                }
                return false;
            }
            public static String validateID(String number){
                String pattern = new String();
                String patternResult = new String();
                for (int i = 0; i < number.length(); i++) {
                    if (i % 2 == 0) {
                        pattern+=('1');
                    } else {
                        pattern+=('2');
                    }
                    int idDigit = Character.getNumericValue(number.charAt(i));
                    int patternDigit = Character.getNumericValue(pattern.charAt(i));
                    int multiplicationPattern = idDigit * patternDigit;
                    if (multiplicationPattern> 9) {
                        int sumDigit = (multiplicationPattern % 10) + (multiplicationPattern / 10);
                        multiplicationPattern = sumDigit;
                    }
                    patternResult+=(multiplicationPattern);
                }
                int sum =0;
                for(int i=0;i<patternResult.length();i++){
                    sum += Character.getNumericValue(patternResult.charAt(i));
                }
                if(sum%10!=0){
                    number=number+(10-(sum%10));
                }
                return number;
            }
        }
