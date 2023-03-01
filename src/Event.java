import java.util.PriorityQueue;

abstract public class Event{
    int timestamp;

    abstract void process(PriorityQueue<Event> eventQueue);
}