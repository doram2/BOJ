
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
		
	static Integer[][] dp;
	static char[] arr1,arr2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr1 = br.readLine().toCharArray();//���ڿ�(String)�� char[]�� ��ȯ�ϴ� �޼ҵ�
		arr2 = br.readLine().toCharArray();
		
		dp = new Integer[arr1.length][arr2.length];
			
		System.out.println(LCS(arr1.length-1,arr2.length-1));
	}
	
	static int LCS(int x, int y) {
		if(x == -1 || y == -1) // �ε����� ������ ��� ���
			return 0;

		if(dp[x][y] == null) { //Ž������ ���� �κи� Ž��
			dp[x][y] = 0;
			
			if(arr1[x] == arr2[y]) { 
				dp[x][y] = LCS(x-1, y-1)+1; //���� �����ϰ�� 
			}
			else
				dp[x][y] = Math.max(LCS(x,y-1),LCS(x-1,y)); //���� ���� ��� �� ���� �� ū ������ �ʱ�ȭ
			
		}
		
		return dp[x][y];
		
	}
		
	}


	
