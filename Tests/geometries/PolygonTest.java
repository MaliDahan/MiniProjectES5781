package geometries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

/**
 * Testing Polygons
 *
 * @author Dan
 */
public class PolygonTest {

    /**
     * Test method for
     * {@link geometries.Polygon#Polygon(Point3D...)}.
     */
    @Test
    public void testConstructor1() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct concave quadrangular with vertices in correct order
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(-1, 1, 1));
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct polygon");
        }
    }

    @Test
    public void testConstructor() {
        // TC02: Wrong vertices order
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(0, 1, 0),
                    new Point3D(1, 0, 0), new Point3D(-1, 1, 1));
            fail("Constructed a polygon with wrong order of vertices");
        } catch (IllegalArgumentException e) {
        }

        // TC03: Not in the same plane
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 2, 2));
            fail("Constructed a polygon with vertices that are not in the same plane");
        } catch (IllegalArgumentException e) {
        }

        // TC04: Concave quadrangular
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0.5, 0.25, 0.5));
            fail("Constructed a concave polygon");
        } catch (IllegalArgumentException e) {
        }

        // =============== Boundary Values Tests ==================

        // TC10: Vertex on a side of a quadrangular
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0.5, 0.5));
            fail("Constructed a polygon with vertix on a side");
        } catch (IllegalArgumentException e) {
        }

        // TC11: Last point = first point
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0, 1));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {
        }

        // TC12: Colocated points
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 1, 0));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {
        }

    }

    /**
     * Test method for {@link geometries.Polygon#getNormal(primitives.Point3D)}.
     */
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Polygon pl = new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0),
                new Point3D(-1, 1, 1));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals(new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)), "Bad normal to trinagle");
    }

    @Test
    void findIntersections() {
        Polygon Polygon = new Polygon(new Point3D(0,0,0),
                new Point3D(0,4,0),
                new Point3D(4,4,0) ,  new Point3D(4,0,0));
        //===========================================================//
        //===================EP: Three cases:=======================//
        // TC01: Inside Polygon (1 point)
        Ray TC01 = new Ray(new Point3D(1.0,1.0,-1.0), new Vector(0.0,0.0,1.0));
        List<Point3D> resultTC01 = Polygon.findIntersections(TC01);

        assertEquals( 1, resultTC01.size(),"Wrong number of points");

        assertEquals(List.of(new Point3D(1,1,0)), resultTC01, "Ray crosses Polygon");
        // TC021:  Outside against edge (0 point)
        Ray TC021 = new Ray(new Point3D(5.0,2.0,-1.0), new Vector(0.0,0.0,1.0));
        List<Point3D> resultTC021 = Polygon.findIntersections(TC021);

        assertEquals( 0, resultTC021.size(),"Wrong number of points");

        // TC022: Outside against vertex (0 points)
        Ray TC022 = new Ray(new Point3D(5.0,-1.0,-1.0), new Vector(0.0,0.0,1.0));
        List<Point3D> resultTC022 = Polygon.findIntersections(TC022);

        assertEquals( 0, resultTC022.size(),"Wrong number of points");

        //===========================================================//
        //===BVA: Three cases (the ray begins "before" the plane)===//

        // TC11:  On edge (0 points)
        Ray TC11 = new Ray(new Point3D(2.0,4.0,-1.0), new Vector(0.0,0.0,1.0));
        List<Point3D> resultTC11 = Polygon.findIntersections(TC11);

        assertEquals( 0, resultTC11.size(),"Wrong number of points");

        // TC12: In vertex (0 points)
        Ray TC12 = new Ray(new Point3D(0.0,0.0,-1.0), new Vector(0.0,0.0,1.0));
        List<Point3D> resultTC12 = Polygon.findIntersections(TC12);

        assertEquals( 0, resultTC12.size(),"Wrong number of points");

        // TC13: On edge's continuation (0 points)
        Ray TC13 = new Ray(new Point3D(0.0,8.0,-1.0), new Vector(0.0,0.0,1.0));
        List<Point3D> resultTC13 = Polygon.findIntersections(TC13);

        assertEquals( 0, resultTC13.size(),"Wrong number of points");


    }
}

