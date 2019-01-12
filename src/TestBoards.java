public class TestBoards {

    public Board test0 = new Board(); //Start position
    public Board test1 = new Board(); //empty board
    public Board test2 = new Board();
    public Board test3 = new Board();
    public Board test4 = new Board();
    public Board test5 = new Board();
    public Board test6 = new Board();
    public Board test7 = new Board();
    public Board test8 = new Board();

    TestBoards() {
        //test0
        test0.changeWhitePiece(8, true, 1, 1);
        test0.changeWhitePiece(9, true, 2, 1);
        test0.changeWhitePiece(10, true, 3, 1);
        test0.changeWhitePiece(11, true, 4, 1);
        test0.changeWhitePiece(12, true, 5, 1);
        test0.changeWhitePiece(13, true, 6, 1);
        test0.changeWhitePiece(14, true, 7, 1);
        test0.changeWhitePiece(15, true, 8, 1);

        test0.changeBlackPiece(8, true, 1, 8);
        test0.changeBlackPiece(9, true, 2, 8);
        test0.changeBlackPiece(10, true, 3, 8);
        test0.changeBlackPiece(11, true, 4, 8);
        test0.changeBlackPiece(12, true, 5, 8);
        test0.changeBlackPiece(13, true, 6, 8);
        test0.changeBlackPiece(14, true, 7, 8);
        test0.changeBlackPiece(15, true, 8, 8);

        //test1
        test1.changeWhitePiece(0, false, 1, 2);
        test1.changeWhitePiece(1, false, 2, 2);
        test1.changeWhitePiece(2, false, 3, 2);
        test1.changeWhitePiece(3, false, 4, 2);
        test1.changeWhitePiece(4, false, 5, 2);
        test1.changeWhitePiece(5, false, 6, 2);
        test1.changeWhitePiece(6, false, 7, 2);
        test1.changeWhitePiece(7, false, 8, 2);
        test1.changeWhitePiece(8, true, 2, 1);
        test1.changeWhitePiece(9, false, 2, 1);
        test1.changeWhitePiece(10, false, 3, 1);
        test1.changeWhitePiece(11, false, 4, 1);
        test1.changeWhitePiece(12, true, 5, 1);
        test1.changeWhitePiece(13, false, 6, 1);
        test1.changeWhitePiece(14, false, 7, 1);
        test1.changeWhitePiece(15, true, 7, 1);

        test1.changeBlackPiece(0, false, 1, 7);
        test1.changeBlackPiece(1, false, 2, 7);
        test1.changeBlackPiece(2, false, 3, 7);
        test1.changeBlackPiece(3, false, 4, 7);
        test1.changeBlackPiece(4, false, 5, 7);
        test1.changeBlackPiece(5, false, 6, 7);
        test1.changeBlackPiece(6, false, 7, 7);
        test1.changeBlackPiece(7, false, 8, 7);
        test1.changeBlackPiece(8, true, 1, 8);
        test1.changeBlackPiece(9, false, 2, 7);
        test1.changeBlackPiece(10, false, 3, 7);
        test1.changeBlackPiece(11, false, 4, 7);
        test1.changeBlackPiece(12, true, 5, 8);
        test1.changeBlackPiece(13, false, 6, 7);
        test1.changeBlackPiece(14, false, 7, 7);
        test1.changeBlackPiece(15, true, 8, 8);

        //test2
        test2.changeWhitePiece(8, false, 1, 1);
        test2.changeWhitePiece(9, false, 2, 2);
        test2.changeWhitePiece(10, false, 3, 2);
        test2.changeWhitePiece(11, false, 4, 2);
        test2.changeWhitePiece(12, false, 5, 1);
        test2.changeWhitePiece(13, false, 6, 2);
        test2.changeWhitePiece(14, false, 7, 2);
        test2.changeWhitePiece(15, false, 8, 1);

        test2.changeBlackPiece(0, false, 1, 8);
        test2.changeBlackPiece(1, false, 2, 7);
        test2.changeBlackPiece(2, false, 3, 7);
        test2.changeBlackPiece(3, false, 4, 7);
        test2.changeBlackPiece(4, false, 2, 7);
        test2.changeBlackPiece(5, false, 3, 7);
        test2.changeBlackPiece(6, false, 4, 7);

        test2.changeBlackPiece(8, false, 1, 8);
        test2.changeBlackPiece(9, false, 2, 7);
        test2.changeBlackPiece(10, false, 3, 7);
        test2.changeBlackPiece(11, false, 4, 7);
        test2.changeBlackPiece(12, true, 5, 8);
        test2.changeBlackPiece(13, false, 6, 7);
        test2.changeBlackPiece(14, false, 7, 7);
        test2.changeBlackPiece(15, false, 8, 8);


        //test3
        test3.changeWhitePiece(0, true, 1, 2);
        test3.changeWhitePiece(1, true, 2, 2);
        test3.changeWhitePiece(2, true, 3, 2);
        test3.changeWhitePiece(3, false, 4, 2);
        test3.changeWhitePiece(4, false, 5, 2);
        test3.changeWhitePiece(5, false, 6, 2);
        test3.changeWhitePiece(6, false, 7, 2);
        test3.changeWhitePiece(7, false, 8, 2);
        test3.changeWhitePiece(8, false, 2, 1);
        test3.changeWhitePiece(9, false, 2, 2);
        test3.changeWhitePiece(10, false, 3, 2);
        test3.changeWhitePiece(11, false, 4, 2);
        test3.changeWhitePiece(12, false, 5, 1);
        test3.changeWhitePiece(13, false, 6, 2);
        test3.changeWhitePiece(14, false, 7, 2);
        test3.changeWhitePiece(15, false, 7, 1);

        test3.changeBlackPiece(0, false, 1, 7);
        test3.changeBlackPiece(1, false, 2, 7);
        test3.changeBlackPiece(2, false, 3, 7);
        test3.changeBlackPiece(3, false, 4, 7);
        test3.changeBlackPiece(4, false, 5, 7);
        test3.changeBlackPiece(5, false, 6, 7);
        test3.changeBlackPiece(6, false, 7, 7);
        test3.changeBlackPiece(7, false, 8, 7);
        test3.changeBlackPiece(8, false, 1, 8);
        test3.changeBlackPiece(9, true, 2, 7);
        test3.changeBlackPiece(10, false, 3, 7);
        test3.changeBlackPiece(11, false, 4, 7);
        test3.changeBlackPiece(12, true, 5, 8);
        test3.changeBlackPiece(13, false, 6, 7);
        test3.changeBlackPiece(14, true, 7, 7);
        test3.changeBlackPiece(15, false, 8, 8);

        //test4
        test4.changeWhitePiece(0, true, 1, 3);
        test4.changeWhitePiece(1, true, 2, 4);
        test4.changeWhitePiece(2, true, 3, 5);
        test4.changeWhitePiece(3, true, 4, 4);
        test4.changeWhitePiece(4, true, 5, 4);
        test4.changeWhitePiece(5, true, 6, 3);
        test4.changeWhitePiece(6, true, 7, 5);
        test4.changeWhitePiece(7, true, 8, 4);

        test4.changeBlackPiece(0, true, 1, 4);
        test4.changeBlackPiece(1, true, 2, 5);
        test4.changeBlackPiece(2, true, 3, 6);
        test4.changeBlackPiece(3, true, 4, 5);
        test4.changeBlackPiece(4, true, 5, 6);
        test4.changeBlackPiece(5, true, 6, 5);
        test4.changeBlackPiece(6, true, 7, 6);
        test4.changeBlackPiece(7, true, 8, 5);

        //test5
        test5.changeWhitePiece(0, true, 1, 3);
        test5.changeWhitePiece(1, true, 2, 4);
        test5.changeWhitePiece(2, true, 3, 5);
        test5.changeWhitePiece(3, true, 4, 4);
        test5.changeWhitePiece(4, true, 5, 4);
        test5.changeWhitePiece(5, true, 6, 3);
        test5.changeWhitePiece(6, true, 7, 5);
        test5.changeWhitePiece(7, false, 8, 4);

        test5.changeBlackPiece(0, true, 1, 4);
        test5.changeBlackPiece(1, true, 2, 5);
        test5.changeBlackPiece(2, true, 3, 6);
        test5.changeBlackPiece(3, true, 4, 5);
        test5.changeBlackPiece(4, true, 5, 6);
        test5.changeBlackPiece(5, true, 6, 5);
        test5.changeBlackPiece(6, true, 7, 6);
        test5.changeBlackPiece(7, true, 8, 2);

        //test6
        test6.changeWhitePiece(0, true, 1, 2);
        test6.changeWhitePiece(1, true, 2, 3);
        test6.changeWhitePiece(2, true, 3, 4);
        test6.changeWhitePiece(3, true, 4, 4);
        test6.changeWhitePiece(4, true, 5, 4);
        test6.changeWhitePiece(5, true, 6, 2);
        test6.changeWhitePiece(6, true, 7, 2);
        test6.changeWhitePiece(7, false, 8, 3);

        test6.changeBlackPiece(0, true, 1, 4);
        test6.changeBlackPiece(1, false, 2, 5);
        test6.changeBlackPiece(2, true, 3, 7);
        test6.changeBlackPiece(3, true, 4, 7);
        test6.changeBlackPiece(4, true, 5, 7);
        test6.changeBlackPiece(5, true, 6, 5);
        test6.changeBlackPiece(6, true, 7, 6);
        test6.changeBlackPiece(7, true, 8, 4);

        //test7 - for testing correctness of MAIN ALGORYTHM
        test7.changeWhitePiece(0, false, 1, 2);
        test7.changeWhitePiece(1, false, 2, 2);
        test7.changeWhitePiece(2, false, 3, 2);
        test7.changeWhitePiece(3, true, 4, 2);
        test7.changeWhitePiece(4, true, 5, 4);
        test7.changeWhitePiece(5, false, 6, 2);
        test7.changeWhitePiece(6, false, 7, 2);
        test7.changeWhitePiece(7, false, 8, 2);

        test7.changeBlackPiece(0, true, 1, 6);
        test7.changeBlackPiece(1, false, 2, 7);
        test7.changeBlackPiece(2, false, 3, 7);
        test7.changeBlackPiece(3, false, 4, 7);
        test7.changeBlackPiece(4, true, 5, 5);
        test7.changeBlackPiece(5, false, 6, 7);
        test7.changeBlackPiece(6, false, 7, 7);
        test7.changeBlackPiece(7, false, 8, 7);

        //test8
        test8.changeWhitePiece(0, true, 1, 2);
        test8.changeWhitePiece(1, true, 2, 2);
        test8.changeWhitePiece(2, true, 3, 2);
        test8.changeWhitePiece(3, true, 4, 2);
        test8.changeWhitePiece(4, true, 5, 2);
        test8.changeWhitePiece(5, true, 6, 2);
        test8.changeWhitePiece(6, true, 7, 2);
        test8.changeWhitePiece(7, false, 8, 2);
        test8.changeWhitePiece(8, false, 2, 1);
        test8.changeWhitePiece(9, false, 2, 1);
        test8.changeWhitePiece(10, false, 3, 1);
        test8.changeWhitePiece(11, false, 4, 1);
        test8.changeWhitePiece(12, false, 5, 1);
        test8.changeWhitePiece(13, false, 6, 1);
        test8.changeWhitePiece(14, false, 7, 1);
        test8.changeWhitePiece(15, false, 7, 1);

        test8.changeBlackPiece(0, true, 1, 4);
        test8.changeBlackPiece(1, true, 2, 4);
        test8.changeBlackPiece(2, true, 3, 4);
        test8.changeBlackPiece(3, true, 4, 4);
        test8.changeBlackPiece(4, true, 5, 4);
        test8.changeBlackPiece(5, true, 6, 4);
        test8.changeBlackPiece(6, false, 7, 7);
        test8.changeBlackPiece(7, false, 8, 7);
        test8.changeBlackPiece(8, false, 1, 8);
        test8.changeBlackPiece(9, false, 2, 7);
        test8.changeBlackPiece(10, false, 3, 7);
        test8.changeBlackPiece(11, false, 4, 7);
        test8.changeBlackPiece(12, false, 5, 8);
        test8.changeBlackPiece(13, false, 6, 7);
        test8.changeBlackPiece(14, false, 7, 7);
        test8.changeBlackPiece(15, false, 8, 8);


    }


}
