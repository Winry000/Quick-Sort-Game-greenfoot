/**
 * Write a description of class PivotInitState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PivotInitState extends GameState {
    public PivotInitState (GameStateManager gm) {
        super(gm);
    }

    @Override
    public void clickShortMinion() {
        gameStateManager.setGameCurrentState(GameStates.EndShortMinion);
    }

    @Override
    public void clickTallMinion() {
        gameStateManager.setGameCurrentState(GameStates.EndTallMinion);
    }
}

