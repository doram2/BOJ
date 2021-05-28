import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] seq;
	static Integer[] dp1;
	static Integer[] dp2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		seq = new int[N];
		dp1 = new Integer[N];
		dp2 = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			LIS(i);
			LDS(i);
		}
		for(int i = 0; i < N; i++) {
			max = Math.max(max,dp1[i]+dp2[i]-1);
		}
		
		System.out.println(max);
	}
	
	static int LIS(int N) {
		if(dp1[N] == null) {
			dp1[N] = 1;
		
		for(int i = N-1; i >= 0; i--) {
			if(seq[i] < seq[N])
				dp1[N] = Math.max(dp1[N], LIS(i)+1);
		}
		}
		return dp1[N];
	}
	
	static int LDS(int N) {
		if(dp2[N] == null) {
			dp2[N] = 1;
			
			for(int i = N; i < seq.length; i++) {
				if(seq[i] < seq[N]) {
					dp2[N] = Math.max(dp2[N], LDS(i)+1);
				}
			}
		}
		return dp2[N];
	}
	

}
