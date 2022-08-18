package com.learning.facade;

import com.learning.pages.HomePageNative;

/**
 * @author Sreej
 */
public class DragDropFacade {

    public void navigateToDragAndDropPage() {
        new HomePageNative().clickOnViews().clickMenuItem("Drag and Drop");
    }


}
