package LeetCode.QueueAndStack;

import java.util.*;

/**
 * You have a lock in front of you with 4 circular wheels.
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * <p>
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * <p>
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 * <p>
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * <p>
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 */
public class OpenTheLock {

    public static void main(String[] args) {

        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        System.out.println(openLock(deadends, "0202"));
    }

    /**
     * Its like tree Level order traversal
     * we gen all combinations in a level by considering inc each node val by 1 or by dec node val by 2
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock(String[] deadends, String target) {

        int level = 0;
        Set<String> visitedNodes = new HashSet<>();
        Set<String> deadEndSets = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String node = queue.poll();

                if (!visitedNodes.contains(node) && !deadEndSets.contains(node)) {
                    if (node.equals(target)) {
                        return level;
                    }
                    visitedNodes.add(node);
                    char[] nodeArr = node.toCharArray();
                    for (int j = 0; j < nodeArr.length; j++) {
                        char currentItem = nodeArr[j];
                        if (nodeArr[j] < '9') {
                            nodeArr[j]++;
                        } else {
                            nodeArr[j] = '0';
                        }
                        queue.add(new String(nodeArr));
                        nodeArr[j] = currentItem;

                        if (nodeArr[j] > '0') {
                            nodeArr[j]--;
                        } else {
                            nodeArr[j] = '9';
                        }
                        queue.add(new String(nodeArr));
                        nodeArr[j] = currentItem;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}

