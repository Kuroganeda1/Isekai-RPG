package object;

public class OBJ_Chest extends SuperObject {

    public OBJ_Chest() {

        name = "Chest";
        collision = true;

        try {
            image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/res/objects/chest.png"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
