package src.systems.drawing;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import src.components.Position;
import src.components.Shadow;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:56
 */
public class CastShadowSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> positionComponentMapper;
    @Mapper
    ComponentMapper<Shadow> shadowComponentMapper;

    private Graphics graphics;
    private Position camera;

    public CastShadowSystem(GameContainer gameContainer) {
        super(Aspect.getAspectForAll(Shadow.class, Position.class));
        graphics = gameContainer.getGraphics();
    }

    @Override
    protected void process(Entity e) {
        Position p = positionComponentMapper.get(e);
        Shadow s = shadowComponentMapper.get(e);


        graphics.setColor(new Color(.5f, .5f, .5f, .5f));
        float percent = 1.1f - (p.getY() - 100f) / 600f * .9f;
        graphics.fillOval(p.getX() - s.getWidth() / 2f, 768 - (p.getOrigin().getY() + 75), s.getWidth() * percent, s.getHeight() * percent);
    }

    public void setCamera(Position camera) {
        this.camera = camera;
    }
}
