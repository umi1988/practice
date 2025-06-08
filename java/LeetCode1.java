import java.util.PriorityQueue;

public class LeetCode1
{
    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->y[0]-x[0]);
        if(a>0)
            pq.offer(new int[]{a,'a'});
        if(b>0)
            pq.offer(new int[]{b,'b'});
        if(c>0)
            pq.offer(new int[]{c,'c'});
        StringBuilder sb  =new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            //check if the last 2 ch are same
            if(sb.length()>=2 &&
                    sb.charAt(sb.length()-1)== first[1] &&
                    sb.charAt(sb.length()-2)== first[1]) {
                if (pq.isEmpty()) break;  // No more valid characters.
                // Pick the second character.
                int[] second = pq.poll();
                sb.append((char) second[1]);
                second[0]--;
                if (second[0] > 0) pq.offer(second);
                pq.offer(first);
            } else {
                sb.append((char) first[1]);
                first[0]--;

                if (first[0] > 0) pq.offer(first);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       // String s = longestDiverseString(1,1,7);
        String s = longestDiverseString(7,1,0);
        System.out.println("Longest Happy String is:- " + s);

    }
}
