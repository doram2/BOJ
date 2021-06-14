import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); //가지고 있는 랜선 수
		int N = Integer.parseInt(st.nextToken()); //필요한 랜선 수
		
		int[] lan = new int[K];
		
		for(int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(lan);
		
		long length = lan[K-1];
		long min = 1;
		long middle = 0;
		
		while(length >= min) {
			middle = (length + min)/2;
			
			long cnt = 0;
			
			for(int i = 0; i < K; i++) {
				cnt += lan[i] / middle;
			}
			
			if(cnt >= N) {
				min = middle + 1;
			}
			else if(cnt < N) {
				length = middle - 1; 
			}
		}
		
		System.out.println(length);
	}	
		
}
	
	