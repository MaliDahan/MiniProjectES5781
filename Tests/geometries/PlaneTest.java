package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

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

    @Test
    void findIntersections() {
        Plane s1 = new Plane(new Point3D(1.0,0.0,0.0),
                new Point3D(0.0,0.0,0.0),
                new Point3D(0.0,0.0,1.0));
        //EP: The Ray must be neither orthogonal nor parallel to the plane
        //• Ray intersects the plane
        Ray EP11 = new Ray(new Point3D(-1.0,-1.0,0.0), new Vector(1.0,1.0,0.0));
        List<Point3D> resultEP11 = s1.findIntersections(EP11);

        assertEquals( 1, resultEP11.size(),"Wrong number of points");

        assertEquals(List.of(new Point3D(0,0,0)), resultEP11, "Ray crosses Plane");
        //• Ray does not intersect the plane
        Ray EP12 = new Ray(new Point3D(5.0,5.0,0.0), new Vector(1.0,1.0,0.0));
        List<Point3D> resultEP12 = s1.findIntersections(EP12);

        assertEquals( 0, resultEP12.size(),"Wrong number of points");

        //BVA: 7 cases
        //• Ray is parallel to the plane
        //• Two cases – the ray included
        Ray EP211 = new Ray(new Point3D(0.0,0.0,0.0), new Vector(1.0,0.0,0.0));
        try{
            List<Point3D> resultEP211 = s1.findIntersections(EP211);
            // if not reject Arithmetic exception that's mean that the ray is not parallel to the plane
            // and so it's reject a fail test
            fail("must be parallel because the ray is inside the plane ");
        }
        catch(ArithmeticException Ae) {}


        //not included in the plane
        Ray EP212 = new Ray(new Point3D(0.0,1.0,0.0), new Vector(1.0,0.0,0.0));
        try {
            List<Point3D> resultEP212 = s1.findIntersections(EP212);
            // if not reject Arithmetic exception that's mean that the ray is not parallel to the plane
            // and so it's reject a fail test
            fail("must be parallel ");
        }
        catch(ArithmeticException Ae) {}

        //• Ray is orthogonal to the plane
        //• Three cases – according to 𝑃0 (before, in, after the plane)
        //========================BEFORE========================//
        Ray EP221 = new Ray(new Point3D(0.0,-1.0,0.0), new Vector(0.0,5.0,0.0));
        List<Point3D> resultEP221 = s1.findIntersections(EP221);

        assertEquals( 1, resultEP221.size(),"Wrong number of points");

        assertEquals(List.of(new Point3D(0,0,0)), resultEP221, "Ray crosses Plane");
        //======================== AFTER ========================//
        Ray EP222 = new Ray(new Point3D(0.0,1.0,0.0), new Vector(0.0,5.0,0.0));
        List<Point3D> resultEP222 = s1.findIntersections(EP222);

        assertEquals( 0, resultEP222.size(),"Wrong number of points");

        //======================== IN ========================//
        Ray EP223 = new Ray(new primitives.Point3D(0.0,0.0,0.0), new Vector(0.0,5.0,0.0));
        List<Point3D> resultEP223 = s1.findIntersections(EP223);

        assertEquals( 0, resultEP223.size(),"Wrong number of points");

        //• Ray is neither orthogonal nor parallel to and begins at the plane(𝑃0 is in the plane, but not the ray)

        //======================== IN ========================//
        Ray EP23 = new Ray(new Point3D(1.0,0.0,0.0), new Vector(5.0,5.0,0.0));
        List<Point3D> resultEP23 = s1.findIntersections(EP23);

        assertEquals( 0, resultEP23.size(),"Wrong number of points");

        //• Ray is neither orthogonal nor parallel to the plane and begins in the same point which appears as reference point in the plane (Q)
        //======================== IN ========================//
        Ray EP24 = new Ray(new Point3D(1.0,0.0,0.0), new Vector(5.0,5.0,0.0));
        List<Point3D> resultEP24 = s1.findIntersections(EP24);

        assertEquals( 0, resultEP24.size(),"Wrong number of points");
    }
}


