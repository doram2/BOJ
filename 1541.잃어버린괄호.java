import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer m = new StringTokenizer(br.readLine(),"-");
		
		int sum = Integer.MAX_VALUE;
		
		while(m.hasMoreTokens()) {
			int temp = 0;
			
			StringTokenizer p = new StringTokenizer(m.nextToken(),"+");
			
			while(p.hasMoreTokens()) {
				temp += Integer.parseInt(p.nextToken());
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			}
			else {
				sum -= temp;
			}
		}
		
		System.out.println(sum);
		
	}

}
