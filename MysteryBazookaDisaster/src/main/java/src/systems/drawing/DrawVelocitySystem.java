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
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Shape;
import src.components.Position;
import src.components.Velocity;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:56
 */
public class DrawVelocitySystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> positionComponentMapper;
    @Mapper
    ComponentMapper<Velocity> velocityComponentMapper;

    private Graphics graphics;
    private Shape ligne;
    private Shape cercle;


    public DrawVelocitySystem(GameContainer gameContainer) {
        super(Aspect.getAspectForAll(Position.class, Velocity.class));
        graphics = gameContainer.getGraphics();
        cercle = new Circle(0, 0, 3);
    }

    @Override
    protected void process(Entity e) {

        Position position = positionComponentMapper.get(e);
        Velocity velocity = velocityComponentMapper.get(e);

        float velocityX = velocity.velocityX;
        float velocityY = velocity.velocityY;

        float positionX = position.getX();
        float positionY = 768 - position.getY();

        ligne = new Line(positionX, positionY, positionX + velocityX, positionY - velocityY);

        cercle.setLocation(positionX - 3, positionY - 3);
        graphics.setColor(Color.green);
        graphics.draw(ligne);
        graphics.draw(cercle);
//        graphics.drawLine(positionX, positionY, positionX + velocityX, positionY - velocityY);
//        graphics.drawOval(positionX - 3, positionY - 3, 6, 6);
    }
}
