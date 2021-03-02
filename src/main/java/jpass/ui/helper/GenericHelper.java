package jpass.ui.helper;

import jpass.util.ClipboardUtils;

import java.awt.*;

import static jpass.ui.MessageDialog.showErrorMessage;

public class GenericHelper {

    /**
     * Copy entry field value to clipboard.
     *
     * @param parent the parent frame
     * @param content the content to copy
     */
    public static void copyEntryField(Component parent, String content) {
        try {
            ClipboardUtils.setClipboardContent(content);
        } catch (Exception e) {
            showErrorMessage(parent, e.getMessage());
        }
    }
}
