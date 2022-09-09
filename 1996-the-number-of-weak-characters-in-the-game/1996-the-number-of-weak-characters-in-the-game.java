class Solution {
    class Pair{
        int i, j,c;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
            c = 0;
        }
    }
    public int numberOfWeakCharacters(int[][] properties) {
        int len = properties.length;
        Pair arr[] = new Pair[len];
        int i = 0;
        for(int a[] : properties){
            arr[i++] = new Pair(a[0],a[1]);
        }
        Arrays.sort(arr,new Comparator<>(){
            public int compare(Pair p1, Pair p2){
                if(p1.i == p2.i) return p2.j - p1.j;
                return p1.i - p2.i;
            }
        });
        int max = arr[len-1].i;
        int x = arr[len -1].j;
        int count = 0;
        for( i = len -1; i >= 0; i--){
            if(arr[i].i < max && arr[i].j < x){
                // arr[i].c++;
                // System.out.println(arr[i].i  + " " + arr[i].j);
                count++;
            }
            
            x = Math.max(x,arr[i].j);
        }
        // Arrays.sort(arr,new Comparator<>(){
        //     public int compare(Pair p1, Pair p2){
        //         return p1.j - p2.j;
        //     }
        // });
        // int count = 0;
        // max = arr[len-1].j;
        // for( i = len -1; i >= 0; i--){
        //     if(arr[i].j < max){
        //         arr[i].c++;
        //     }
        //     if(arr[i].c == 2){
        //         count++;
        //         
        //     }
        // }
        return count;
    }
}