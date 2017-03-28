/**
 * Handle Parsing of text file
 * Take each line of file and stuff into arraylist
 * Line 1 is always size of board
 * Line 2 is initial position of member on board
 * Line 3 is Commands 
 * Line 2 and Line 3 are repeated for n times
 */
package com.demo.fitbits.simulator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileParser {

	private Path fFilePath = null;

	private int maxX = 0;
	private int maxY = 0;

	/*
	 * If file exists, accept, else throw IOException
	 */
	public FileParser(String aFileName) throws IOException  {
			URL resourceURL = getClass().getClassLoader().getResource(aFileName);
			if(resourceURL == null)
			    throw new FileNotFoundException(aFileName +"File Doesn't Exist");
				System.out.println("resourceURL:"+resourceURL.getFile());
				setfFilePath(Paths.get(aFileName));
			if (!fFilePath.toFile().exists()) {
				throw new IOException("File Doesn't Exist");
			}
	}

	public List<String> processLineByLine() throws IOException {
		List<String> commandsArrayList = new ArrayList<String>();

		try (Scanner scanner = new Scanner(fFilePath, "UTF-8")) {
			while (scanner.hasNextLine()) {
				String line = processLine(scanner.nextLine());
				commandsArrayList.add(line);
			}
			return commandsArrayList;
		}
	}

	/*
	 * Parse Upper Coordinates of Pitch String to max X and maxY
	 */
	public Pitch parseUpperCoordinatesOfPitch(String coordString)
			throws IOException {

		Pitch pitch = null;
		// Tokenize String by space
		StringTokenizer stringTokenizer = new StringTokenizer(coordString, " ");

		if (stringTokenizer.countTokens() == 2) {
			try {
				setMaxX(Integer.parseInt(stringTokenizer.nextToken()));
				setMaxY(Integer.parseInt(stringTokenizer.nextToken()));
				pitch = new Pitch(maxX, maxY);
			} catch (Exception ex) {
				throw new IOException("Pitch Coordinates Not valid Integer");
			}

		} else {
			throw new IOException("Invalid Pitch Size");
		}
		return pitch;
	}

	/*
	 * Parse Member Coordinates on Pitch String
	 */
	public Member parseMemberCoordinatesOnPitch(String memberCoordinatesString)
			throws IOException {
		
		Member member = new Member();

		StringTokenizer strTkn = new StringTokenizer(memberCoordinatesString,
				" ");
		
		if (strTkn.countTokens() == 3) {
			int x = Integer.parseInt(strTkn.nextToken());
			int y = Integer.parseInt(strTkn.nextToken());

			Direction currentDirection = null;

			String direction = strTkn.nextToken();

			if (direction.equals("N")) {
				currentDirection = Direction.N;

			} else if (direction.equals("E")) {
				currentDirection = Direction.E;

			} else if (direction.equals("S")) {
				currentDirection = Direction.S;

			} else if (direction.equals("W")) {
				currentDirection = Direction.W;
			}else {
				throw new IOException("Invalid Member Cooridnates on Pitch");
			}

			// Create new member
			member.setCurrentX(x);
			member.setCurrentY(y);
			member.setCurrentDirection(currentDirection);

		} else {
			throw new IOException("Invalid Input");
		}
		return member;
	}
	
	
	/*
	 * Check if commands for member are valid
	 */
	public boolean isValidMemberCommands(char[] charDirectionArray) {
		boolean valid = false;
		for (char c: charDirectionArray)
		{
		    valid = ((c == 'L') || (c == 'R')) || ((c == 'M'));

		    if (!valid)
		    {
		        break;
		    }
		}
		return valid;
	}

	
	protected String processLine(String aLine) {
		String line = null;
		// use a second Scanner to parse the content of each line
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter("\n");
		if (scanner.hasNext()) {
			// assumes the line has a certain structure
			line = scanner.next();
			// System.out.println(line);

		} else {
			System.err.println("Empty or invalid line. Unable to process.");
		}
		scanner.close();
		return line;
	}

	public Path getfFilePath() {
		return fFilePath;
	}

	public void setfFilePath(Path fFilePath) {
		this.fFilePath = fFilePath;
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
