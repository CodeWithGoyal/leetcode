class Solution {
    
    class EmployeeNode {
        int empId;
        int timeTakenToInform;
        
        EmployeeNode(int empId, int timeTakenToInform) {
            this.empId = empId;
            this.timeTakenToInform = timeTakenToInform;
        }
    }
    
    private boolean isManager(int emp, Map<Integer, List<Integer>> tree) {
        return tree.containsKey(emp);
    }
    
    private boolean hasManager(int managerId) {
        return managerId != -1;
    }
    
    private void createTree(Map<Integer, List<Integer>> tree, int n, int[] manager) {
        for(int emp = 0; emp<n; emp++) {
            int managerId = manager[emp];
            if(hasManager(managerId)) {
                tree.putIfAbsent(managerId, new ArrayList<>());
                tree.get(managerId).add(emp);
            }
        }
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {    
        Queue<EmployeeNode> bfs = new LinkedList<>();
        bfs.add(new EmployeeNode(headID, 0));
        int totalInformTime = 0;
        Map<Integer, List<Integer>> tree = new HashMap<>();
        createTree(tree, n, manager);
        
        while(bfs.size() > 0) {            
                 EmployeeNode emp = bfs.poll();
                 totalInformTime = Math.max(totalInformTime, emp.timeTakenToInform);
                 int timeToInformWorker =  emp.timeTakenToInform + informTime[emp.empId];
                 
                 if(isManager(emp.empId, tree)) {
                     for(int worker : tree.get(emp.empId)) {
                         bfs.add(new EmployeeNode(worker, timeToInformWorker));
                     }
                 }
        }
        
        return totalInformTime;
    }
}