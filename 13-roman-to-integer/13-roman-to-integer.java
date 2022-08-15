class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int len = s.length();
        int res = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == 'I'){
                if(i != len - 1 && s.charAt(i+1) == 'V'){
                    res += 4;
                    i++;
                }
                else if(i != len - 1 && s.charAt(i+1) == 'X'){
                    res += 9;
                    i++;
                }
                else{
                    res += 1;
                }
            }
            else if(s.charAt(i) == 'X'){
                if(i != len - 1 && s.charAt(i + 1 ) == 'L'){
                    res += 40;
                    i++;
                }
                else if(i != len -1 && s.charAt(i + 1) == 'C'){
                    res += 90;
                    i++;
                }
                else{
                    res += 10;
                }
            }
            else if(s.charAt(i) == 'C'){
                if(i != len - 1 && s.charAt(i + 1 ) == 'D'){
                    res += 400;
                    i++;
                }
                else if(i != len -1 && s.charAt(i + 1) == 'M'){
                    res += 900;
                    i++;
                }
                else{
                    res += 100;
                }
            }
            else{
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}