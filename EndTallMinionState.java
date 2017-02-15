/**
 * Write a description of class EndTallMinionState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndTallMinionState extends GameState {
    public EndTallMinionState(GameStateManager gm) {
        super(gm);
    }

    @Override
    public void clickShortMinion() {
        gameStateManager.setGameCurrentState(GameStates.BeforeSwap);
    }
}
