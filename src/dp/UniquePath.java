package dp;

/**
 * 최단 경로가 가능한 경로의 수 찾는 문제
 * */

public class UniquePath {
    public static void main(String[] args) {
        int m = 7, n = 3;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++)
            map[i][0] = 1;

        for (int j = 0; j < n; j++)
            map[0][j] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                map[i][j] = map[i - 1][j] + map[i][j - 1];


        return map[m - 1][n - 1];
    }
}