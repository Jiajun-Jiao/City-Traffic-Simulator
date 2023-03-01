public class TrafficLight {
    int leftTurnColor; // -1 for red, 0 for yellow, 1 for green
    int straightTurnColor; // -1 for red, 0 for yellow, 1 for green
    int rightTurnColor; // -1 for red, 0 for yellow, 1 for green
    float greenTime;
    float redTime;

    //constructor
    public TrafficLight(float greenTime, float redTime){
        this.greenTime = greenTime;
        this.redTime = redTime;
        leftTurnColor = 1;
        straightTurnColor = -1;
        rightTurnColor = -1;
    }
}
