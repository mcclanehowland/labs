/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
        System.out.println("selection shuffle");
        int[] values3 = {0, 1, 2, 3};
        for(int i = 0; i < values3.length;i++) {
            System.out.print(values3[i]+" ");
        }
        selectionShuffle(values3);
        System.out.println();
        for(int i = 0; i < values3.length;i++) {
            System.out.print(values3[i]+" ");
        }
        System.out.println("flipping a coin");
        for(int i = 0; i < 15; i++) {
            System.out.print(flip()+" ");
        }
        System.out.println();
        
        int[] values4 = {1,2,3,4};
        int[] values5 = {4,3,2,1};
        System.out.println("are permutations?");
        System.out.println(arePermutations(values4,values5));



	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
        int[] shuffled = new int[values.length];
        int k = 0;
        for(int j = 0; j < (values.length+1)/2;j++) {
            shuffled[k] = values[j];
            k+=2;
        }
        k = 1;
        for(int j =  (values.length+1)/2;j < values.length;j++) {
            shuffled[k] = values[j];
            k+=2;
        }
        for(int i = 0; i < shuffled.length;i++) {
            values[i] = shuffled[i];
        }
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
        for(int i = values.length-1; i > 0; i--) {
            int swap = (int)(Math.random()*i);
            int temp = values[i];
            values[i] = values[swap];
            values[swap] = temp;
        }
	}
    public static String flip() {
        if(Math.random() > 1.0/3.0) {
            return "heads";
        }
        return "tails";
    }
    public static boolean arePermutations(int[] values1,int[] values2) {
        int count = 0;
        for(int i = 0; i < values1.length-1;i++) {
            for(int j = i+1; j < values1.length;j++) {
                if(values1[j] < values1[i]) {
                    int temp = values1[i];
                    values1[i] = values1[j];
                    values1[j] = temp;
                }
                if(values2[j] < values2[i]) {
                    int temp = values2[i];
                    values2[i] = values2[j];
                    values2[j] = temp;
                }
            }
        }
        for(int i = 0; i < values1.length;i++) {
            if(values1[i] != values2[i]) {
                return false;
            }
        }
        return true;

    }
}
