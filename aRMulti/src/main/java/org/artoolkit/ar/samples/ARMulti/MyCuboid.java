package org.artoolkit.ar.samples.ARMulti;

import android.opengl.GLES10;

import org.artoolkit.ar.base.rendering.RenderUtils;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by jafarali on 21/03/2018.
 */

public class MyCuboid{
    private FloatBuffer mVertexBuffer;
    private FloatBuffer mColorBuffer;
    private ByteBuffer mIndexBuffer;

    public MyCuboid() {
        this(1.0F);
    }

    public MyCuboid (float size) {
        this(size, 0.0F, 0.0F, 0.0F);
    }

    public MyCuboid (float size, float x, float y, float z) {
        this.setArrays(size, x, y, z);
    }

    /*
    private void setArrays(float size, float x, float y, float z) {
        float hs = size / 2.0F;
        float[] vertices = new float[]{x - hs, y - hs, z - hs, x + hs, y - hs, z - hs, x + hs, y + hs, z - hs, x - hs, y + hs, z - hs, x - hs, y - hs, z + hs, x + hs, y - hs, z + hs, x + hs, y + hs, z + hs, x - hs, y + hs, z + hs};
        float c = 1.0F;
        //Create color array
        float[] colors = new float[]{0.0F, 0.0F, 0.0F, c, c, 0.0F, 0.0F, c, c, c, 0.0F, c, 0.0F, c, 0.0F, c, 0.0F, 0.0F, c, c, c, 0.0F, c, c, c, c, c, c, 0.0F, c, c, c};
        byte[] indices = new byte[]{0, 4, 5, 0, 5, 1, 1, 5, 6, 1, 6, 2, 2, 6, 7, 2, 7, 3, 3, 7, 4, 3, 4, 0, 4, 7, 6, 4, 6, 5, 3, 0, 1, 3, 1, 2};
        this.mVertexBuffer = RenderUtils.buildFloatBuffer(vertices);

        //updates color buffer
        this.mColorBuffer = RenderUtils.buildFloatBuffer(colors);
        this.mIndexBuffer = RenderUtils.buildByteBuffer(indices);
    }
    */

    //My alternative function for colour manipulation

    private void setArrays(float size, float x, float y, float z) {
        //Declaring float half size
        float hs = size / 2.0F;
        float hq = size / 4.0F;

        //Defining vertices as half sizes away from origin (center point x,y,z)
        //This Cuboid's dimensions: lwh = 4 x 4 x 1

        float[] vertices = new float[]{
                //Back face
                x - hs, y - hs, z - hq, //bottom left
                x + hs, y - hs, z - hq, //bottom right
                x + hs, y + hs, z - hq, //top right
                x - hs, y + hs, z - hq, //top left
                //Front face
                x - hs, y - hs, z + hq, //bottom left
                x + hs, y - hs, z + hq, //bottom right
                x + hs, y + hs, z + hq, //top right
                x - hs, y + hs, z + hq  //top left
        };
        /*Map temperature to "c" value, scaling it down accordingly, assuming float temp = fahrenheit
        float c = SimpleRenderer.temp/ 100F;
        OR

        float c ranges from 0 --> 1.0F? */

        //Create color array, note that all transparency values are 1.0F i.e. fully transparent
        //Colours correspond to vertices in the buffer above
        float[] colors = new float[]{

                0.0F, 0.0F, 0.0F, 1.0F, //White
                1.0F, 1.0F, 0.0F, 1.0F, //Yellow
                1.0F, 0.0F, 0.0F, 1.0F,  //Red
                1.0F, 0.0F, 0.0F, 1.0F, //Red

                0.0F, 0.0F, 0.0F, 1.0F, //White
                1.0F, 0.5F, 0, 1.0F, //Orange
                1.0F, 0.0F, 0.0F, 1.0F, //Red
                1.0F, 0.0F, 0.0F, 1.0F}; //Red

        byte[] indices = new byte[]{
                0, 4, 5,
                0, 5, 1,
                1, 5, 6,
                1, 6, 2,
                2, 6, 7,
                2, 7, 3,
                3, 7, 4,
                3, 4, 0,
                4, 7, 6,
                4, 6, 5,
                3, 0, 1,
                3, 1, 2
        };
        this.mVertexBuffer = RenderUtils.buildFloatBuffer(vertices);

        //updates color buffer
        this.mColorBuffer = RenderUtils.buildFloatBuffer(colors);
        this.mIndexBuffer = RenderUtils.buildByteBuffer(indices);
    }
    public void setTemp(float temp) {

        //Colours correspond to vertices in the buffer above

        float tempFactor = temp/50F; //i.e. this will range from 0.4 to 1
        float[] colors = new float[]{

                tempFactor, 0.0F, 0.0F, 1.0F,
                tempFactor, 0.0F, 0.0F, 1.0F,
                tempFactor, 0.0F, 0.0F, 1.0F,
                tempFactor, 0.0F, 0.0F, 1.0F,

                tempFactor, 0.0F, 0.0F, 1.0F,
                tempFactor, 0.0F, 0.0F, 1.0F,
                tempFactor, 0.0F, 0.0F, 1.0F,
                tempFactor, 0.0F, 0.0F, 1.0F};


        //updates color buffer
        this.mColorBuffer = RenderUtils.buildFloatBuffer(colors);
    }

    public void draw(GL10 unused) {
        GLES10.glColorPointer(4, 5126, 0, this.mColorBuffer);
        GLES10.glVertexPointer(3, 5126, 0, this.mVertexBuffer);
        GLES10.glEnableClientState('聶');
        GLES10.glEnableClientState('聴');
        GLES10.glDrawElements(4, 36, 5121, this.mIndexBuffer);
        GLES10.glDisableClientState('聶');
        GLES10.glDisableClientState('聴');
    }

}
