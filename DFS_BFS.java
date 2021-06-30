import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수
		int V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호
	
		DFS_Node node1 = new DFS_Node(N);
		BFS_Node node2 = new BFS_Node(N);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			node1.put(v,w);
			node2.put(v,w);
		}
		node1.dfs(V);
		System.out.println();
		node2.bfs(V);
	}
	
	static class DFS_Node {
		static int list[][];
		static boolean visit[];
		DFS_Node(int n){
			this.list = new int[n+1][n+1];
			this.visit = new boolean[n+1];
		}
		
		static void put(int v, int w) {
			list[v][w] = 1; //(v,w)
			list[w][v] = 1;
		}
		static void dfs(int V) {
			visit[V] = true;
			System.out.print(V+" ");
			for(int i = 0; i < visit.length; i++) {
				if(list[V][i] == 1 && visit[i] != true) {
					dfs(i);
				}
			}
		}
		
	}
	
	static class BFS_Node{
		static int[][] list;
		int[][] n;
		static boolean[] visit;
		static Queue<Integer> queue = new LinkedList<>();
		BFS_Node(int n){
			list = new int[n+1][n+1];
			visit = new boolean[n+1];
		}
		void put(int v, int w) {
			list[v][w] = 1;
			list[w][v] = 1;
		}
		static void bfs(int V) {
			visit[V] = true;
			queue.add(V);
			
			while(queue.size() != 0) {
				V = queue.poll();
				System.out.print(V+" ");
				for(int i = 0; i < visit.length; i++) {
					if(list[V][i] == 1 && visit[i] != true) {
						queue.add(i);
						visit[i] = true;
					}
				}
			}
		}
	}

}
