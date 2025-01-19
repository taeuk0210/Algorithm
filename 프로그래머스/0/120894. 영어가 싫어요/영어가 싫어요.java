class Solution {
    public long solution(String numbers) {
        String a = "";
        while (numbers.length() > 0) {
            if (numbers.charAt(0) == 'z') {
                numbers = numbers.substring(4, numbers.length());
                a += "0";
            } else if (numbers.charAt(0) == 'o') {
                numbers = numbers.substring(3, numbers.length());
                a += "1";
            } else if (numbers.charAt(0) == 't') {
                if (numbers.charAt(1) == 'w') {
                    numbers = numbers.substring(3, numbers.length());
                    a += "2";    
                } else {
                    numbers = numbers.substring(5, numbers.length());
                    a += "3";    
                }
            } else if (numbers.charAt(0) == 'f') {
                if (numbers.charAt(1) == 'o') {
                    numbers = numbers.substring(4, numbers.length());
                    a += "4";    
                } else {
                    numbers = numbers.substring(4, numbers.length());
                    a += "5";    
                }
            } else if (numbers.charAt(0) == 's') {
                if (numbers.charAt(1) == 'e') {
                    numbers = numbers.substring(5, numbers.length());
                    a += "7";    
                } else {
                    numbers = numbers.substring(3, numbers.length());
                    a += "6";    
                }
            } else if (numbers.charAt(0) == 'e') {
                numbers = numbers.substring(5, numbers.length());
                a += "8";
            } else {
                numbers = numbers.substring(4, numbers.length());
                a += "9";
            }
        }
        long answer = Long.parseLong(a);
        return answer;
    }
}