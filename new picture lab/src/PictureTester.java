import javax.swing.*;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("src/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("src/caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("src/temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("src/640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("src/swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  public static void testEdgeDetection2(){
      Picture swan = new Picture("src/swan.jpg");
      swan.edgedetection2(10);
      swan.explore();
  }

  public static void testKeepOnlyBlue(){
      Picture beach = new Picture("src/beach.jpg");
      beach.explore();
      beach.keepOnlyBlue();
      beach.explore();
  }

  public static void testKeepOnlyGreen(){
      Picture beach = new Picture("src/beach.jpg");
      beach.explore();
      beach.keepOnlyGreen();
      beach.explore();
  }

  public static void testKeepOnlyRed(){
      Picture beach = new Picture("src/beach.jpg");
      beach.explore();
      beach.keepOnlyRed();
      beach.explore();
  }

  public static void testNegate(){
      Picture beach = new Picture("src/beach.jpg");
      beach.explore();
      beach.negate();
      beach.explore();
  }

  public static void testGrayscale(){
      Picture beach = new Picture("src/beach.jpg");
      beach.explore();
      beach.grayscale();
      beach.explore();
  }

  public static void testFixUnderwater(){
    Picture beach = new Picture("src/water.jpg");
    beach.explore();
    beach.fixunderwater();
    beach.explore();
  }

  public static void testMirrorRighttoLeft(){
      Picture mirror = new Picture("src/caterpillar.jpg");
      mirror.explore();
      mirror.mirrorverticalrighttoleft();
      mirror.explore();
  }

  public static void testMirrorHorizontal(){
      Picture temple = new Picture("src/caterpillar.jpg");
      temple.explore();
      temple.mirrohorizontal();
      temple.explore();
  }

  public static void testMirrorHorizontalBotToTop(){
      Picture mirror = new Picture("src/caterpillar.jpg");
      mirror.explore();
      mirror.mirrohorizontalbotottop();
      mirror.explore();
  }

  public static void testMirrorDiagonal(){
      Picture mirror = new Picture("src/mypicture.jpg");
      mirror.explore();
      mirror.mirrordiagonal();
      mirror.explore();
  }

  public static void testMirrorArms(){
      Picture mirror = new Picture("src/snowman.jpg");
      mirror.explore();
      mirror.mirrorarms();
      mirror.explore();
  }

  public static void testMirrorGull(){
      Picture mirror = new Picture("src/seagull.jpg");
      mirror.explore();
      mirror.mirrorarms();
      mirror.explore();
  }

  public static void testCopy(){
      Picture copy = new Picture("src/mypicture.jpg");

  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//    testZeroBlue();
//    testKeepOnlyBlue();
//    testKeepOnlyRed();
//    testKeepOnlyGreen();
//    testNegate();
//    testGrayscale();
//    testFixUnderwater();
//    testMirrorVertical();
//    testMirrorTemple();
//    testMirrorRighttoLeft();
//    testMirrorVertical();
//    testMirrorHorizontal();
//    testMirrorHorizontalBotToTop();
//    testMirrorArms();
//    testMirrorGull();
//    testMirrorDiagonal();
//    testMirrorTemple();
//    testCollage();
    testCopy();
//    testEdgeDetection();
//    testEdgeDetection2();
//    testChromakey();
//    testEncodeAndDecode();
//    testGetCountRedOverValue(250);
//    testSetRedToHalfValueInTopHalf();
//    testClearBlueOverValue(200);
//    testGetAverageForColumn(0);
  }
}