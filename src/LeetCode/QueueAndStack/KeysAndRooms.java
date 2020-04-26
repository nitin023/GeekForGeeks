package LeetCode.QueueAndStack;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Keys and Rooms
 * <p>
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 * Example 2:
 * <p>
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 * Note:
 * <p>
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * The number of keys in all rooms combined is at most 3000.
 */
public class KeysAndRooms {

    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1,3));
        rooms.add(Arrays.asList(3,0,1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        System.out.println(canVisitAllRooms(rooms));
    }

    /**
     * Easy DFS
     *
     * @param rooms
     * @return
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if (rooms == null || rooms.isEmpty()) {
            return false;
        }

        Set<Integer> visitedNodes = new HashSet<>(0);
        Stack<Integer>stack = new Stack<>();
        stack.add(0);

        while (!stack.isEmpty())
        {
           int roomNoIndex =  stack.pop();
           if(!visitedNodes.contains(roomNoIndex)) {
               visitedNodes.add(roomNoIndex);
               List<Integer> roomKeys = rooms.get(roomNoIndex);
               if (!roomKeys.isEmpty()) {
                   stack.addAll(roomKeys);
               }
           }
        }

        for(int i = 0 ; i < rooms.size() ; i++)
        {
            if(!visitedNodes.contains(i))
            {
                return false;
            }
        }
        return true;
    }
}
