class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char c : tasks)
            freq[c - 'A']++;

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> b - a);

        for (int f : freq)
            if (f > 0)
                pq.offer(f);

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            int cycle = n + 1;

            while (cycle > 0 && !pq.isEmpty()) {
                int cnt = pq.poll();
                cnt--;

                if (cnt > 0)
                    temp.add(cnt);

                time++;
                cycle--;
            }

            for (int x : temp)
                pq.offer(x);

            if (pq.isEmpty())
                break;

            time += cycle;
        }

        return time;
    }
}