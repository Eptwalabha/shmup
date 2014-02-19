package src.systems.drawing;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import org.newdawn.slick.Image;
import src.components.*;

/**
 * User: Eptwalabha
 * Date: 07/02/14
 * Time: 10:41
 */
public class DrawTextureSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> positionComponentMapper;
    @Mapper
    ComponentMapper<Texture> textureComponentMapper;
    @Mapper
    ComponentMapper<Scaling> scalingComponentMapper;
    @Mapper
    ComponentMapper<Vanish> vanishComponentMapper;
    @Mapper
    ComponentMapper<Rotating> rotatingComponentMapper;

    public DrawTextureSystem() {
        super(Aspect.getAspectForAll(Position.class, Texture.class));
    }

    @Override
    protected void process(Entity e) {

        Position p = positionComponentMapper.get(e);
        Texture t = textureComponentMapper.get(e);
        Vanish v = vanishComponentMapper.getSafe(e);
        Scaling s = scalingComponentMapper.getSafe(e);
        Rotating r = rotatingComponentMapper.getSafe(e);

        Image im;

        if (s != null)
            im = t.getTexture(s.getScale());
        else
            im = t.getTexture();

        if (r != null)
            im.rotate(r.getDegree() % 360f);

        if (v != null)
            im.setAlpha(v.getPercentVanished());

        im.draw(p.getX() - im.getWidth() / 2f , 768 - p.getY() - im.getHeight() / 2f);

    }
}
