
abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    double x;
    double y;
    double z;

    Triangle(double x, double y, double z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    double getPerimeter() {
        return x + y + z;
    }

    @Override
    double getArea() {
        final double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - x) * (s - y) * (s - z));
    }
}

class Rectangle extends Shape {
    double x;
    double y;

    Rectangle(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    double getPerimeter() {
        return x + x + y + y;
    }

    @Override
    double getArea() {
        return x * y;
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double getArea() {
        return Math.PI * (radius * radius);
    }
}