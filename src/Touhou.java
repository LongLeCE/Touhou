import tklibs.SpriteUtils;
public class Touhou {
//    public void calculate() {
//    }
    public static void main(String[] args) {
//        Techkids instance = new Techkids();
//        instance.calculate();
        GameWindow window = new GameWindow(384, 800, 384, 600);
        long currentNano = 0;
        while (true) {
            if (window.canvas.ran) {
                currentNano = System.nanoTime();
//                currentNano = window.canvas.currentNano;
                window.canvas.ran = false;
            }
//            if (GameWindow.isLeftPress && !GameWindow.isRightPress) {
//                if (!window.canvas.player.url.equals("assets/images/players/left/0.png")) {
//                    window.canvas.player.url = "assets/images/players/left/0.png";
//                    window.canvas.player.image = SpriteUtils.loadImage(window.canvas.player.url);
//                    window.canvas.player.resize(window.getWidth() - 16, window.getHeight() - 39);
//                }
//            }
//            else if (GameWindow.isRightPress && !GameWindow.isLeftPress) {
//                if (!window.canvas.player.url.equals("assets/images/players/right/0.png")) {
//                    window.canvas.player.url = "assets/images/players/right/0.png";
//                    window.canvas.player.image = SpriteUtils.loadImage(window.canvas.player.url);
//                    window.canvas.player.resize(window.getWidth() - 16, window.getHeight() - 39);
//                }
//            }
//            else if (!window.canvas.player.url.equals("assets/images/players/straight/0.png")) {
//                window.canvas.player.url = "assets/images/players/straight/0.png";
//                window.canvas.player.image = SpriteUtils.loadImage(window.canvas.player.url);
//                window.canvas.player.resize(window.getWidth() - 16, window.getHeight() - 39);
//            }
            if (window.getWidth() - 16 != window.canvas.background.windowWidth || window.getHeight() - 39 != window.canvas.background.windowHeight) {
                window.canvas.background.resize(window.getWidth() - 16, window.getHeight() - 39);
                window.canvas.player.resize(window.getWidth() - 16, window.getHeight() - 39);
            }
//            }
            window.canvas.run(currentNano);
        }
    }
}
