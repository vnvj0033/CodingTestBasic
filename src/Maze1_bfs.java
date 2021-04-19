import java.util.LinkedList;
import java.util.Queue;

public class Maze1_bfs {
    public static void main(String[] args) {

        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] dest = {4, 4};

        Maze1_bfs a = new Maze1_bfs();

        System.out.println(a.hasPath(maze, start, dest));
    }


    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;

        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        visited[start[0]][start[1]] = true;
        queue.offer(start.clone());

        while (!queue.isEmpty()) {

            int[] p = queue.poll();
            for (int[] dir : dirs) {

                int x = p[0];
                int y = p[1];

                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    System.out.println("");
                    x += dir[0];
                    y += dir[1];

                }

                x -= dir[0];
                y -= dir[1];

                if (visited[x][y]) continue;

                visited[x][y] = true;
                print(visited);

                if (x == destination[0] && y == destination[1]) return true;

                queue.offer(new int[]{x, y});
            }
            System.out.println("");
        }
        return false;
    }

    private void print(boolean[][] visited) {
        if (visited == null || visited.length == 0) return;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
