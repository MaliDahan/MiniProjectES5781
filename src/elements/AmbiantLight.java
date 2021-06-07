package elements;

import primitives.Color;

public class AmbientLight {
    private final Color _intensity;

    /**
     * Constructor
     * @param iA intensity color
     * @param kA constant for intensity
     */
    public AmbientLight(Color iA,double kA) {

        _intensity = new Color(iA.scale(kA));
    }

    /**
     * get intensity color
     * @return intensity
     */
    public Color getIntensity() {
        return _intensity;
    }
}

