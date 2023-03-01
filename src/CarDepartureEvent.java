import java.util.PriorityQueue;

public class CarDepartureEvent extends Event{
    Car car;
    Road road;
    float timestamp;

    //constructor
    public CarDepartureEvent(Car c, Road r, float t){
        car = c;
        road = r;
        timestamp = t;
    }

    @Override
    void process(PriorityQueue<Event> pq) {
        CarIntersectionEvent e = new CarIntersectionEvent(car, road, timestamp+road.length/car.velocity);
        pq.add(e);
    }
}
