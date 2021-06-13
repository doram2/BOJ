import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//1931. 회의실 배정

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] meeting = new int[N][2];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine()," ");
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, new Comparator<int[]>() {
			public int compare(int[] e1, int[] e2) {
				if(e1[1] == e2[1]) {
					return e1[0] - e2[0];
				}
				
				return e1[1] - e2[1];
			}
		});
		
		int cnt = 0;
		int pre_endtime = 0;
		//종료 시간이 제일 빠른 회의 선택 -> 다음 회의의 시작시간은 이전회의의 종료시간 이후
		
		for(int i = 0; i < N; i++) {
			if(pre_endtime <= meeting[i][0]) {
				cnt++;
				pre_endtime = meeting[i][1];
			}
		}
		
		System.out.println(cnt);
		
		
		
		
	
	}

}
