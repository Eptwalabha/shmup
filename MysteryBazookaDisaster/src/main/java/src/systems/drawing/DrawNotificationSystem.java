package src.systems.drawing;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import src.components.Position;
import src.components.TextToDraw;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 20:25
 */
public class DrawNotificationSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<TextToDraw> textToDrawComponentMapper;
    @Mapper
    ComponentMapper<Position> positionComponentMapper;

    private final Graphics graphics;

    public DrawNotificationSystem(GameContainer gameContainer) {
        super (Aspect.getAspectForAll(TextToDraw.class));
        this.graphics = gameContainer.getGraphics();
    }

    @Override
    protected void process(Entity e) {

        TextToDraw t = textToDrawComponentMapper.get(e);
        Position p = positionComponentMapper.get(e);

        if (p == null)
            p = new Position(0f, 0f);

        graphics.setColor(t.getColor());
        graphics.drawString(t.getText(), p.getX(), 768 - p.getY());
    }
}
