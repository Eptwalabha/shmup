package src.systems.drawing;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import src.components.DrawHealthBar;
import src.components.Health;
import src.components.Position;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 19:41
 */
public class  DrawHealthBarSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Health> healthComponentMapper;
    @Mapper
    ComponentMapper<Position> positionComponentMapper;

    private Graphics graphics;

    public DrawHealthBarSystem(GameContainer graphics) {
        super(Aspect.getAspectForAll(Health.class, Position.class, DrawHealthBar.class));
        this.graphics = graphics.getGraphics();
    }

    @Override
    protected void process(Entity e) {

        Health h = healthComponentMapper.get(e);
        Position p = positionComponentMapper.get(e);

        float percent = h.getPercentHealth();
        percent = percent > 0 ? percent : 0f;
        percent = percent > 1 ? 1f : percent;

        graphics.setColor(Color.white);
        graphics.fillRect(p.getX() - 105, 768 - (p.getY() + 105), 210, 20);
        graphics.setColor(Color.red);
        graphics.fillRect(p.getX() - 100, 768 - (p.getY() + 100), 200, 10);
        graphics.setColor(Color.green);
        graphics.fillRect(p.getX() - 100, 768 - (p.getY() + 100), percent * 200, 10);
        graphics.setColor(Color.black);
        graphics.drawRect(p.getX() - 105, 768 - (p.getY() + 105), 210, 20);
        graphics.drawRect(p.getX() - 100, 768 - (p.getY() + 100), 200, 10);

        graphics.setColor(Color.white);
        graphics.drawString("" + (int) h.getHealth(), p.getX() - 105, 768 - (p.getY() + 125));
    }
}
