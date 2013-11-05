/**
 * 
 * This class was created to contain a single function that will value of the Nth term of a 
 *   Fibonacci Sequence.  We could use recursion but the challenge specifically asked for a, 
 *   singular, function.
 *   
 * @author Kevin Pichelman - kevin@pichelman.com
 * @since Nov 5, 2013
 */
public class FibMain {

/**
 * main - returns the value of the Nth term of a Fibonacci Sequence
 * 
 * @param args - Nth term in the Fibonacci Sequence 
 */
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.print("Missings argument, please enter a number between 0 and 100,000");	
		} else if (args.length > 1) {
			System.out.print("Too many arguments, please enter a number between 0 and 100,000");
		} else {
			long startTime = System.currentTimeMillis();
			int nthTerm = 0;
			try {
				nthTerm = Integer.parseInt(args[0]);
			} catch (Exception ex) {
				System.out.print("Invalid argument, please enter a number between 0 and 100,000");
			}
			
			if (nthTerm == 0) { 
				System.out.print("The value of the 0 term in the Fibonacci Sequnce is 0");
			} else if (nthTerm == 1) {
				System.out.print("The value of the 1 term in the Fibonacci Sequnce is 1");
			} else if (nthTerm < 47) { // 47th term's value's is 1134903170+1836311903 which is greater than 2^31-1 so we must use something other than an int.
				int result = 1;
				int previousInteger = 1;
				int previousPreviousInteger = 0;
				StringBuffer seq = new StringBuffer("0,1,");
				for (int i = 3; i < nthTerm; i++) {
					previousPreviousInteger = previousInteger;
					previousInteger = result;
					seq.append(previousInteger + ",");
					result = previousPreviousInteger + previousInteger;
					
					if (result < 0) {
						System.out.print("We have a value larger than what a primative can hold at term " + i + ".\n" +
								"Results will be incorrect.\n");
						nthTerm = i;
						break;
					}
				}
				seq.append(result);
				System.out.print("The value of the " + nthTerm + " term in the Fibonacci Sequnce is " + result + "\n");
				System.out.print("Fibonacci Sequnce to term " + nthTerm + " is: " + seq + "\n");
				System.out.print("Process time (in millieconds): " + (System.currentTimeMillis() - startTime));
 			} else if (nthTerm < 93) { // 93rd term's value is 4660046610375530309 + 7540113804746346429 which is greater than 2^64-1 so we must use something other than a long
				//lets try longs!
				long result = 1;
				long previousInteger = 1;
				long previousPreviousInteger = 0;
				StringBuffer seq = new StringBuffer("0,1,");
				for (int i = 3; i < nthTerm; i++) {
					previousPreviousInteger = previousInteger;
					previousInteger = result;
					seq.append(previousInteger + ",");
					result = previousPreviousInteger + previousInteger;
					
					if (result < 0) {
						System.out.print("We have a value larger than what a primative can hold at term " + i + ".\n" +
								"Results will be incorrect.\n");
						nthTerm = i;
						break;
					}
				}
				seq.append(result);
				System.out.print("The value of the " + nthTerm + " term in the Fibonacci Sequnce is " + result + "\n");
				System.out.print("Fibonacci Sequnce to term " + nthTerm + " is: " + seq + "\n");
				System.out.print("Process time (in millieconds): " + (System.currentTimeMillis() - startTime));

			} else {
				//finally, use java.math.BigIntegers
				java.math.BigInteger result = new java.math.BigInteger("1");
				java.math.BigInteger previousInteger = new java.math.BigInteger("1");
				java.math.BigInteger previousPreviousInteger = new java.math.BigInteger("0");

				StringBuffer seq = new StringBuffer("0,1,");
				for (int i = 3; i < nthTerm; i++) {
					previousPreviousInteger = previousInteger;
					previousInteger = result;
					seq.append(previousInteger + ",");
					result = previousPreviousInteger.add(previousInteger);
				}
				seq.append(result);
				System.out.print("The value of the " + nthTerm + " term in the Fibonacci Sequnce is " + result + "\n");
				//This is just annoying because its so long...
				//System.out.print("Fibonacci Sequnce to term " + nthTerm + " is: " + seq + "\n");
				System.out.print("Process time (in millieconds): " + (System.currentTimeMillis() - startTime));
			}
		}
	}
}