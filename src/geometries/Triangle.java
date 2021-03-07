package geometries;

import primitives.Point3D;

public class Triangle extends Polygon {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Triangle)) return false;

        Triangle tr = (Triangle) obj;


        return vertices.get(0).equals(tr.vertices.get(0)) &&
                vertices.get(1).equals(tr.vertices.get(1)) &&
                vertices.get(2).equals(tr.vertices.get(2));
    }


    @Override
    public String toString() {
        String result = "";
        for (Point3D p : vertices ) {
            result += p.toString();
        }
        return  result;
    }

    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        super(new Point3D[]{p1, p2, p3});
    }
}