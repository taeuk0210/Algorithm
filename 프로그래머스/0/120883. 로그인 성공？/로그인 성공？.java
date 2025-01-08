class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for (String[] user : db) {
            if (user[0].equals(id_pw[0])) {
                return user[1].equals(id_pw[1]) ? "login" : "wrong pw";
            }
        }
        return "fail";
    }
}