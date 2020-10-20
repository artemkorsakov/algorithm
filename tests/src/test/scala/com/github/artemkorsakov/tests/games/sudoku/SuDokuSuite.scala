package com.github.artemkorsakov.tests.games.sudoku

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class SuDokuSuite extends AnyFunSuiteLike {
  test("test") {
    1 shouldBe 1
  }
}

/*
    @Test
    public void testTemp() {
        SuDoku suDoku = new SuDoku("003020600\n" +
                "900305001\n" +
                "001806400\n" +
                "008102900\n" +
                "700000008\n" +
                "006708200\n" +
                "002609500\n" +
                "800203009\n" +
                "005010300");
        int[][] result = suDoku.getResult();
        Assert.assertEquals(result[0], new int[]{4, 8, 3, 9, 2, 1, 6, 5, 7});
        Assert.assertEquals(result[1], new int[]{9, 6, 7, 3, 4, 5, 8, 2, 1});
        Assert.assertEquals(result[2], new int[]{2, 5, 1, 8, 7, 6, 4, 9, 3});
        Assert.assertEquals(result[3], new int[]{5, 4, 8, 1, 3, 2, 9, 7, 6});
        Assert.assertEquals(result[4], new int[]{7, 2, 9, 5, 6, 4, 1, 3, 8});
        Assert.assertEquals(result[5], new int[]{1, 3, 6, 7, 9, 8, 2, 4, 5});
        Assert.assertEquals(result[6], new int[]{3, 7, 2, 6, 8, 9, 5, 1, 4});
        Assert.assertEquals(result[7], new int[]{8, 1, 4, 2, 5, 3, 7, 6, 9});
        Assert.assertEquals(result[8], new int[]{6, 9, 5, 4, 1, 7, 3, 8, 2});
    }
 */
