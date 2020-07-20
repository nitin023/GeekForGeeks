package Array;

//Cracking the Interview
public class OneAway {
    public static void main(String[] args) {

        String input1 = "Pales", input2 = "Pales";
        //replace case
        if (input1.length() == input2.length()) {
            if (isReplaceEditSuccessfull(input1, input2)) {
                System.out.println("Replace edit is employed successfully");
            }
            System.out.println("Replace edit is tried but failed");
        } else if (input1.length() - input2.length() == 1) {
            if (isSingleEditSuccessfull(input1, input2)) {
                System.out.println("Single edit is employed successfully");
            } else {
                System.out.println("Single edit is tried but failed");
            }
        } else if (input2.length() - input1.length() == 1) {
            if (isSingleEditSuccessfull(input2, input1)) {
                System.out.println("Single edit is employed successfully");
            } else {
                System.out.println("Single edit is tried but failed");
            }
        } else {
            System.out.println("No one or zero edit is tried");
        }
    }

    private static boolean isReplaceEditSuccessfull(String input1, String input2) {
        int cntMatchedChars = 0, cntUnMatchedChars = 0;
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == input2.charAt(i)) {
                cntMatchedChars++;
            } else {
                cntUnMatchedChars++;
            }
        }

        return cntMatchedChars + cntUnMatchedChars == input1.length();
    }

    private static boolean isSingleEditSuccessfull(String input1, String input2) {
        int index1 = 0, index2 = 0;

        while (index1 < input1.length() && index2 < input2.length()) {
            if (input1.charAt(index1) != input2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
