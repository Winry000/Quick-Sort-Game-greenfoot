/**
 * Write a description of class InitArrayState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitArrayState extends GameState{
    public InitArrayState(GameStateManager gm) {
        super(gm);
    }

    @Override
    public void setPivot() {
        gameStateManager.setGameCurrentState(GameStates.PivotInit);
    }
}
