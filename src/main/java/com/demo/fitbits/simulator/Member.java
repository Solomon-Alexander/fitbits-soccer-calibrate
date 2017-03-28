package com.demo.fitbits.simulator;

public class Member {
	
	private int currentX;
	private int currentY;
	private Direction currentDirection;
	private Pitch board;
	
    public Member() {
    }
    
    public Member(int x, int y, Direction direction, Pitch board) throws Exception {
    	this.setBoard(board);
    	if (board.isValidPosition(x, y)) {
    		this.setCurrentX(x);
        	this.setCurrentY(y);
        	this.setCurrentDirection(direction);	
    	}else {
    		throw new Exception("Invalid Board Position");
    	}
    }

    
    public boolean move() throws Exception {
    	
    	if (currentDirection == Direction.N) {
    		
    		if (board.isValidPosition(currentX, (currentY + 1))){
    			// increment y 
        		currentY++;	
        		return true;
    		}else {
    			throw new Exception("Invalid Board Position");
    		}
    		
    	}
    	
    	if (currentDirection == Direction.E) {
    		
    		if (board.isValidPosition((currentX + 1), currentY)){ 
    			// increment x 
        		currentX++;
        		return true;
    		}else {
    			throw new Exception("Invalid Board Position");
    		}
    		
    		
    	}
    	
    	if (currentDirection == Direction.S) {
    		if (board.isValidPosition(currentX, (currentY - 1))){ 
    			 
        		currentY--;	
        		return true;
    		}else {
    			throw new Exception("Invalid Board Position");
    		}
    	}
    	
    	if (currentDirection == Direction.W) {
    		if (board.isValidPosition(currentX-1, currentY)){ 
        		currentX--;	
        		return true;
    		}else {
    			throw new Exception("Invalid Board Position");
    		}
    	}
    	
    	return true;
    }
       
    public void turnLeft() {
    	if (currentDirection == Direction.N) {
    		currentDirection = Direction.W;
    		return;
    	}
    	
    	if (currentDirection == Direction.S) {
    		currentDirection = Direction.E;
    		return;
    	}
    	
    	if (currentDirection == Direction.E) {
    		currentDirection = Direction.N;
    		return;
    	}
    	
    	if (currentDirection == Direction.W) {
    		currentDirection = Direction.S;
    		return;
    	}
    	
    }
    
    public void turnRight() {
    	
    	if (currentDirection == Direction.N) {
    		currentDirection = Direction.E;
    		return;
    	}
    	
    	if (currentDirection == Direction.S) {
    		currentDirection = Direction.W;
    		return;
    	}
    	
    	if (currentDirection == Direction.E) {
    		currentDirection = Direction.S;
    		return;
    	}
    	
    	if (currentDirection == Direction.W) {
    		currentDirection = Direction.N;
    		return;
    	}
    }
    
    public void currentPosition() {
    	System.out.println(currentX + " " + currentY + " " + currentDirection);
    }
    
    // Getters and Setters
	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

	public Pitch getBoard() {
		return board;
	}

	public void setBoard(Pitch board) {
		this.board = board;
	}
}