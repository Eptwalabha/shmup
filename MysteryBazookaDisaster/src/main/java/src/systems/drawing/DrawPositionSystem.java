package src.systems.drawing;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import src.components.Position;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:56
 */
public class DrawPositionSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> positionComponentMapper;

    private Graphics graphics;
    private Circle circle;

    public DrawPositionSystem(GameContainer gameContainer) {
        super(Aspect.getAspectForAll(Position.class));
        graphics = gameContainer.getGraphics();
        circle = new Circle(0,0,10);
    }

    @Override
    protected void process(Entity e) {

        Position position = positionComponentMapper.get(e);

        Position origine = position.getOrigin();


        float positionX = position.getX();
        float positionY = 768 - position.getY();
        graphics.setColor(Color.blue);

        graphics.drawLine(positionX - 5, positionY, positionX + 5, positionY);
        graphics.drawLine(positionX, positionY - 5, positionX, positionY + 5);

        if (origine != null) {

            float origineX = origine.getX();
            float origineY = 768 - origine.getY();

            graphics.setColor(new Color(0f, 1f, 0f, 0.2f));
            graphics.drawLine(positionX, positionY, origineX, origineY);
            graphics.setColor(Color.red);
            circle.setLocation(origineX - 10, origineY - 10);
//            graphics.drawOval(origineX - 10, origineY - 10, 20, 20);
        }
    }
}
