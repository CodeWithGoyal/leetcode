class Solution {
    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        String res = "";
        res = reverse(arr[0]);
        for(int i = 1; i < arr.length; i++){
            res = res + " " + reverse(arr[i]);
        }
        return res;
    }
    public String reverse(String str){
        char arr[] = str.toCharArray();
        for(int i = 0, j = arr.length -1; i < j; i++,j--){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return String.valueOf(arr);
    }
}