import java.util.PriorityQueue;

public class TrafficLightEvent extends Event{
    Intersection intersection;
    int direction; // 0 for north-south, 1 for east-west
    float timestamp;

    //constructor
    public TrafficLightEvent(Intersection i, float t, int d){
        intersection = i;
        timestamp = t;
        direction = d;
    }

    @Override
    void process(PriorityQueue<Event> pq) {
        TrafficLightEvent nextLightChange = new TrafficLightEvent(intersection, timestamp + intersection.tfl[0].greenTime, (direction+1)%2);
        pq.add(nextLightChange);

        float totalGreeenTime = intersection.tfl[direction].greenTime;
        int totalCarCrossIntersection = (int)(totalGreeenTime/2);

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
        for(int i = 0; i < totalCarCrossIntersection; i++){
            if(direction == 0){
                int road = 0;
                for(int j = 0; j < intersection.road[road].leftTurnQueues.size(); j++){
                    if(intersection.road[road].leftTurnQueues.get(j).size() > 0){ // isEmpty
                        Car car = intersection.road[road].leftTurnQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[7], timestamp+2*i);
                        pq.add(e);
                    }
                }
                for(int j = 0; j < intersection.road[road].straightLineQueues.size(); j++){
                    if(intersection.road[road].straightLineQueues.get(j).size() > 0){
                        Car car = intersection.road[road].straightLineQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[6], timestamp+2*i);
                        pq.add(e);
                    }
                }
                for(int j = 0; j < intersection.road[road].rightTurnQueues.size(); j++){
                    if(intersection.road[road].rightTurnQueues.get(j).size() > 0){
                        Car car = intersection.road[road].rightTurnQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[5], timestamp+2*i);
                        pq.add(e);
                    }
                }
                road = 2;
                for(int j = 0; j < intersection.road[road].leftTurnQueues.size(); j++){
                    if(intersection.road[road].leftTurnQueues.get(j).size() > 0){
                        Car car = intersection.road[road].leftTurnQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[5], timestamp+2*i);
                        pq.add(e);
                    }
                }
                for(int j = 0; j < intersection.road[road].straightLineQueues.size(); j++){
                    if(intersection.road[road].straightLineQueues.get(j).size() > 0){
                        Car car = intersection.road[road].straightLineQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[4], timestamp+2*i);
                        pq.add(e);
                    }
                }
                for(int j = 0; j < intersection.road[road].rightTurnQueues.size(); j++){
                    if(intersection.road[road].rightTurnQueues.get(j).size() > 0){
                        Car car = intersection.road[road].rightTurnQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[7], timestamp+2*i);
                        pq.add(e);
                    }
                }
            }
            else if(direction == 1){
                int road = 1;
                for(int j = 0; j < intersection.road[road].leftTurnQueues.size(); j++){
                    if(intersection.road[road].leftTurnQueues.get(j).size() > 0){
                        Car car = intersection.road[road].leftTurnQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[4], timestamp+2*i);
                        pq.add(e);
                    }
                }
                for(int j = 0; j < intersection.road[road].straightLineQueues.size(); j++){
                    if(intersection.road[road].straightLineQueues.get(j).size() > 0){
                        Car car = intersection.road[road].straightLineQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[7], timestamp+2*i);
                        pq.add(e);
                    }
                }
                for(int j = 0; j < intersection.road[road].rightTurnQueues.size(); j++){
                    if(intersection.road[road].rightTurnQueues.get(j).size() > 0){
                        Car car = intersection.road[road].rightTurnQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[6], timestamp+2*i);
                        pq.add(e);
                    }
                }
                road = 3;
                for(int j = 0; j < intersection.road[road].leftTurnQueues.size(); j++){
                    if(intersection.road[road].leftTurnQueues.get(j).size() > 0){
                        Car car = intersection.road[road].leftTurnQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[6], timestamp+2*i);
                        pq.add(e);
                    }
                }
                for(int j = 0; j < intersection.road[road].straightLineQueues.size(); j++){
                    if(intersection.road[road].straightLineQueues.get(j).size() > 0){
                        Car car = intersection.road[road].straightLineQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[5], timestamp+2*i);
                        pq.add(e);
                    }
                }
                for(int j = 0; j < intersection.road[road].rightTurnQueues.size(); j++){
                    if(intersection.road[road].rightTurnQueues.get(j).size() > 0){
                        Car car = intersection.road[road].rightTurnQueues.get(j).poll();
                        CarDepartureEvent e = new CarDepartureEvent(car, intersection.road[4], timestamp+2*i);
                        pq.add(e);
                    }
                }
            }
        }        
    }
}
