public class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX(){ return x; }
    public double getY(){ return y; }

    public double distanceTo(Position other){
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public String toString(){
        return String.format("(%.2f,%.2f)", x,y);
    }
}
