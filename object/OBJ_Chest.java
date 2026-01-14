package object;

import main.GamePanel;

public class OBJ_Chest extends SuperObject {

    GamePanel gp;

    public OBJ_Chest(GamePanel gp) {

        this.gp = gp;

        name = "Chest";
        collision = true;

        try {
            image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/res/objects/chest.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
