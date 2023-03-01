import java.util.PriorityQueue;

public class CarIntersectionEvent extends Event{
    Car car;
    Road road;
    float timestamp;

    //constructor
    public CarIntersectionEvent(Car c, Road r, float t){
        car = c;
        road = r;
        timestamp = t;
    }

    @Override
    void process(PriorityQueue<Event> pq) {
        int choice = (int)(Math.random() * 3);
        switch(choice){
            case 0:
                int least = 0;
                for(int i = 0; i < road.leftTurnQueues.size(); i++){
                    if(road.leftTurnQueues.get(i).size() < road.leftTurnQueues.get(least).size()){
                        least = i;
                    }
                }
                road.leftTurnQueues.get(least).add(car);
                break;
            case 1:
                least = 0;
                for(int i = 0; i < road.straightLineQueues.size(); i++){
                    if(road.straightLineQueues.get(i).size() < road.straightLineQueues.get(least).size()){
                        least = i;
                    }
                }
                road.straightLineQueues.get(least).add(car);
                break;
            case 2:
                least = 0;
                for(int i = 0; i < road.rightTurnQueues.size(); i++){
                    if(road.rightTurnQueues.get(i).size() < road.rightTurnQueues.get(least).size()){
                        least = i;
                    }
                }
                road.rightTurnQueues.get(least).add(car);
                break;
        }
    }
}
