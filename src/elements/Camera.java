package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

public class Camera {
    private Point3D _p0;
    private Vector _vUP;
    private Vector _vTO;
    private Vector _vRIGHT;
    private double _width;
    private double _height;
    private double _distance;

    public Camera(Point3D p0, Vector vUP, Vector vTO) {
        _p0 = p0;
        _vUP = vUP.normalized();
        _vTO = vTO.normalized();
        if (!isZero(_vTO.dotProduct(_vUP))){
            throw new IllegalArgumentException("vUP is not orthogonal to vTO");
        }
        _vRIGHT= _vTO.crossProduct(_vUP);
    }

    public Point3D getP0() {
        return _p0;
    }

    public Vector getvUP() {
        return _vUP;
    }

    public Vector getvTO() {
        return _vTO;
    }

    public Vector getvRIGHT() {
        return _vRIGHT;
    }

    /**
     *
     * @param width
     * @param height
     * @return
     */
    public Camera setViewPlaneSize(double width, double height){
        _height=height;
        _width=width;
        return this;
    }

    public Camera setDistance(double distance){
        _distance=distance;
        return this;
    }

    /**
     *
     * @param nX
     * @param nY
     * @param j columns
     * @param i lines
     * @return
     */
    public Ray constructRayThroughPixel(int nX, int nY, int j, int i){
        Point3D Pc= _p0.add(_vTO.scale(_distance));

        double Ry= _height/nY;
        double Rx= _width/nX;
        double Yi= -(i-(nY-1)/2)*Ry;
        double Xj= (i-(nX-1)/2)*Rx;
        Point3D Pij= Pc.add(_vRIGHT.scale(Xj).add(_vUP.scale(Yi)));

        if (! isZero(Xj))
        {
            Vector w=_vRIGHT.scale(Xj);
            Pij = Pij.add(w);
        }
        if (! isZero(Yi))
        {
            Vector u=_vUP.scale(-Yi);
            Pij = Pij.add(u);
        }

        Vector Vij=Pij.subtract(_p0);

        return new Ray(_p0,Vij);

    }
}
