package oracle.ocp.clazz;

public class Composition extends Frame implements Drawable{
}

class Canvas implements Drawable {
    public void draw() {
    }
}

abstract class Board extends Canvas {
}

class Paper extends Canvas {
    protected void draw(int color) {
    }
}

class Frame extends Canvas implements Drawable { // this one does not need to implement draw method!
    public void resize() {
    }
}

interface Drawable {
    public abstract void draw();
}

