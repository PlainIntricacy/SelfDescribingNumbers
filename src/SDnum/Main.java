/**
 * Self Describing Number Calculator
 * https://www.codeeval.com/browse/40/
 *
 * Author: todyerutz@plainintricacy.wordpress.com
 */

package SDnum;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int q;
        do {
            System.out.println("Welcome ot the Self Describing Number Calculator.");
            System.out.println("Please choose an option by entering the corresponding number:");
            System.out.println("1 - Direct Input");
            System.out.println("2 - Input from Local File");
            System.out.println("0 - Exit");
            q = Integer.parseInt(input.nextLine().replace("\\D+", ""));
        } while (q < 0 || q > 2);
        switch (q) {
            case 0:
                System.out.println("Exiting program...");
                break;
            case 1:
                System.out.println("Please enter the number you want to verify:");
                String x = input.nextLine().replaceAll("\\D+", "");
                Verify(x);
                break;
            case 2:
                System.out.println("Importing numbers from local .txt file...");
                BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Tudor/IdeaProjects/SDnumbers/src/SDnum/nums.txt"));
                String ln;
                while ((ln = reader.readLine()) != null) {
                    Verify(ln);
                }
                reader.close();
                break;
        }
    }

    public static void Verify(String a) {
        String v = a;
        if(a.charAt(0)=='0'){
            a = a.substring(1);
        }
        boolean check=false;
        for (int i = 0; i < a.length(); i++) {
            int sum = 0;
            for (int j = 0; j < a.length(); j++) {
                if (Character.getNumericValue(a.charAt(j)) == i) {
                    sum++;
                }
            }
            if (sum!=Character.getNumericValue(a.charAt(i))) {
                check = false;
            } else {
                check = true;
            }
        }
            if (check) {
                System.out.println("===");
                System.out.println("1");
                System.out.print(v + " is a self describing number.");
                System.out.println();
            } else {
                System.out.println("===");
                System.out.println("0");
                System.out.print(v + " is not a self describing number.");
                System.out.println();
            }
    }
}
