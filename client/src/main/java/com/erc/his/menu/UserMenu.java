package com.erc.his.menu;

import java.util.ArrayList;
import java.util.List;

public class UserMenu {
	public String menuName;
	public List<UserSubMenu> subMenus = new ArrayList<UserSubMenu>();
	
	public UserMenu(String menuName) {
		this.menuName = menuName;
	}
}
