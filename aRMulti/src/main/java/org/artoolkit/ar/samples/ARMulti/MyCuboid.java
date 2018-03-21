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

    private void setColour (float size, float x, float y, float z, float temp) {
        float hs = size / 2.0F;
        float[] vertices = new float[]{x - hs, y - hs, z - hs, x + hs, y - hs, z - hs, x + hs, y + hs, z - hs, x - hs, y + hs, z - hs, x - hs, y - hs, z + hs, x + hs, y - hs, z + hs, x + hs, y + hs, z + hs, x - hs, y + hs, z + hs};

        //Map temperature to "c" value, scaling it down accordingly, assuming float temp = fahrenheit
        float c = temp / 100F;
        //Create color array, note that all transparency values are 1.0F
        float[] colors = new float[]{0.0F, 0.0F, 0.0F, 1.0F, c, 0.0F, 0.0F, 1.0F, c, c, 0.0F, 1.0F, 0.0F, c, 0.0F, 1.0F, 0.0F, 0.0F, c, 1.0F, c, 0.0F, c, 1.0F, c, c, c, 1.0F, 0.0F, c, c, 1.0F};
        byte[] indices = new byte[]{0, 4, 5, 0, 5, 1, 1, 5, 6, 1, 6, 2, 2, 6, 7, 2, 7, 3, 3, 7, 4, 3, 4, 0, 4, 7, 6, 4, 6, 5, 3, 0, 1, 3, 1, 2};
        this.mVertexBuffer = RenderUtils.buildFloatBuffer(vertices);

        //updates color buffer
        this.mColorBuffer = RenderUtils.buildFloatBuffer(colors);
        this.mIndexBuffer = RenderUtils.buildByteBuffer(indices);
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
