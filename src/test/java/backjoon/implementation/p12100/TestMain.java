package backjoon.implementation.p12100;

import org.junit.Test;

import java.util.Arrays;

public class TestMain {
	Main main = new Main();
	int[][] board = {
			{2,0,2},
			{2,0,2},
			{4,0,4}
	};

	@Test
	public void scanOneColumnTest() {
		System.out.println(Main.scanOneColumn(0, true, board));
		System.out.println(Main.scanOneColumn(0, false, board));
	}

	@Test
	public void scanOneRowTest(){
		System.out.println(Main.scanOneRow(0, true, board));
		System.out.println(Main.scanOneRow(0, false, board));
	}

	@Test
	public void updateOneColumnTest() {
		int max = Main.updateOneColumn(0, true, Arrays.asList(10,11,12), board);
		System.out.println(max);

		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

		max = Main.updateOneColumn(0, false, Arrays.asList(10,11,12), board);
		System.out.println(max);

		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}

	@Test
	public void updateOneRowTest() {
		int max = Main.updateOneRow(0, true, Arrays.asList(10,11,12), board);
		System.out.println(max);

		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

		max = Main.updateOneRow(0, false, Arrays.asList(10,11,12), board);
		System.out.println(max);

		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}

	@Test
	public void testMove() {
		int max = Main.move(0, board);
		max = Main.move(0, board);
		max = Main.move(2, board);
		System.out.println(max);

		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}


}
