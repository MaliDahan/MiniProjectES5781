package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void getNormal() {
        Sphere sp = new Sphere(2.0, new Point3D(1, 0, 1));
        assertEquals(new Vector(0,0,1),sp.getNormal(new Point3D(0,0,3)));
    }

    /**
     * Test method for {@link geometries.Sphere#findIntersections(primitives.Ray)}.
     */
    @Test
    public void testFindIntersections() {
        Sphere sphere = new Sphere(1d, new Point3D(1, 0, 0));

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(1, 1, 0))), "Ray's line out of sphere");

        // TC02: Ray starts before and crosses the sphere (2 points)
        Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
        Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
        List<Point3D> result = sphere.findIntersections(new Ray(new Point3D(-1, 0, 0),
                new Vector(3, 1, 0)));
        assertEquals( 2, result.size(),"Wrong number of points");
        result = List.of(result.get(1), result.get(0));
        assertEquals( List.of(p1, p2), result,"Ray crosses sphere");

    }}