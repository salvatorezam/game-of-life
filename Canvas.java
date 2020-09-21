public class Canvas {

	public final int TABLE_LENGTH = 160;
	public final int TABLE_HEIGHT = 30;
	public final int NUMBER_OF_NEIGHBORS = 8;
	public final double INVERSE_POPULATION_DENSITY_COEFFICIENT = 6.0;

	public boolean[][] canvas = new boolean[TABLE_HEIGHT][TABLE_LENGTH];

	public int[] horizontal = {1, 1, 0, -1, -1, -1, 0, 1};
	public int[] vertical = {0, -1, -1, -1, 0, 1, 1, 1};

	public void initializeCanvas() {

		int i,j;

		int numberOfInitialAliveCells = (int) (Math.random() * ((TABLE_LENGTH * TABLE_HEIGHT) / INVERSE_POPULATION_DENSITY_COEFFICIENT));

		for (int rowCounter = 0; rowCounter < canvas.length; rowCounter++)
			for (int colCounter = 0; colCounter < canvas[0].length; colCounter++)
				canvas[rowCounter][colCounter] = false;

		for (int k = 0; k < numberOfInitialAliveCells; k++) {
			i = (int) (Math.random() * TABLE_HEIGHT);
			j = (int) (Math.random() * TABLE_LENGTH);
			canvas[i][j] = true;
		}
	}

	public void printCanvas() {

		for (int rowCounter = 0; rowCounter < canvas.length; rowCounter++) {
			for (int colCounter = 0; colCounter < canvas[0].length; colCounter++) {

				if (canvas[rowCounter][colCounter])
					System.out.print("X ");
				else 
					System.out.print(" ");
			}
			System.out.println();
		}

		System.out.println("\n\n\n\n\n\n\n");
	} 
}

//Any live cell with fewer than two live neighbors dies, as if by underpopulation.
//Any live cell with two or three live neighbors lives on to the next generation.
//Any live cell with more than three live neighbors dies, as if by overpopulation.
//Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.