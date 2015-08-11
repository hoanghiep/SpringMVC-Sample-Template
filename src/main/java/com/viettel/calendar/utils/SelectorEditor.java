/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.utils;

import com.viettel.calendar.viewmodels.Selector;
import java.beans.PropertyEditorSupport;
import java.io.IOException;

/**
 *
 * @author hiepth6
 */
public class SelectorEditor extends PropertyEditorSupport {

    public SelectorEditor() {
        allowEmpty = true;
    }
    
    private boolean  allowEmpty;
    @Override
    public String getAsText() {
        try {
            if (allowEmpty && getValue() == null) {
                return "";
            }
            return JsonUtils.serialize(getValue(), Selector.class);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Could not parse", ex);
        }
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(JsonUtils.<Selector>deserialize(text, Selector.class));
        } catch (Exception ex) {
            throw new IllegalArgumentException("Could not parse text ["
                    + text + "] into any available Selector input formats", ex);
        }
    }

    public boolean isAllowEmpty() {
        return allowEmpty;
    }

    public void setAllowEmpty(boolean allowEmpty) {
        this.allowEmpty = allowEmpty;
    }

}
