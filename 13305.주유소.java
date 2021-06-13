import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long d[] = new long[N-1];
		long price[] = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N - 1; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = d[0] * price[0];
		long value = price[0];
		
		for(int k = 1; k < N - 1; k++) {

			if(value < price[k]) {
				sum += d[k] * value;
			}
			else {
				value = price[k];
				sum += d[k] * price[k];
			}
		}
		
		System.out.println(sum);
		
	}

}
