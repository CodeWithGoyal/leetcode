class Solution {
    class Pair{
        int v, i;
        Pair(int val, int ind){
            v = val;
            i = ind;
        }
    }
    public List<Integer> countSmaller(int[] arr) {
        int n = arr.length;
        int res[] = new int [n];
        // set.add(arr[n-1]);
        Pair p[] = new Pair[n];
        for(int i = n-1; i >= 0; i--){
            p[i] = new Pair(arr[i],i);
        }
        mergeSort(p,0,n-1,res);
        List<Integer> list = new ArrayList<>();
        for(int x : res)list.add(x);
        return list;
    }
     void mergeSort(Pair arr[], int l, int r, int res[]){
        if(l == r) return;
        int mid = (l + r)/2;
        mergeSort(arr,l,mid,res);
        mergeSort(arr,mid + 1, r, res);
        merge(arr,l,mid,r,res);
    }
    void merge(Pair arr[], int l,int mid,int r, int res[]){
        int i = l,j = mid + 1, k = 0;
        Pair temp[] = new Pair[r - l + 1];
        int count = 0;
        while(i <= mid && j <= r){
            if(arr[i].v <= arr[j].v){
                res[arr[i].i] += count;
                temp[k++] = arr[i++];
            }
            else{
                count++;
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            res[arr[i].i] += count;
            temp[k++] = arr[i++];
        }
        while(j <= r){
            temp[k++] = arr[j++];
        }
        for( i = 0; i < temp.length; i++){
            arr[l + i] = temp[i];
        }
    }
}