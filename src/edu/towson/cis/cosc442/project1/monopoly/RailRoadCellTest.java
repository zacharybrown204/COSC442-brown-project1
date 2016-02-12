package edu.towson.cis.cosc442.project1.monopoly;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class RailRoadCellTest.
 */
public class RailRoadCellTest extends TestCase {
	
	/** The game master. */
	GameMaster gameMaster;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardRailRoad());
		gameMaster.setNumberOfPlayers(2);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
	}
	
	/**
	 * Test player action.
	 */
	public void testPlayerAction() {
		RailRoadCell cell =
			(RailRoadCell) gameMaster.getGameBoard().queryCell("Railroad A");
		int cellIndex = gameMaster.getGameBoard().queryCellIndex("Railroad A");
		gameMaster.movePlayer(0, cellIndex);
		gameMaster.getPlayer(0).purchase();
		gameMaster.switchTurn();
		gameMaster.movePlayer(1, cellIndex);
		cell.playAction(null);
		assertEquals(
				1500 - cell.getRent(),
				gameMaster.getPlayer(1).getMoney());
		assertEquals(
				1300 + cell.getRent(),
				gameMaster.getPlayer(0).getMoney());
	}
	
	/**
	 * Test purchase railroad.
	 */
	public void testPurchaseRailroad() {
		assertEquals(0, gameMaster.getPlayer(0).numberOfRR());
		int cellIndex = gameMaster.getGameBoard().queryCellIndex("Railroad A");
		gameMaster.movePlayer(0, cellIndex);
		gameMaster.getPlayer(0).purchase();
		assertEquals(1300, gameMaster.getPlayer(0).getMoney());
		assertEquals(1, gameMaster.getPlayer(0).numberOfRR());
	}

	/**
	 * Test rent.
	 */
	public void testRent() {
		RailRoadCell rr1 =
			(RailRoadCell) gameMaster.getGameBoard().queryCell("Railroad A");
		int cellIndex1 = gameMaster.getGameBoard().queryCellIndex("Railroad A");
		gameMaster.movePlayer(0, cellIndex1);
		gameMaster.getPlayer(0).purchase();
		assertEquals(25, rr1.getRent());

		RailRoadCell rr2 =
			(RailRoadCell) gameMaster.getGameBoard().queryCell("Railroad B");
		int cellIndex2 = gameMaster.getGameBoard().queryCellIndex("Railroad B");
		gameMaster.movePlayer(0, cellIndex2 - cellIndex1);
		gameMaster.getPlayer(0).purchase();
		assertEquals(50, rr1.getRent());
		assertEquals(50, rr2.getRent());
	}
}
