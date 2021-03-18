package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;


import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void getNormal() {
        Sphere sp = new Sphere(2.0, new Point3D(1, 0, 1));
        assertEquals(new Vector(0,0,1),sp.getNormal(new Point3D(0,0,3)));
    }
}