class Solution {
    public int solution(String[] spell, String[] dic) {
        int s, o;
        for (String d : dic) {
            s = 0;
            for (String sp : spell) {
                o = 0;
                for (String w : d.split("")) {
                    if (sp.equals(w)) o++;
                }
                if (o == 1) s++;
            }
            if (s==spell.length) return 1;
        }
        return 2;
    }
}