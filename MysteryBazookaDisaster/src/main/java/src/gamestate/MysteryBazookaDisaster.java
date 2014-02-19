package src.gamestate;

import com.artemis.ComponentType;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;
import src.Constant;
import src.components.Position;
import src.entities.EntityFactory;
import src.systems.*;
import src.systems.drawing.*;
import src.utils.SpriteGUI;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 09:03
 */
public class MysteryBazookaDisaster extends BasicGameState implements InputListener {

    private SpriteGUI sprites;
    private World world;
    private Entity player;
    private long nextLevelTime = 10000;
    private int level = 0;
    private SpawnMissilesSystem spawnMissilesSystem;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        sprites = new SpriteGUI("images/miscellaneous/sprites.png", 12, 1);

        world = new World();
        world.setManager(new GroupManager());

        InputListenerSystem inputListenerSystem = new InputListenerSystem(gameContainer.getInput());
        world.setSystem(inputListenerSystem);
        world.setSystem(new TriggerWarningSystem(sprites));
        world.setSystem(new GravitySystem());
        world.setSystem(new VelocitySystem());
        world.setSystem(new ZigZagSystem());
        world.setSystem(new CollisionSystem(sprites));
        world.setSystem(new LockSystem());
        spawnMissilesSystem = new SpawnMissilesSystem(1000, sprites);
        world.setSystem(spawnMissilesSystem);
        world.setSystem(new SpawnCoinSystem(10000, sprites));
        world.setSystem(new HealSystem(500));
        world.setSystem(new SmokeSystem(sprites));
        world.setSystem(new ExplodeSystem(sprites));
        DeleteEntityOutOfScreen deleteEntityOutOfScreen = new DeleteEntityOutOfScreen();
        world.setSystem(deleteEntityOutOfScreen);
        world.setSystem(new LifeSpanSystem());
        world.setSystem(new RespawnSystem(5000));
        world.setSystem(new FireSystem(sprites));

        world.setSystem(new SetDeltaEntitySystem(), false);
        world.setSystem(new DrawTextureSystem(), false);
        CastShadowSystem castShadowSystem = new CastShadowSystem(gameContainer);
        world.setSystem(castShadowSystem, false);
        world.setSystem(new DrawHealthBarSystem(gameContainer), false);
        world.setSystem(new DrawNotificationSystem(gameContainer), false);
        world.setSystem(new DrawHudSystem(gameContainer), false);
        world.setSystem(new DeleteEntitySystem(), false);

        world.setSystem(new DrawPositionSystem(gameContainer), false);
        world.setSystem(new DrawCollisionSystem(gameContainer), false);
        world.setSystem(new DrawVelocitySystem(gameContainer), false);

        world.initialize();

        Position worldPosition = new Position(0f, 0f);
        player = EntityFactory.createPlayer(world, worldPosition, sprites);
        player.addToWorld();
        player.changedInWorld();
        Position camera = (Position) player.getComponent(ComponentType.getTypeFor(Position.class));

        deleteEntityOutOfScreen.setCamera(camera);
        castShadowSystem.setCamera(camera);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        nextLevelTime -= delta;
        if (nextLevelTime < 0) {
            nextLevelTime += 5000;
            level++;
            float newInterval = 1000 - level * 50;
            newInterval = (newInterval < 100) ? 100 : newInterval;
            world.deleteSystem(spawnMissilesSystem);
            spawnMissilesSystem = spawnMissilesSystem.changeInterval(newInterval);
            world.setSystem(spawnMissilesSystem);
        }
        world.setDelta(delta);
        world.getSystem(SetDeltaEntitySystem.class).process();
        world.getSystem(DeleteEntitySystem.class).process();
        world.process();

        if (gameContainer.getInput().isKeyPressed(Input.KEY_ESCAPE))
            stateBasedGame.enterState(Constant.BasicGameStateID.PAUSE, new FadeOutTransition(), new FadeInTransition());
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        world.getSystem(DrawTextureSystem.class).process();
        world.getSystem(DrawHealthBarSystem.class).process();
        world.getSystem(CastShadowSystem.class).process();
        world.getSystem(DrawNotificationSystem.class).process();
        world.getSystem(DrawHudSystem.class).process();

//        world.getSystem(DrawCollisionSystem.class).process();
//        world.getSystem(DrawPositionSystem.class).process();
//        world.getSystem(DrawVelocitySystem.class).process();

        gameContainer.getGraphics().drawString("level = " + level + ", time left = " + nextLevelTime, 20, 700);
    }

    @Override
    public int getID() {
        return Constant.BasicGameStateID.GAME;
    }
}
