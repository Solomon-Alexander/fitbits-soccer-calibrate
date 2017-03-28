package com.demo.fitbits.simulator;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		// Take file input
		// Parse Each line into array of Strings
		FileParser fp = new FileParser(args[0]);
		List<String> commandsArray = fp.processLineByLine();

		// Assume 1st string in array is coordinates
		Pitch board = fp.parseUpperCoordinatesOfPitch(commandsArray.get(0));

		Member member = null;
		char[] directionArray = null;

		// iterate through commands
		for (int i = 1; i < commandsArray.size(); i++) {
			if ((i % 2) == 1) {

				member = fp.parseMemberCoordinatesOnPitch(commandsArray.get(i));
				member.setBoard(board);
				// System.out.println("Intialized Member");
				// member.currentPosition();

			} else if ((i % 2) == 0) { // Parse Series of Instructions
				// System.out.println("Parse Series of Instructions");
				// System.out.println(commandsArray.get(i));
				// Create an array size of number of instructions
				directionArray = commandsArray.get(i).toCharArray();
				if (fp.isValidMemberCommands(directionArray)) {
					moveMember(directionArray, member);
					member.currentPosition();
				}else {
					throw new IOException("Invalid Member Directions");
				}

			}
		}

	}

	public static void moveMember(char[] directionArray, Member member)
			throws Exception {

		// Iterate character array and move the member
		for (int i = 0; i < directionArray.length; i++) {

			// Turn Left
			if (directionArray[i] == 'L') {
				member.turnLeft();
			} else if (directionArray[i] == 'M') {
				member.move();
			} else if (directionArray[i] == 'R') {
				member.turnRight();
			}
		}
	}

}
