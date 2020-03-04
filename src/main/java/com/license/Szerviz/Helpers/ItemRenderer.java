package com.license.Szerviz.Helpers;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import com.license.Szerviz.Entities.Role;

public class ItemRenderer extends BasicComboBoxRenderer {
	private static final long serialVersionUID = 3938577680522873180L;

	@Override
	  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	    super.getListCellRendererComponent(list, value, index, isSelected,
	        cellHasFocus);
	    if (value != null) {
	    	Role role = (Role) value;
	    	setText(role.getRolename().toUpperCase());
	    }
	    if (index == -1) {
	    	Role role = (Role) value;
	    	setText("" + role.getId());
	    }
	    return this;
	  }
}