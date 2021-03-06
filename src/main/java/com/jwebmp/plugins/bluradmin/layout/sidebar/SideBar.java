/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.plugins.bluradmin.layout.sidebar;

import com.google.inject.Key;
import com.google.inject.name.Names;
import com.google.inject.servlet.RequestScoped;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.html.*;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSSImpl;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.angularslimscroll.SlimScrollFeature;
import com.jwebmp.plugins.bluradmin.layout.display.DisplayScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * @author GedMarc
 * @since 05 Apr 2017
 */
@RequestScoped
public class SideBar
		extends Div
{

	private static final Logger log = LogFactory.getLog(SideBar.class.getName());


	private final List menuList;

	/*
	 * Constructs a new SideBar
	 */
	public SideBar()
	{
		setID("SideBar");
		setTag("aside");
		addClass("al-sidebar");

		addAttribute("ng-swipe-right", "setMenuCollapsed(false);");
		addAttribute("ng-swipe-left", "setMenuCollapsed(true);");

		addAttribute(AngularAttributes.ngMouseleave, "hoverElemTop=selectElemTop");

		menuList = new List(false);
		menuList.addAttribute("style", "padding-left: 0px;");

		add(menuList);

		SlimScrollFeature slimFeat = new SlimScrollFeature(this);
		addFeature(slimFeat);
		slimFeat.getOptions()
		        .setAlwaysVisible(true);
		slimFeat.getOptions()
		        .setColor(new ColourCSSImpl("#e3e3e3"));
		slimFeat.getOptions()
		        .setRailVisible(true);
		slimFeat.getOptions()
		        .setHeight("auto");
		slimFeat.getOptions()
		        .setWidth("180px");

		java.util.Map<String, String> localStorage = GuiceContext.inject()
		                                                         .getInstance(Key.get(java.util.Map.class, Names.named("LocalStorage")));
		java.util.Map<String, String> sessionStorage = GuiceContext.inject()
		                                                           .getInstance(Key.get(java.util.Map.class, Names.named("SessionStorage")));

		//Calling all sidebar builders
		Set<Class<? extends BlurAdminSideBar>> sideBarInjections = new HashSet(GuiceContext.instance().getScanResult()
		                                                                                   .getSubclasses(BlurAdminSideBar.class.getCanonicalName()).loadClasses());

		if (sideBarInjections.isEmpty())
		{
			log.severe("Sidebar will be empty, there are no classes that extend BlurAdminSideBar");
		}
		else
		{
			java.util.List<BlurAdminSideBar> blurs = new ArrayList<>();
			for (Class<? extends BlurAdminSideBar> sideBarInjection : sideBarInjections)
			{
				blurs.add(GuiceContext.get(sideBarInjection));
			}

			for (BlurAdminSideBar blur : blurs)
			{
				blur.buildSideBar(this, new HashMap<>(), localStorage, sessionStorage);
			}
		}
	}

	public Div buildListItem(String icon, String name, boolean selected, boolean submenu, Class<? extends DisplayScreen> screen)
	{
		Div li = new Div();
		li.setTag("li");
		if (screen != null)
		{
			li.setID(screen.getSimpleName());
		}

		li.addClass("al-sidebar-list-item");

		li.addClass("slide-right");

		if (selected)
		{
			li.addClass(STRING_SELECTED);
		}
		if (submenu)
		{
			li.addClass("with-sub-menu");
		}
		li.addAttribute("ui-sref-active", STRING_SELECTED);

		Link link = new Link();
		link.addClass("al-sidebar-list-link");
		li.add(link);

		Italic i = new Italic();
		i.addClass(icon);
		link.add(i);
		Span span = new Span(name);
		link.add(span);

		if (submenu)
		{
			Bold b = new Bold();
			b.addClass("fa fa-angle-down");
			b.addAttribute("ui-sref-active", "fa-angle-up");
			link.add(b);
		}

		li.addClass("hvr-curl-bottom-left");
		link.addClass("hvr-bounce-to-right");

		return li;
	}

	public List buildSubList(boolean selected, boolean slideRight, ListItem... children)
	{
		List list = new List();
		if (slideRight)
		{
			list.addClass("slide-right");
		}
		if (selected)
		{
			list.addClass(STRING_SELECTED);
		}

		for (ListItem listItem : children)
		{
			list.add(listItem);
		}

		return list;
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + getMenuList().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof SideBar))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		SideBar sideBar = (SideBar) o;

		return getMenuList().equals(sideBar.getMenuList());
	}

	public List getMenuList()
	{
		return menuList;
	}
}
