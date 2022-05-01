package Entity.Character.Enemy.AI;

public class AIRandom extends AI {
    public int calculateDirection(){
        return random.nextInt(4);
    }
}