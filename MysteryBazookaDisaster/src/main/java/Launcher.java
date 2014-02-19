import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import src.gamestate.MysteryBazookaDisaster;
import src.gamestate.Pause;

/**
 * User: Eptwalabha
 * Date: 15/02/14
 * Time: 20:56
 */
public class Launcher extends StateBasedGame {

    private long last_frame = System.nanoTime();
    private AppGameContainer container;

    public Launcher() {
        super("Mystery Bazooka Disaster");

    }

    public static void main(String[] arg0) {

        try {
            AppGameContainer app = new AppGameContainer(new Launcher());
            System.out.println("toto");
            app.setDisplayMode(1024, 768, false);
//            app.setTargetFrameRate(120);
            app.setAlwaysRender(true);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {

        if (gameContainer instanceof AppGameContainer)
            this.container = (AppGameContainer) gameContainer;
        container.setShowFPS(true);
        this.addState(new MysteryBazookaDisaster());
        this.addState(new Pause());

    }
}