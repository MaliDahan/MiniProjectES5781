package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public abstract class Tube  extends RadialGeometry{
    public Ray RT;
    public Tube(Ray MRT){
        super();

        RT= MRT;

    }



    public Ray getRT() {
        return RT;

    }

    @Override
    public String toString() {
        return "Tube{" +
                "RT=" + RT +
                '}';
    }



    public Vector getNormal(Point3D p) {
        return null;
    }


}

