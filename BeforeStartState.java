/**
 * Write a description of class BeforeStartState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeforeStartState extends GameState {

    public BeforeStartState(GameStateManager gm) {
        super(gm);
    }

    @Override
    public void clickNumber() {
        gameStateManager.setGameCurrentState(GameStates.InitArray);
    }
}
