import java.util.PriorityQueue;

public class Simulator {
    public void buildMap(){
        
        //           C
        //          2 6
        //          | ^
        //          | |
        //          v |
        // D 7 <---- E <---- 1  B
        //   3 ---->   ----> 5
        //          | ^
        //          | |
        //          v |  
        //          4 0
        //           A
        Intersection center = new Intersection(8, new Road[8]);
        Intersection A = new Intersection(8, new Road[8]);
        Intersection B = new Intersection(8, new Road[8]);
        Intersection C = new Intersection(8, new Road[8]);
        Intersection D = new Intersection(8, new Road[8]);
        Road r0 = new Road();
        r0.setStartIntrsc(A);
        r0.setEndIntrsc(center);
        Road r1 = new Road();
        r1.setStartIntrsc(B);
        r1.setEndIntrsc(center);
        Road r2 = new Road();
        r2.setStartIntrsc(C);
        r2.setEndIntrsc(center);
        Road r3 = new Road();
        r3.setStartIntrsc(D);
        r3.setEndIntrsc(center);
        Road r4 = new Road();
        r4.setStartIntrsc(center);
        r4.setEndIntrsc(A);
        Road r5 = new Road();
        r5.setStartIntrsc(center);
        r5.setEndIntrsc(B);
        Road r6 = new Road();
        r6.setStartIntrsc(center);
        r6.setEndIntrsc(C);
        Road r7 = new Road();
        r7.setStartIntrsc(center);
        r7.setEndIntrsc(D);

        Road e_out = new Road();
        Road e_in = new Road();

        Road[] road = {r0, r1, r2, r3, r4, r5, r6, r7};
        center.road = road;
        Road[] roadA = {e_in, e_in, r4, e_in, e_out, e_out, r0, e_out};
        // road[2] = r4;
        // road[6] = r0;
        A.road = roadA;
        Road[] roadB = {e_in, e_in, e_in, r5, e_out, e_out, e_out, r1};
        // road[3] = r5;
        // road[7] = r1;
        B.road = roadB;
        Road[] roadC = {r6, e_in, e_in, e_in, r2, e_out, e_out, e_out};
        // road[4] = r2;
        // road[0] = r6;
        C.road = roadC;
        Road[] roadD = {e_in, r7, e_in, e_in, e_out, r3, e_out, e_out};
        // road[5] = r3;
        // road[1] = r7;
        D.road = roadD;

        //add traffic light
        //        2 6
        //        | ^
        //        | |
        //        v |
        // 7 <----   <---- 1
        // 3 ---->   ----> 5
        //        | ^
        //        | |
        //        v |  
        //        4 0
        
        TrafficLight[] tfl = new TrafficLight[8];
        

    }

    public void eventflow(){
        PriorityQueue<Event> eventQueue = new PriorityQueue<Event>();
        while(!eventQueue.isEmpty()){
            Event e = eventQueue.poll();
            e.process(eventQueue);
        }
    }
}
