package com.demo.fitbits.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.demo.fitbits.simulator.Direction;
import com.demo.fitbits.simulator.Member;
import com.demo.fitbits.simulator.Pitch;

public class MemberTest {

	Pitch board = null;
	Member member = null;

	@Test
	public void testValidBoardPlacing() {

		// Initialize Board
		board = new Pitch(5, 5);
		member = new Member();

		Throwable e = null;
		try {
			member = new Member(5, 5, Direction.N, board);
			// member.currentPosition();
		} catch (Throwable ex) {
			e = ex;
		}

		assertFalse(e instanceof Exception);
	}

	@Test
	public void testInvalidBoardPlacingXPosition() {

		// Initialize Board
		board = new Pitch(5, 5);
		member = new Member();

		Throwable e = null;
		try {
			member = new Member(7, 5, Direction.N, board);
			// member.currentPosition();
		} catch (Throwable ex) {
			e = ex;
		}

		assertTrue(e instanceof Exception);
	}

	@Test
	public void testInvalidBoardPlacingYPosition() {

		// Initialize Board
		board = new Pitch(5, 5);
		member = new Member();

		Throwable e = null;
		try {
			member = new Member(5, 7, Direction.N, board);
			// member.currentPosition();
		} catch (Throwable ex) {
			e = ex;
		}

		assertTrue(e instanceof Exception);
	}

	@Test
	public void testValidMovement() throws Exception {
		board = new Pitch(5, 5);
		member = new Member(1, 2, Direction.N, board);

		// LM LM LM LMM
		member.turnLeft();
		// member.currentPosition();
		assertEquals(1, member.getCurrentX());
		assertEquals(2, member.getCurrentY());
		assertEquals(Direction.W, member.getCurrentDirection());

		member.move();

		member.turnLeft();
		member.move();
		member.turnLeft();
		member.move();
		member.turnLeft();
		member.move();
		member.move();

		// member.currentPosition();
		assertEquals(1, member.getCurrentX());
		assertEquals(3, member.getCurrentY());
		assertEquals(Direction.N, member.getCurrentDirection());

		member = new Member(3, 3, Direction.E, board);

		// MMR MMR MRRM
		member.move();
		// member.currentPosition();
		assertEquals(4, member.getCurrentX());
		assertEquals(3, member.getCurrentY());
		assertEquals(Direction.E, member.getCurrentDirection());

		member.move();
		// member.currentPosition();
		assertEquals(5, member.getCurrentX());
		assertEquals(3, member.getCurrentY());
		assertEquals(Direction.E, member.getCurrentDirection());

		member.turnRight();
		// member.currentPosition();
		assertEquals(5, member.getCurrentX());
		assertEquals(3, member.getCurrentY());
		assertEquals(Direction.S, member.getCurrentDirection());

		member.move();
		//member.currentPosition();
		assertEquals(5, member.getCurrentX());
		assertEquals(2, member.getCurrentY());
		assertEquals(Direction.S, member.getCurrentDirection());

		member.move();
		assertEquals(5, member.getCurrentX());
		assertEquals(1, member.getCurrentY());
		assertEquals(Direction.S, member.getCurrentDirection());

		member.turnRight();
		assertEquals(5, member.getCurrentX());
		assertEquals(1, member.getCurrentY());
		assertEquals(Direction.W, member.getCurrentDirection());

		member.move();
		assertEquals(4, member.getCurrentX());
		assertEquals(1, member.getCurrentY());
		assertEquals(Direction.W, member.getCurrentDirection());

		member.turnRight();
		assertEquals(4, member.getCurrentX());
		assertEquals(1, member.getCurrentY());
		assertEquals(Direction.N, member.getCurrentDirection());

		member.turnRight();
		assertEquals(4, member.getCurrentX());
		assertEquals(1, member.getCurrentY());
		assertEquals(Direction.E, member.getCurrentDirection());
		member.move();
		assertEquals(5, member.getCurrentX());
		assertEquals(1, member.getCurrentY());
		assertEquals(Direction.E, member.getCurrentDirection());

		//member.currentPosition();

		assertEquals(5, member.getCurrentX());
		assertEquals(1, member.getCurrentY());
		assertEquals(Direction.E, member.getCurrentDirection());

	}
	
	@Test
	public void testWontMoveOffBottomLeftOfField() {
		Throwable e = null;
		board = new Pitch(5, 5);
		try {
			member = new Member(0, 0, Direction.W, board);
			member.move();
			
			member = new Member(0, 0, Direction.S, board);
			member.move();
		} catch (Throwable ex) {
			// TODO Auto-generated catch block
			e = ex;
		}
		assertTrue(e instanceof Exception);
		
	}
	
	@Test
	public void testWontMoveOffBottomRightOfField() {
		Throwable e = null;
		board = new Pitch(5, 5);
		try {
			member = new Member(5, 0, Direction.E, board);
			member.move();
			//member.currentPosition();
			member = new Member(5, 0, Direction.S, board);
			member.move();
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof Exception);
		
	}
	
	@Test
	public void testWontMoveOffTopRightOfField() {
		Throwable e = null;
		board = new Pitch(5, 5);
		try {
			member = new Member(5, 5, Direction.E, board);
			member.move();
			
			member = new Member(5, 5, Direction.N, board);
			member.move();
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof Exception);
		
	}
	
	@Test
	public void testWontMoveOffTopLeftOfField() {
		Throwable e = null;
		board = new Pitch(5, 5);
		try {
			member = new Member(0, 5, Direction.W, board);
			member.move();
			
			member = new Member(0, 5, Direction.N, board);
			member.move();
			
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof Exception);
		
	}
}
