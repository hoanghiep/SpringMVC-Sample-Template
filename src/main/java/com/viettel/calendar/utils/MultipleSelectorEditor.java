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
public class MultipleSelectorEditor extends PropertyEditorSupport {
    public MultipleSelectorEditor() {
        allowEmpty = true;
    }
    
    private boolean  allowEmpty;
    @Override
    public String getAsText() {
        try {
            if (allowEmpty && getValue() == null) {
                return "";
            }
            return JsonUtils.serialize(getValue(), Selector[].class);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Could not parse value", ex);
        }
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Selector[] value = JsonUtils.deserialize(text, Selector[].class);
            setValue(value);
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
