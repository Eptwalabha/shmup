package src.systems.drawing;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import src.components.*;

/**
 * User: Eptwalabha
 * Date: 11/02/14
 * Time: 00:56
 */
public class DrawHudSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Health> healthComponentMapper;
    @Mapper
    ComponentMapper<Wallet> walletComponentMapper;
    @Mapper
    ComponentMapper<DeathCounter> deathCounterComponentMapper;
    @Mapper
    ComponentMapper<Score> scoreComponentMapper;

    private Graphics graphics;

    public DrawHudSystem(GameContainer gameContainer) {
        super(Aspect.getAspectForAll(Player.class));
        graphics = gameContainer.getGraphics();
    }

    @Override
    protected void process(Entity e) {

        Health health = healthComponentMapper.getSafe(e);
        Wallet wallet = walletComponentMapper.getSafe(e);
        DeathCounter deathCounter = deathCounterComponentMapper.getSafe(e);
        Score score = scoreComponentMapper.getSafe(e);

        // dessine la partie du haut.
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 1024, 70);
        graphics.setColor(Color.white);
        graphics.drawLine(0, 70, 1024, 70);
        graphics.setColor(Color.white);

        long active = world.getEntityManager().getActiveEntityCount();
        long created = world.getEntityManager().getTotalCreated();
        long deleted = world.getEntityManager().getTotalDeleted();
        long added = world.getEntityManager().getTotalAdded();

        graphics.drawString("active  = " + active, 10, 25);
        graphics.drawString("add-del = " + (added - deleted), 10, 45);

        graphics.drawString("created = " + created, 210, 5);
        graphics.drawString("added   = " + added, 210, 25);
        graphics.drawString("deleted = " + deleted, 210, 45);
        graphics.drawString("cre-del = " + (created - deleted), 410, 5);

        graphics.drawString("vie  = " + ((health != null) ? health.getHealth() : "---"), 610, 5);
        graphics.drawString("mort = " + ((deathCounter != null) ? deathCounter.getDeathCounter() : "---"), 610, 25);
        graphics.drawString("coin = " + ((wallet != null) ? wallet.getWalletAmount() : "---"), 610, 45);

        graphics.drawString("score = " + ((score != null) ? score.getScore() : "---"), 810, 5);
        graphics.drawString("max   = " + ((score != null) ? score.getMaxScore() : "---"), 810, 25);
    }
}
