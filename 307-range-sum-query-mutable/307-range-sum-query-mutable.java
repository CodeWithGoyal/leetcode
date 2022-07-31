class NumArray {
    private int tree[];
    private int len;
    
    public NumArray(int[] nums) {
        tree = new int[4*nums.length];
        len = nums.length;
        buildTree(nums,tree,1,0,nums.length-1);
        // for(int i = 0; i < tree.length; i++){
        //     System.out.println(tree[i]);
        // }
    }
    
    public void update(int index, int val) {
        updateTree(tree,0,len-1,1,index,val);
        // for(int i = 0; i < tree.length; i++){
        //     System.out.println(tree[i]);
        // }
    }
    
    public int sumRange(int left, int right) {
        // for(int i = 0; i < tree.length; i++){
        //     System.out.println(tree[i]);
        // }
        return findSumRange(tree,0,len -1,1,left,right);
    }
    private void buildTree(int nums[], int tree[], int treeIndex, int start, int end){
        if(start == end){
            tree[treeIndex] = nums[start];
            return ;
        }
        int mid = (start +end)/2;
        buildTree(nums,tree,2*treeIndex,start,mid);
        buildTree(nums,tree,2*treeIndex + 1, mid +1, end);
        tree[treeIndex] = tree[2*treeIndex] + tree[2*treeIndex + 1];
    }
    private void updateTree(int tree[], int start, int end, int treeIndex, int index, int val){
        if(start == end){
            tree[treeIndex] = val;
            return;
        }

        if(index < start || end < index){
            return;
        }
        
        int mid = (start +end) / 2;
        
        if( index <= mid){
            updateTree(tree,start,mid,2*treeIndex,index,val);
        }
        else{
            updateTree(tree,mid + 1,end,2*treeIndex + 1,index,val);
        }
        tree[treeIndex] = tree[2*treeIndex] + tree[2*treeIndex + 1];
    }
    private int findSumRange(int tree[], int start, int end, int treeIndex, int left, int right){
        if(end < left || start > right) return 0;
        if(start >= left && end <= right){return tree[treeIndex];}
        int mid = (start + end)/2;
        return  findSumRange(tree,start,mid,2*treeIndex,left,right) + 
                findSumRange(tree,mid + 1, end,2*treeIndex+1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */