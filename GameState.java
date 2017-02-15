/**
 * Write a description of class GameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameState implements GameStateInterface{
    GameStateManager gameStateManager;

    public GameState(GameStateManager gm) {
        this.gameStateManager = gm;
    }

    @Override
    public void clickNumber() {
        System.out.println( "Click Number is not valid in " + this.getClass().getName() + " state." );
    }

    @Override
    public void setPivot() {
        System.out.println( "Set Pivot is not valid in " + this.getClass().getName() + " state." );
    }

    @Override
    public void clickShortMinion() {
        System.out.println( "Click ShortMinion is not valid in " + this.getClass().getName() + " state." );
    }

    @Override
    public void clickTallMinion() {
        System.out.println( "Click TallMinion is not valid in " + this.getClass().getName() + " state." );
    }

    @Override
    public void clickSwap() {
        System.out.println( "Click Swap is not valid in " + this.getClass().getName() + " state." );
    }

    @Override
    public void clickDone() {
        System.out.println("Click Done is not valid in " + this.getClass().getName() + " state.");
    }

    @Override
    public void submit() {
        System.out.println( "Submit is not valid in " + this.getClass().getName() + " state." );
    }

    @Override
    public void gotoInitArray() {
        System.out.println("Goto initial state is not valid in " + this.getClass().getName() + " state.");
    }
}
