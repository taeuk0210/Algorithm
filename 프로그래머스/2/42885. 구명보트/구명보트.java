import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        people = Arrays.stream(people)
            .boxed()
            .sorted((a,b) -> b-a)
            .mapToInt(Integer::intValue)
            .toArray();
        int s = 0;
        int e = people.length-1;
        while (s <= e) {
            if (people[s] + people[e] <= limit) {
                s++;
                e--;
            } else if (people[s] <= limit) {
                s++;
            }
            answer += 1;
        }
        return answer;
    }
}