import java.util.*;

public class Road {
    //可以两个方向
    float length; //length of the road
    Map<Integer, Road> connected = new HashMap<>();
    List<Queue<Car>> leftTurnQueues = new ArrayList<>();
    List<Queue<Car>> straightLineQueues = new ArrayList<>();
    List<Queue<Car>> rightTurnQueues = new ArrayList<>();
    Intersection startIntrsc;
    Intersection endIntrsc;

    //getters and setters
    public void setStartIntrsc(Intersection startIntrsc) {
        this.startIntrsc = startIntrsc;
    }

    public void setEndIntrsc(Intersection endIntrsc) {
        this.endIntrsc = endIntrsc;
    }

    //constructor

    //getters and setters

    //methods
    public void connectTo(int direction, Road target){
        connected.put(direction, target);
    }
}


