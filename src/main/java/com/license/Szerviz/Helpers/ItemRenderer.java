package com.license.Szerviz.Helpers;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import com.license.Szerviz.Entities.Brand;
import com.license.Szerviz.Entities.Role;

public class ItemRenderer extends BasicComboBoxRenderer {
	private static final long serialVersionUID = 3938577680522873180L;

	@Override
	  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	    super.getListCellRendererComponent(list, value, index, isSelected,
	        cellHasFocus);
	    if (value != null) {
	    	if(value instanceof Role) {
		    	Role role = (Role) value;
		    	setText(role.getRolename().toUpperCase());
	    	}else if(value instanceof Role) {
	    		Brand brand = (Brand) value;
	    		setText(brand.getBrandname().toUpperCase());
	    	}
	    }
	    if (index == -1) {
	    	if(value instanceof Role) {
		    	Role role = (Role) value;
		    	setText("" + role.getId());
	    	}else if(value instanceof Role) {
	    		Brand brand = (Brand) value;
		    	setText("" + brand.getId());
	    	}
	    }
	    return this;
	  }
}