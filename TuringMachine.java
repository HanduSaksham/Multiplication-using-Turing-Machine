//8 1 1 0 1 1 1 0 -1
//6  1 1 0 1 1 0
//9 1 1 1 1 0 1 1 1 0 
//13 1 1 1 1 1 1 0 1 1 1 1 1 0

//8 1 1 1 1 0 1 1 1

package javaProject;

import java.util.ArrayList;
import java.util.Scanner;

//multiplication of two numbers using TURING MACHINE

/*
 	
 	Blank represents -1  
  
 */

public class TuringMachine {

	// variables declaration

	public ArrayList<Integer> tape = new ArrayList<>();

	private int count = 0;

	private int index = 0;

	private int output = 0;

	// this function sets the arraylist all element to -1
	private void setArray() {

		for (int i = 0; i < 100; i++) {

			tape.add(-1);

		}

	}

	// this function calculates the sum of two numbers
	private void summation() {

		int pointer = 0;

		while (true) {

			if (tape.get(pointer) == 1) {

				pointer++;

			} else if (tape.get(pointer) == 0) {

				tape.set(pointer, 1);
				pointer++;

			} else if (tape.get(pointer) == -1) {

				pointer--;
				tape.set(pointer, -1);
				break;

			}

		}

	}

	// this function is used to take the input from the user
	private void getInput() {

		Scanner scn = new Scanner(System.in);

		count = scn.nextInt();

		for (int i = 0; i < count; i++) {

			tape.set(i, scn.nextInt());

		}

	}

	// these below function are states in the automata of the turing machine
	void q0() {


		if (tape.get(index) == 1) {

			tape.set(index, -1);
			index++;
			q1();

		} else if (tape.get(index) == 0) {

			tape.set(index, -1);
			index++;

			q9();
			//System.out.println("EXIT");

		}

	}

	public void q1() {


		while (true) {

			if (tape.get(index) == 1) {
				index++;
			}

			else if (tape.get(index) == 0) {

				index++;
				q2();
				break;

			}

		}

	}

	// loop one
	void q2() {


		while (true) {

			if (tape.get(index) == 1) {

				tape.set(index, -1);
				index++;
				q3();
				break;
			}
			// -1 condition
			// 0 condition

			if (tape.get(index) == 0) {

				index--;
				//System.out.println(index + "q2");
				q7();
				break;

			}
		}
	}

	void q3() {


		while (true) {

			if (tape.get(index) == 1) {

				index++;

			}

			else if (tape.get(index) == 0) {

				index++;
				q4();
				break;

			}

		}

	}

	void q4() {


		while (true) {

			if (tape.get(index) == -1) {

				tape.set(index, 1);
				index--;
				//System.out.println(index + "q4");
				q5();
				break;
			}

			else if (tape.get(index) == 1) {

				index++;

			}
		}

	}

	void q5() {


		while (true) {

			if (tape.get(index) == 1) {

				index--;
				//System.out.println(index);

			} else if (tape.get(index) == 0) {

				index--;
				//System.out.println(index + "q5");
				q6();
				break;

			}

		}

	}

	void q6() {


		while (true) {
			if (tape.get(index) == 1) {

				index--;
				//System.out.println(index + "q6");

			} else if (tape.get(index) == -1) {

				tape.set(index, -1);
				index++;
				q2();
				break;
			}
		}

	}

	void q7() {


		while (true) {

			//System.out.println(tape.toString());

			if (tape.get(index) == -1) {

				tape.set(index, 1);
				index--;
				//System.out.println(index + "q7");

			}

			else if (tape.get(index) == 0) {

				index--;
				//System.out.println(index + "q7");
				q8();
				break;

			}

		}

	}

	void q8() {


		while (true) {

			if (tape.get(index) == 1) {

				index--;
				//System.out.println(index + "q8");

			} else if (tape.get(index) == -1) {

				//System.out.println(tape.toString());

				index++;
				q0();
				break;

			}

		}

	}

	// this function cleans garbage by assigning -1 to non-output digits
	void q9() {


		while (true) {

			if (tape.get(index) == 1) {

				tape.set(index, -1);
				index++;

			}
			if (tape.get(index) == 0) {

				tape.set(index, -1);
				index++;
				break;
			}

		}

	}

	//this function is used to count the number of ones the arraylist
	void getOnesCount() {

		for (int i = 0; i < tape.size(); i++) {

			if (tape.get(i) == 1)
				output++;
		}

	}

	public static void main(String args[]) {


		TuringMachine tm = new TuringMachine();

		tm.setArray();
		tm.getInput();

		// summation of two numbers
		// tm.summation();

		// multiplication of two numbers using TURING MACHINE
		tm.q0();
		System.out.println("The Output TAPE is given below ");
		System.out.println(tm.tape.toString());
		
		System.out.println("The Output given by TAPE is given below ");
		tm.getOnesCount();
		System.out.println(tm.output);

	}

	
}
