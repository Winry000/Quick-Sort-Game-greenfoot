/**
 * Write a description of class EndShortMinionState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndShortMinionState extends GameState {
    public EndShortMinionState(GameStateManager gm) {
        super(gm);
    }

    @Override
    public void clickTallMinion() {
        gameStateManager.setGameCurrentState(GameStates.BeforeSwap);
    }
}