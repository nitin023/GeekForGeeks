package com.twelve.weeks.course.week1.Easy;

import com.twelve.weeks.course.week1.Hard.DinnerPlates;

public class Executor {

    public static void main(String[] args) {
        DinnerPlates D = new DinnerPlates(2);  // Initialize with capacity = 2
        D.push(471);
        D.push(177);
        D.push(1);
        D.push(29);
        D.push(333);
        D.push(154);
        D.push(130);
        D.push(333);
        D.popAtStack(1);
        D.popAtStack(0);
        D.popAtStack(2);
        D.popAtStack(0);


        D.push(165);
        D.push(383);
        D.push(267);
        D.push(367);
        D.push(53);
        D.push(373);
        D.push(388);
        D.push(249);

        D.pop();
        D.pop();
        D.pop();
        D.pop();
    }
}
