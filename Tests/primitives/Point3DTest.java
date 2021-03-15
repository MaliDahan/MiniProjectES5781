package primitives;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.AbstractObjectListProcessor;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {
    Point3D p1= new Point3D(1.0d,2.0d,3.0d);
    Point3D p2=new Point3D(1.000000000000001,2,3);
    @Test
    void testEquals() {
        //boolean equality=p1.equals(p2);
        //assertTrue(equality);
        assertEquals(p1,p2);
    }

    @Test
    void distanceSquared() {
    }

    @Test
    void testToString(){
        System.out.println("the first point is: "+p1);
        System.out.println("the second point is: "+p2);
    }

    @Test
    void distance(){
        assertEquals(20,p1.distance(p2));
    }
}