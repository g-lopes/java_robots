public class Punkt {
    public int x;
    public int y;
    public Punkt(){}
    public Punkt(int x, int y){
        this.x = x;
        this.y = y;
    }

    double gibAbstand(Punkt p) {
        return Math.sqrt(Math.pow(this.x - p.x,2) + Math.pow(this.y -p.y,2));
    }
}
