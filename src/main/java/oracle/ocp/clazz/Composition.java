package oracle.ocp.clazz;

import java.io.IOException;
import java.rmi.AccessException;

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

class Video {
    public void play() throws IOException {
        System.out.println("video play");
    }
}

class Game extends Video {
    public void play() throws IOException {
        super.play();
        System.out.println("game play");
    }

    public static void main(String[] args) {
        try {
            Video video = new Game();
            video.play();
        } catch (Exception e) {}
    }
}
