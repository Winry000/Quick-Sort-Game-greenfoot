/**
 * Write a description of class GameStateManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameStateManager  
{
    private GameStateInterface currentState;
    private GameStateInterface beforeStart;
    private GameStateInterface initArray;
    private GameStateInterface pivotInit;
    private GameStateInterface endShortMinion;
    private GameStateInterface endTallMinion;
    private GameStateInterface beforeSwap;
    private GameStateInterface doneState;
    private GameStateInterface endState;
    private static GameStateManager instance;

    public GameStateManager() {
        this.beforeStart = new BeforeStartState(this);
        this.initArray = new InitArrayState(this);
        this.pivotInit = new PivotInitState(this);
        this.endShortMinion = new EndShortMinionState(this);
        this.endTallMinion = new EndTallMinionState(this);
        this.beforeSwap = new BeforeSwapState(this);
        this.doneState = new DoneGameState(this);
        this.endState = new EndGameState(this);
        this.currentState = this.beforeStart;
    }

    public static GameStateManager getInstance() {
        if (instance == null) {
            instance = new GameStateManager();
        }
        return instance;
    }

    public void doClickNumber() {
        System.out.println( "click one of the number 5 8 or 10...");
        currentState.clickNumber();
    }

    public void doSetPivot() {
        System.out.println( "set pivot...");
        currentState.setPivot();
    }

    public void doClickShortMinion() {
        System.out.println( "click shortMinion...");
        currentState.clickShortMinion();
    }

    public void doClickTallMinion() {
        System.out.println( "click tallMinion...");
        currentState.clickTallMinion();
    }

    public void doClickSwap() {
        System.out.println( "click swap...");
        currentState.clickSwap();
    }

    public void doClickDone() {
        System.out.println("click done...");
        currentState.clickDone();
    }

    public void doClickSubmit() {
        System.out.println("click submit...");
        currentState.submit();
    }

    public void doGotoInitArray() {
        System.out.println("goto initial array...");
        currentState.gotoInitArray();
    }

    /**
     * transfer state from GameStateInterface to GameStates(enum)
     *
     * @return
     */
    public GameStates getGameCurrentState() {
        GameStates result = null;
        switch(this.currentState.getClass().getName()) {
            case "BeforeStartState": result = GameStates.BeforeStart; break;
            case "InitArrayState": result = GameStates.InitArray; break;
            case "PivotInitState": result = GameStates.PivotInit; break;
            case "EndShortMinionState": result = GameStates.EndShortMinion; break;
            case "EndTallMinionState": result = GameStates.EndTallMinion; break;
            case "BeforeSwapState": result = GameStates.BeforeSwap; break;
            case "DoneGameState": result = GameStates.DoneState; break;
            case "EndGameState": result = GameStates.EndGame; break;
            default: break;
        }
        return result;
    }

    public void setGameCurrentState(GameStates cState) {
        switch (cState) {
            case BeforeStart: this.currentState = this.beforeStart; break;
            case InitArray: this.currentState = this.initArray; break;
            case PivotInit: this.currentState = this.pivotInit; break;
            case EndShortMinion: this.currentState = this.endShortMinion; break;
            case EndTallMinion: this.currentState = this.endTallMinion; break;
            case BeforeSwap: this.currentState = this.beforeSwap; break;
            case DoneState: this.currentState = this.doneState; break;
            case EndGame: this.currentState = this.endState; break;
        }
    }
    
    public void showGameCurrentState() {
        GameStates result = null;
        switch(this.currentState.getClass().getName()) {
            case "BeforeStartState": result = GameStates.BeforeStart; break;
            case "InitArrayState": result = GameStates.InitArray; break;
            case "PivotInitState": result = GameStates.PivotInit; break;
            case "EndShortMinionState": result = GameStates.EndShortMinion; break;
            case "EndTallMinionState": result = GameStates.EndTallMinion; break;
            case "BeforeSwapState": result = GameStates.BeforeSwap; break;
            case "DoneGameState": result = GameStates.DoneState; break;
            case "EndGameState": result = GameStates.EndGame; break;
            default: break;
        }
        System.out.println("Current State is " + result.toString());
    }

    public void reset() {
        System.out.println( "go to the initial state...");
        this.currentState = this.beforeStart;
    }
}
