package primitives;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

/**
 * Unit tests for primitives.Vector class
 * @author Mali
 */


public class VectorTest extends Object {

    Vector v1 = new Vector(1, 2, 3);
    Vector v2 = new Vector(-2, -4, -6);
    @Test
    void testZeroPoint(){
        try { // test zero vector
            new Vector(0, 0, 0);
            fail("ERROR: zero vector does not throw an exception");
        } catch (IllegalArgumentException e) {
            out.println("good: zero vector cannot exist");
        }
    }
    /**
     * Test method for vector add()
     */
    @Test
    public void add() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);

        Vector v2 = new Vector(-1.0, -1.0, -1.5);
        v1 = new Vector(1.0, 1.0, 1.0);

        v2 = new Vector(-1.0, -1.0, -1.5);



        v1=v1.add(v2);

        assertEquals(new Vector(0.0,0.0,-0.5),v1);



        v2 = v2.add(v1);

        assertEquals(new Vector(-1.0, -1.0, -2.0),v2);
    }
    /**
     * Test method for vector subtract()
     */

    @Test
    void subtract() { Vector v1 = new Vector(1.0, 1.0, 1.0);

        Vector v2 = new Vector(-1.0, -1.0, -1.5);
        v1 = new Vector(1.0, 1.0, 1.0);
        v2 = new Vector(-1.0, -1.0, -1.5);
        v1=v1.subtract(v2);
        assertEquals(new Vector (2.0,2.0,2.5),v1);
        v2=v2.subtract(v1);
        assertEquals(new Vector (-3.0,-3.0,-4.0),v2);
    }
    /**
     * Test method for vector scale()
     */
    @Test
    void scale() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);

        v1=v1.scale(1);
        assertEquals(new Vector(1.0,1.0,1.0),v1);
        v1=v1.scale(2);
        assertEquals(new Vector(2.0,2.0,2.0),v1);
        v1=v1.scale(-2);
        assertEquals(new Vector(-4.0,-4.0,-4.0),v1);
        try{
            v1= v1.scale(0.0);
        } catch (IllegalArgumentException e){
            System.out.println("can't be zero");
            assertTrue(true);
        }
    }
    /**
     * Test method for vector dotProduct()
     */
    @Test
    void dotProduct() {
        Vector v1 = new Vector(3.5, -5.0, 10.0);
        Vector v2 = new Vector(2.5,7,0.5);

        double x1 = v1.dotProduct(v2);

        assertEquals( -21.25,x1);
    }
    /**
     * Test method for vector crossProduct()
     */
    @Test
    void crossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);

        // ============ Equivalence Partitions Tests ==============
        Vector v3 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v3);

        // Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
        assertEquals( v1.length() * v3.length(), vr.length(), 0.00001,"crossProduct() wrong result length");

        // Test cross-product result orthogonality to its operands
        assertTrue( isZero(vr.dotProduct(v1)),"crossProduct() result is not orthogonal to 1st operand");
        assertTrue( isZero(vr.dotProduct(v3)),"crossProduct() result is not orthogonal to 2nd operand");

        // =============== Boundary Values Tests ==================
        // test zero vector from cross-productof co-lined vectors
        try {
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {}

    }

    @Test
    void lengthSquared() {
        if (!isZero(v1.lengthSquared() - 14))
            fail("ERROR: lengthSquared() wrong value");
    }
    /**
     * Test method for vector length()
     */
    @Test
    void length() {
        double result=new Vector(0, 3, 4).length();
        assertTrue(isZero(result-5),"ERROR: length() wrong value");
    }

    @Test
    void normalize() {
    }
    /**
     * Test method for vector normalized()
     */
    @Test
    void normalized() {
        Vector v = new Vector(3.5, -5, 10);

        v.normalize();

        assertEquals(1, v.length(), 1e-10);


        try {

            Vector v1 = new Vector(0, 0, 0);

            v.normalize();

            fail("Vector (0,0,0) not valid");

        }

        catch  (IllegalArgumentException e)

        {

            assertTrue(e.getMessage()!= null);
            assertTrue(true);

        }
    }
}