/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage
 *
 *  @author:Prithish Balakrishnan
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) {
        collageDimension = 4;
        tileDimension = 100;
        original = new Picture(filename);
        collage = new Picture(tileDimension*collageDimension,tileDimension*collageDimension);
        for(int i = 0; i <tileDimension*collageDimension; i++){
            for(int j = 0; j< tileDimension*collageDimension; j++){
                int scol = i * original.width() / (tileDimension*collageDimension);
                int srow = j * original.height() / (tileDimension*collageDimension);
                Color color = original.get(scol,srow);
                collage.set(i,j,color);
            }
        }
	// WRITE YOUR CODE HERE
    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) {
        collageDimension = cd;
        tileDimension = td;
        original = new Picture(filename);
        collage = new Picture(tileDimension*collageDimension,tileDimension*collageDimension);
        for(int i = 0; i <tileDimension*collageDimension; i++){
            for(int j = 0; j< tileDimension*collageDimension; j++){
                int scol = i * original.width() / (tileDimension*collageDimension);
                int srow = j * original.height() / (tileDimension*collageDimension);
                Color color = original.get(scol,srow);
                collage.set(i,j,color);
            }
        }
	// WRITE YOUR CODE HERE
    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() {
        return collageDimension;
	// WRITE YOUR CODE HERE
    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() {
        return tileDimension;
	// WRITE YOUR CODE HERE
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() {
        return original;
	// WRITE YOUR CODE HERE
    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() {
        return collage;
	// WRITE YOUR CODE HERE
    }
    
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() {
        original.show();
	// WRITE YOUR CODE HERE
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() {
        collage.show();
	// WRITE YOUR CODE HERE
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) {
        Picture toReplace = new Picture(filename);
        for(int i = collageCol*tileDimension; i <collageCol*tileDimension+tileDimension; i++){
            for(int j = collageRow*tileDimension; j< tileDimension*collageRow+tileDimension; j++){
                    int orow =( i % tileDimension) * toReplace.width() / (tileDimension) ;
                int ocol = (j % tileDimension)*toReplace.height() / (tileDimension) ;
                Color color = toReplace.get(orow,ocol);
                collage.set(i,j,color);
            }
        }
	// WRITE YOUR CODE HERE
    }
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
   public void makeCollage () {
        
        for(int i = 0; i <tileDimension*collageDimension; i++){
            for(int j = 0; j< tileDimension*collageDimension; j++){
                int orow =( i % tileDimension) * original.width() / (tileDimension) ;
                int ocol = (j % tileDimension)*original.height() / (tileDimension) ;
                Color color = original.get(orow,ocol);
                collage.set(i,j,color);
            }
        }
        
    // WRITE YOUR CODE HERE
 }

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) {
        for(int i = collageCol*tileDimension; i <collageCol*tileDimension+tileDimension; i++){
            for(int j = collageRow*tileDimension; j< tileDimension*collageRow+tileDimension; j++){
                Color color = collage.get(i, j);
                if(component=="red"){
                    int r = color.getRed();
                    collage.set(i,j, new Color(r,0,0));
                }
                else if(component == "green"){
                    int g = color.getGreen();
                    collage.set(i,j, new Color(0,g,0));
                }
                else{
                    int b = color.getBlue();
                    collage.set(i,j, new Color(0,0,b));
                }
            }
        }
	// WRITE YOUR CODE HERE
    }

    /*
     * Greyscale tile at (collageCol, collageRow)
     * (see Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */

    public void greyscaleTile (int collageCol, int collageRow) {
        for(int i = collageCol*tileDimension; i <collageCol*tileDimension+tileDimension; i++){
            for(int j = collageRow*tileDimension; j< tileDimension*collageRow+tileDimension; j++){
                Color color = collage.get(i, j);
                Color gray = Luminance.toGray(color);
                collage.set(i,j,gray);
            }
        }
	// WRITE YOUR CODE HERE
    }


    // Test client 
    public static void main (String[] args) {

        ArtCollage art = new ArtCollage(args[0], 200, 2);
        art.makeCollage();
        // Replace 3 tiles 
        art.replaceTile(args[1],0,1);
        art.colorizeTile("green",0,0);
        art.showCollagePicture();
    }
}
