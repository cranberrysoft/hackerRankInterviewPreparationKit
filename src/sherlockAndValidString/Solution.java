package sherlockAndValidString;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.regex.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.summingLong;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {

        final Map<Integer, Long> frequency = s.chars().boxed()
                .collect(
                        groupingBy(
                                Function.identity(),
                                counting()
                        )

                );

        final List<Long> distinctElements = frequency.values().stream().distinct().collect(toList());

        if (distinctElements.size() == 1) {
            return "YES";
        } else if (distinctElements.size() == 2) {

            final Map<Integer, Long> first = frequency.entrySet().stream().filter(entry -> entry.getValue() == distinctElements.get(0)).collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
            final Map<Integer, Long> second = frequency.entrySet().stream().filter(entry -> entry.getValue() == distinctElements.get(1)).collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

            if(first.size() == 1 || second.size() == 1){
                if(Math.abs(distinctElements.get(0) - distinctElements.get(1)) == 1 ||
                        (first.size() == 1 && first.values().stream().findFirst().get() - 1 == 0 ) ||
                        (second.size() == 1 && second.values().stream().findFirst().get()  -1 == 0 )
                ){
                    return "YES";
                }

            }

            return "NO";
        } else {
            return "NO";
        }

    }

   //private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner scanner = new Scanner(new ByteArrayInputStream(("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd").getBytes()));
    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
