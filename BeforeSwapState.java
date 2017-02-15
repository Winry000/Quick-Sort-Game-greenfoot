/**
 * Write a description of class BeforeSwapState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeforeSwapState extends GameState{
    public BeforeSwapState(GameStateManager gm) {
        super(gm);
    }

    @Override
    public void clickSwap() {
        gameStateManager.setGameCurrentState(GameStates.PivotInit);
    }

    @Override
    public void clickDone() {
        gameStateManager.setGameCurrentState(GameStates.DoneState);
    }
}
