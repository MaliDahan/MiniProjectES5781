package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

public abstract class RayTracerBase {
    protected final Scene _scene;

    /**
     * constructor
     * @param scene
     */
    public RayTracerBase(Scene scene) {
        _scene = scene;
    }

    /**
     * abstract method
     * @param ray
     * @return color
     */
    public abstract Color traceRay(Ray ray);
}
