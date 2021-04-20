package primitives;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.AbstractObjectListProcessor;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest extends Object{

    @Test
    void testSubtract() {
        Point3D p= new Point3D(2.0, 2.0, 3.0);
        Point3D p1 = new Point3D(2.0, 2.0, 3.0);
        Vector v = p.subtract(p1);

        assertEquals(new Vector(0.0, 0.0, 0.0), v);

    }

    @Test
    void testAdd() {
        Point3D p = new Point3D(2.0, 2.0, 2.0);
        Vector v = new Vector(2.0, 2.0, 0.0);
        Point3D p1 = p.add(v);

        assertEquals(new Point3D(4.0, 4.0, 2.0), p1);
    }

    @Test
    void testDistanceSquared() {
        Point3D p = new Point3D(1.0, 2.0, 3.0);
        Point3D p1 = new Point3D(-3.0, -1.0, 3.0);
        double x1 = p.distanceSquared(p1);
        /**
         * Equivalence partitions tests
         */
        assertEquals(25.00, x1);

    }

    @Test
    void testToString(){
        Point3D p = new Point3D(1.0, 2.0, 3.0);
        Point3D p1 = new Point3D(-3.0, -1.0, 3.0);
        System.out.println("the first point is: "+p);
        System.out.println("the second point is: "+p1);
    }

    @Test
    void distance(){
        Point3D p = new Point3D(1.0, 2.0, 3.0);
        Point3D p1 = new Point3D(-3.0, -1.0, 3.0);
        double x1 = p.distance(p1);
        assertEquals(5.00, x1);

    }
}