package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¿¬¼ÓÇÕ1912 {
	
	static int[] arr;
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		
		int max = -10000000;
		for(int i = 0; i < N; i++) {
			SUM(i);
		}
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	
	static int SUM(int N) {
		if(dp[N] == null) {
			dp[N] = arr[N];
			
			if(N > 0) {
				dp[N] = Math.max(dp[N], SUM(N-1)+arr[N]);
			}
		}
		return dp[N];
	}

}
