public class Vector2D {
    double x;
    double y;
    public Vector2D() {
        this(0, 0);
    }
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public Vector2D addThis(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }
    public Vector2D addThis(Vector2D vector) {
        this.x += vector.x;
        this.y += vector.y;
        return this;
    }
    public Vector2D scaleThis(double rate) {
        this.x *= rate;
        this.y *= rate;
        return this;
    }
    public Vector2D scaleThis(double rateX, double rateY) {
        this.x *= rateX;
        this.y *= rateY;
        return this;
    }
    public Vector2D scaleThis(Vector2D vector) {
        this.x *= vector.x;
        this.y *= vector.y;
        return this;
    }
    public Vector2D ellipseDownScale(Vector2D vector) {
        if ((this.x != 0 || this.y != 0) && (vector.x * vector.y > 0)) {
            this.scaleThis(1 / Math.sqrt(Math.pow(this.x / vector.x, 2) + Math.pow(this.y / vector.y, 2)));
            return this;
        }
        return new Vector2D();
    }
    public double getDistance(Vector2D vector1, Vector2D vector2) {
        return Math.sqrt(Math.pow(vector1.x - vector2.x, 2) + Math.pow(vector1.y - vector2.y, 2));
    }
    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }
    public Vector2D setLength(double length) {
        return this.scaleThis(length / this.getLength());
    }
    public double getAngle() {
        if (this.x == 0) {
            if (this.y == 0) {
                return 361;
            }
            return Math.PI / 2 - Math.PI * Math.signum(this.y - Math.abs(this.y));
        }
        return Math.atan(this.y / this.x) - Math.PI * Math.signum((int)(this.x - Math.abs(this.x)));
    }
    public Vector2D setAngle(double angle) {
        double length = this.getLength();
        this.x = length * Math.cos(angle);
        this.y = length * Math.sin(angle);
        return this;
    }
//    public static void main (String[] args) {
//        Vector2D vector = new Vector2D(1, 1);
//        vector.setAngle(Math.PI/4);
//    }
}
