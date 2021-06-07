package renderer;

import elements.Camera;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

import java.util.List;
import java.util.MissingResourceException;

public class Render {
    private ImageWriter _imageWriter = null;
    private Scene _scene = null;
    private Camera _camera = null;
    private RayTracerBase _rayTracerBase = null;

    public Render setImageWriter(ImageWriter imageWriter) {
        _imageWriter = imageWriter;
        return this;
    }

    public Render setScene(Scene scene) {
        _scene = scene;
        return this;
    }

    public Render setCamera(Camera camera) {
        _camera = camera;
        return this;
    }

    public Render setRayTracer(RayTracerBasic rayTracerBasic) {
        _rayTracerBase = rayTracerBasic;
        return this;
    }

    public void renderImage() {
        //rendering the image
        int nX = _imageWriter.getNx();
        int nY = _imageWriter.getNy();
        for (int i = 0; i < nY; i++) {
            Color color = null;
            for (int j = 0; j < nX; j++) {
                Ray ray = _camera.constructRayThroughPixel(nX, nY, j, i);
                Color Color = _rayTracerBase.traceRay(ray);
                _imageWriter.writePixel(j, i, color);
            }
        }
    }

    public void printGrid ( int interval, primitives.Color intervalColor){
        int nX = _imageWriter.getNx();
        int nY = _imageWriter.getNy();
        for (int i = 0; i < nY; i++) {
            for (int j = 0; j < nX; j++) {
                if (i % interval == 0 || j % interval == 0) {
                    _imageWriter.writePixel(j, i, intervalColor);
                }
            }
        }
    }
    public void writeToImage () {
        _imageWriter.writeToImage();
    }
  }
