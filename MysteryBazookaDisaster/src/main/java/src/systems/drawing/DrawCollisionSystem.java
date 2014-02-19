package src.systems.drawing;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import src.components.HitBox;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 19:41
 */
public class DrawCollisionSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<HitBox> collisionBoxComponentMapper;

    private Graphics graphics;
    private Shape collision;

    public DrawCollisionSystem(GameContainer graphics) {
        super(Aspect.getAspectForAll(HitBox.class));
        this.graphics = graphics.getGraphics();
        collision = new Rectangle(0, 0, 0, 0);
    }

    @Override
    protected void process(Entity e) {
        HitBox c = collisionBoxComponentMapper.get(e);

        graphics.setColor(Color.red);
        graphics.setLineWidth(2);
        collision = new Rectangle(c.getLeft(), 768 - c.getTop(), c.getWidth(), c.getHeight());
        graphics.draw(collision);
//        graphics.drawRect(c.getLeft(), 768 - c.getTop(), c.getWidth(), c.getHeight());
    }
}
