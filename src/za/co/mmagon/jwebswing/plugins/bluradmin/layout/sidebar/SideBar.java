package za.co.mmagon.jwebswing.plugins.bluradmin.layout.sidebar;

import com.armineasy.injection.GuiceContext;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.google.inject.servlet.RequestScoped;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSSImpl;
import za.co.mmagon.jwebswing.plugins.angularslimscroll.SlimScrollFeature;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.display.DisplayScreen;
import za.co.mmagon.logger.LogFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author Marc Magon
 * @since 05 Apr 2017
 */
@RequestScoped
public class SideBar extends Div
{

	private static final Logger log = LogFactory.getLog(SideBar.class.getName());

	private static final long serialVersionUID = 1L;

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

		this.menuList = new List(false);
		menuList.addAttribute("style", "padding-left: 0px;");

		add(menuList);

		SlimScrollFeature slimFeat = new SlimScrollFeature(this);
		addFeature(slimFeat);
		slimFeat.getOptions().setAlwaysVisible(true);
		slimFeat.getOptions().setColor(new ColourCSSImpl("#e3e3e3"));
		slimFeat.getOptions().setRailVisible(true);
		slimFeat.getOptions().setHeight("auto");
		slimFeat.getOptions().setWidth("180px");

		java.util.Map<String, String> localStorage = GuiceContext.inject().getInstance(Key.get(java.util.Map.class, Names.named("LocalStorage")));
		java.util.Map<String, String> sessionStorage = GuiceContext.inject().getInstance(Key.get(java.util.Map.class, Names.named("SessionStorage")));

		//Calling all sidebar builders
		Set<Class<? extends BlurAdminSideBar>> sideBarInjections = GuiceContext.reflect().getSubTypesOf(BlurAdminSideBar.class);

		if (sideBarInjections.isEmpty())
		{
			log.severe("Sidebar will be empty, there are no classes that extend BlurAdminSideBar");
		}
		else
		{
			java.util.List<BlurAdminSideBar> blurs = new ArrayList<>();
			for (Class<? extends BlurAdminSideBar> sideBarInjection : sideBarInjections)
			{
				blurs.add(GuiceContext.getInstance(sideBarInjection));
			}

			for (BlurAdminSideBar blur : blurs)
			{
				blur.buildSideBar(this, new HashMap<>(), localStorage, sessionStorage);
			}
		}
	}

	public Div buildListItem(String icon, String name, boolean selected, boolean submenu, final Class<? extends DisplayScreen> screen)
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
			li.addClass("selected");
		}
		if (submenu)
		{
			li.addClass("with-sub-menu");
		}
		li.addAttribute("ui-sref-active", "selected");

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
			list.addClass("selected");
		}

		for (ListItem listItem : children)
		{
			list.add(listItem);
		}

		return list;
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

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + getMenuList().hashCode();
		return result;
	}
}
