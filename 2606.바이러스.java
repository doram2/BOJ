import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());
		
		Node node = new Node(N);
		
		for(int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			node.connection(v,w);
		}
		
		node.virus(1);
		System.out.println(cnt);
	}
	
	static class Node{
		int list[][];
		boolean visit[];
		
		Node(int N){
			this.list = new int[N+1][N+1];
			this.visit = new boolean[N+1];
		}
		
		void connection(int v, int w) {
			list[v][w] = 1;
			list[w][v] = 1;
		}
		
		void virus(int N) {
			visit[N] = true;
			for(int i = 0; i < visit.length; i++) {
				if(list[N][i] == 1 && visit[i] != true) {
					virus(i);
					cnt++;
				}
			}
		}
	}
	
}
