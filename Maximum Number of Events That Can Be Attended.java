class Solution {
    public int maxEvents(int[][] events) 
    {
        int n = events.length;
        
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        
        int ans = 0;
        
        int i = 0;
        
        for(int d=1;d<=100001;d++)
        {
            while(i<n && events[i][0]==d)
            {
                p.add(events[i][1]);
                i++;
            }
            
            while(!p.isEmpty() && p.peek()<d)
            {
                p.poll();
            }
            
            if(!p.isEmpty())
            {
                p.poll();
                ans++;
            }
        }
        
        return ans;
    }
}
