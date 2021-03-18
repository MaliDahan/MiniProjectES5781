package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;


import static org.junit.jupiter.api.Assertions.*;

public class CylinderTest {

    @Test
    void getNormal() {
        Cylinder c=new Cylinder(new Ray(new Point3D(4.0,4.0,9.0), new Vector(2.0,6.0,4.0)), 8,  8);
        Point3D p1=new Point3D(0.7,0.7,0.7);
        Vector normal =c.getNormal(p1);
        Vector ExpResult= new Vector(-0.22445208760985944, 0.5912396454113371, -0.7746334243120757);
        assertEquals(normal,ExpResult);
    }

}
