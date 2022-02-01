// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String X = sc.next();
                    String Y = sc.next();
                    int costX = sc.nextInt();
                    int costY = sc.nextInt();
                    
                   
                    Solution ob = new Solution();
                    System.out.println(ob.findMinCost(X,Y,costX,costY));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    int[][] dp;
	public int findMinCost(String X, String Y, int costX, int costY)
	{
		// Your code goes here
		int n=X.length();
		int m=Y.length();
		
		dp=new int[X.length()+1][Y.length()+1];
		
		for(int i=n;i>=0;i--){
		    for(int j=m;j>=0;j--){
		        
		    if(i>=X.length()||j>=Y.length()){
	        if(i<X.length()){
	            
	            dp[i][j]= costX*(X.length()-i);
	            
	        }else if(j<Y.length()){
	            dp[i][j]= costY*(Y.length()-j); 
	            
	        }else{
	            dp[i][j]= 0;
	        }
	        continue;
	    }
		        
		        
		   if(X.charAt(i)==Y.charAt(j)){
	        dp[i][j]= dp[i+1][j+1];
	    }else{
	        dp[i][j]= Math.min(dp[i][j+1]+costY,dp[i+1][j]+costX);
	    }
		        
		        
		    }
		}
		
		return dp[0][0];
		
		
// 		return solve(X,Y,0,0,costX,costY);
	}
	
// 	public int solve (String x,String y,int i,int j,int costX,int costY){
	    
	   // if(i>=x.length()||j>=y.length()){
	   //     if(i<x.length()){
	            
	   //         return costX*(x.length()-i);
	   //     }else if(j<y.length()){
	   //         return costY*(y.length()-j); 
	   //     }else{
	   //         return 0;
	   //     }
	   // }
	    
// 	    if(dp[i][j]!=null)return dp[i][j];
	    
	    
// 	    if(x.charAt(i)==y.charAt(j)){
// 	       return dp[i][j]= solve(x,y,i+1,j+1,costX,costY);
// 	    }else{
// 	       return dp[i][j]= Math.min(solve(x,y,i,j+1,costX,costY)+costY,solve(x,y,i+1,j,costX,costY)+costX);
// 	    }
// 	}
}
