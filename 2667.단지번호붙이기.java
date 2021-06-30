import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static int[][] map;
	static boolean[][] visit;
	static int N;
	static int cnt;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static ArrayList arr = new ArrayList();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String S = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = S.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && visit[i][j] != true) {
					cnt = 1;
					find(i,j);
					arr.add(cnt);
				}
			}
		}
		
		Collections.sort(arr);
		
		System.out.println(arr.size());
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

	 static int find(int i, int j) {
		 
		visit[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			int nx = i+dx[k];
			int ny = i+dy[k];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(map[nx][ny] == 1 && visit[nx][ny] != true) {
					find(nx,ny);
					cnt++;
				}
			}
		}
		
		return cnt;
	}

	
}
	
	