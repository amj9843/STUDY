import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        private int prev;
        private int next;
        private int weight;

        public Node(int prev, int next, int weight) {
            this.prev = prev;
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    private static int[] x_move = {1, 0, -1, 0};
    private static int[] y_move = {0, 1, 0, -1};
    private int n;
    private int[][] groups;
    private int[] parents;
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        n = land.length;

        groups = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(groups[i], -1);
        }

        int group = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (groups[i][j] != -1) {
                    continue;
                }
                makeGroup(i, j, group, height, land);
                group++;
            }
        }

        Queue<Node> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = i + x_move[k];
                    int y = j + y_move[k];

                    if (!isInArea(x, y)) {
                        continue;
                    }

                    if (groups[i][j] == groups[x][y]) {
                        continue;
                    }

                    heap.add(new Node(groups[i][j], groups[x][y], Math.abs(land[i][j] - land[x][y])));
                }
            }
        }

        parents = new int[group];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        int count = 0;
        while (!heap.isEmpty()) {
            if (count == group) {
                break;
            }

            Node node = heap.poll();
            int prev = node.prev;
            int next = node.next;
            int weight = node.weight;

            if (find(prev) == find(next)) {
                continue;
            }

            union(prev, next);
            answer += weight;
            count++;
        }

        return answer;
    }
    
    private int find(int group) {
        if (parents[group] == group) {
            return group;
        }

        return find(parents[group]);
    }

    private void union(int prev, int next) {
        int prevParent = find(prev);
        int nextParent = find(next);

        parents[Math.max(prevParent, nextParent)] = Math.min(prevParent, nextParent);
    }

    private void makeGroup(int x, int y, int group, int height, int[][] land) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (groups[current.x][current.y] != -1) {
                continue;
            }

            groups[current.x][current.y] = group;

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + x_move[i];
                int nextY = current.y + y_move[i];

                if (!isInArea(nextX, nextY)) {
                    continue;
                }

                if (Math.abs(land[current.x][current.y] - land[nextX][nextY]) > height) {
                    continue;
                }
                queue.add(new Point(nextX, nextY));
            }
        }
    }
}