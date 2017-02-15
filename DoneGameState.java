/**
 * Write a description of class DoneGameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoneGameState extends GameState {
    public DoneGameState(GameStateManager gm) {
        super(gm);
    }

    @Override
    public void submit() {
        gameStateManager.setGameCurrentState(GameStates.EndGame);
    }

    @Override
    public void gotoInitArray() {
        gameStateManager.setGameCurrentState(GameStates.InitArray);
    }
}
