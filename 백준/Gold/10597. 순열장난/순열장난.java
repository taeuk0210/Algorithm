import java.util.*;

public class Main {
    static List<Integer> sequence;
    static Set<Integer> visited;
    static String answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        int N = number.length() <= 9 ? number.length() : 9 + (number.length()-9)/2;
        sequence = new ArrayList<>();
        visited = new HashSet<>();
        backtrack(0, sequence, visited, number, N);
        System.out.print(answer.strip());
    }

    public static void backtrack(int i, List<Integer> sequence, Set<Integer> visited, String number, int N) {
        if (i == number.length()) {
            answer = "";
            for (int s : sequence)  answer += s+ " ";
            return;
        }
        int num1 = Integer.parseInt(number.substring(i,i+1));
        if (num1>0 && !visited.contains(num1)) {
            visited.add(num1);
            sequence.add(num1);
            backtrack(i+1, sequence, visited, number, N);
            sequence.remove(sequence.size()-1);
            visited.remove(num1);
        }
        if (i+1 < number.length()) {
            int num2 = Integer.parseInt(number.substring(i,i+2));
            if (!visited.contains(num2) && num2 <= N) {
                visited.add(num2);
                sequence.add(num2);
                backtrack(i+2, sequence, visited, number, N);
                sequence.remove(sequence.size()-1);
                visited.remove(num2);
            }
        }
    }
}