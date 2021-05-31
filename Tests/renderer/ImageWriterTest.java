package renderer;

import org.junit.jupiter.api.Test;
import primitives.Color;

import static org.junit.jupiter.api.Assertions.*;

class ImageWriterTest {

    @Test
    public void writeToImageTest() {
        ImageWriter imageWriter = new ImageWriter("bluebay", 800, 500 ); //x=long, y=large
        Color blue = new Color(0,0,255);
        for (int i=0; i< imageWriter.getNy();i++){
            for (int j=0; j< imageWriter.getNx(); j++){
                imageWriter.writePixel(j,i,blue);
            }
        }
        imageWriter.writeToImage();
    }
}