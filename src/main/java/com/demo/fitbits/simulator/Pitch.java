/*
 * A board object
 */
package com.demo.fitbits.simulator;

public class Pitch {
	private int minX = 0;
	private int minY = 0;
	private int maxX = 0;
	private int maxY = 0;
	
	public Pitch(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	/*
	 * Check if position on board is valid
	 * 
	 * @return True if valid position
	 */
	public boolean isValidPosition(int x, int y) {
		if (x > maxX || x < minX) {
			return false;
		}
		
		if (y > maxY || y < minY) {
			return false;
		}
		
		return true;
	}
	
	// Getters and Setters
	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
}
