package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    public void getNormal(Point3D point3D)
            throws Exception {

        Plane P = new Plane(new Point3D(6, 7, 8), new Vector(4, 5, 6));
        Vector V1 = P. _normal;
        Vector V2 = P.getNormal(new Point3D(3, 4, 5));
        assertEquals(V1, V2);
    }

}
