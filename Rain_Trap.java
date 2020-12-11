public class Rain_Trap{
	/**
	 * The run time complexity is O(n), where n is the length of received heights array. This is because the
	 * 'while' loop goes through the whole array once. The space complexity is O(1),
	 * because there is a constant amount of variables.
	 * 
	 * @param heights is the array of heights to store water in.
	 * @return sumWater is the sum of all the water volume stored in the heights
	 *         water container.
	 */
	public static int waterVolume(int[] heights) {
		int i = 0; // left index
		int j = heights.length - 1; // right index
		int maxL = heights[i]; // max height on left side of array
		int maxR = heights[j]; // max height on right side of array
		int sumWater = 0;
		// Go through array from both sides until left meets right = until went through
		// all cells = heights.length = n, run time complexity of this loop is O(n)
		while (i < j) {
			// Choose shorter max height to know the other side traps all the water this
			// side stores. Then go through array either .
			if (maxL < maxR) {
				i++; // move towards middle
				// If water can be stored in this height, add to sumWater otherwise update max
				// height
				if (heights[i] < maxL) {
					sumWater += maxL - heights[i]; // height difference = amount of water stored above heights[i]
				} else {
					maxL = heights[i];
				}
			} else {
				j--;
				if (heights[j] < maxR) {
					sumWater += maxR - heights[j];
				} else {
					maxR = heights[j];
				}
			}
		}
		return sumWater;
	}
}