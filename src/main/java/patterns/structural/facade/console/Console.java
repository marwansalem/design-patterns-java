package patterns.structural.facade.console;

import java.util.ArrayList;
import java.util.List;

public class Console {
    private List<Viewport> viewports = new ArrayList<>();
    private int width;
    private int height;

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addViewport(Viewport viewport) {
        viewports.add(viewport);
    }

    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                for(Viewport vp: viewports) {
                    System.out.print(vp.charAt(x, y));
                }
            }
            System.out.println();
        }
    }

    public static Console newConsole(int width, int height) {
        Buffer buffer = new Buffer(width, height);
        Viewport viewport = new Viewport(buffer, width, height, 0, 0);
        Console console = new Console(width, height);
        console.addViewport(viewport);
        return console;
    }

    // to create a console you need to do a lot of low levels steps
    // including setting up buffers for viewports
    public static void main(String[] args) {
        Buffer buffer = new Buffer(30, 20);
        Viewport viewport = new Viewport(buffer, 30, 20, 0, 0);
        Console console = new Console(30, 20);
        console.addViewport(viewport);
        console.render();

        // using factory method 

        Console console2 = newConsole(30, 20);
        console2.render();

    }
}
