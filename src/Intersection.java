public class Intersection {
    int countRoadNum;
    TrafficLight[] tfl;

    //添加连接的road
    public Road[] road; // 0,2 for north-south, 1,3 for east-west
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

    //constructor
    public Intersection(int roadNum, Road[] road){
        countRoadNum = roadNum;
        this.road = road;
        tfl = new TrafficLight[countRoadNum];
    }

}
