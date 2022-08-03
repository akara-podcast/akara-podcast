/*-----------------------------------------------------------------------------------------
 * NAME : RandomImage.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-06-24   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-07-08   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package model;

public enum RandomImage {

    IMAGE_1(1, "/image/1.png"),
    IMAGE_2(2, "/image/2.png"),
    IMAGE_3(3, "/image/3.png"),
    IMAGE_4(4, "/image/4.png"),
    IMAGE_5(5, "/image/5.png"),
    IMAGE_6(6, "/image/6.png"),
    IMAGE_7(7, "/image/7.png"),
    IMAGE_8(8, "/image/8.png"),
    IMAGE_9(9, "/image/9.png"),
    IMAGE_10(10, "/image/10.png"),
    IMAGE_11(11, "/image/11.png"),
    IMAGE_12(12, "/image/12.png"),
    IMAGE_13(13, "/image/13.png"),
    IMAGE_14(14, "/image/14.png"),
    IMAGE_15(15, "/image/15.png"),
    IMAGE_16(16, "/image/16.png"),
    IMAGE_17(17, "/image/17.png"),
    IMAGE_18(18, "/image/18.png"),
    IMAGE_19(19, "/image/19.png"),
    IMAGE_20(20, "/image/20.png"),
    IMAGE_21(21, "/image/21.png"),
    IMAGE_22(22, "/image/22.png"),
    IMAGE_23(23, "/image/23.png"),
    IMAGE_24(24, "/image/24.png"),
    IMAGE_25(25, "/image/25.png"),
    IMAGE_26(26, "/image/26.png"),
    ;

    private final int imageId;
    private final String imageUrl;

    RandomImage(int imageId, String imageUrl) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
    }

    public int getImageId() {
        return imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
