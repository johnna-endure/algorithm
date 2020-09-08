package backjoon.implementation.p3190.snake;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

	@Test
	public void clockwiseRotateTest(){
		assertThat(Direction.UP.rotate("D")).isEqualTo(Direction.RIGHT);
		assertThat(Direction.RIGHT.rotate("D")).isEqualTo(Direction.DOWN);
		assertThat(Direction.DOWN.rotate("D")).isEqualTo(Direction.LEFT);
		assertThat(Direction.LEFT.rotate("D")).isEqualTo(Direction.UP);
	}
	@Test
	public void counterClockwiseRotateTest(){
		assertThat(Direction.UP.rotate("L")).isEqualTo(Direction.LEFT);
		assertThat(Direction.RIGHT.rotate("L")).isEqualTo(Direction.UP);
		assertThat(Direction.DOWN.rotate("L")).isEqualTo(Direction.RIGHT);
		assertThat(Direction.LEFT.rotate("L")).isEqualTo(Direction.DOWN);
	}


}
enum Direction {
	UP, RIGHT, DOWN, LEFT;

	public Direction rotate(String turn) {
		Direction[] clockwise = {UP, RIGHT, DOWN, LEFT};
		//시계 방향인 경우
		if(turn.equals("D")) {
			int mod = (this.ordinal()+1)%4;
			return clockwise[mod];
		}
		//반시계 방향인 경우
		else {
			int mod = this.ordinal()-1 < 0 ? this.ordinal()+3 : this.ordinal()-1;
			return clockwise[mod];
		}
	}
}
