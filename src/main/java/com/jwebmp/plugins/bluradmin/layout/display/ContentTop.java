/*
 * Copyright (C) 2017 Marc Magon
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

package com.jwebmp.plugins.bluradmin.layout.display;

import com.google.inject.servlet.SessionScoped;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.html.attributes.LinkAttributes;
import com.jwebmp.core.utilities.StaticStrings;

/**
 * @author Marc Magon
 * @since 21 Jun 2017
 */
@SessionScoped
public class ContentTop
		extends Div
{


	private final H1 header;
	private final List breadCrumblist;

	/*
	 * Constructs a new ContentTop
	 */
	public ContentTop()
	{
		header = new H1();
		header.addAttribute("style", "display:inline;");
		breadCrumblist = new List(false);

		addClass("content-top clearfix");
		breadCrumblist.addClass("breadcrumb al-breadcrumb");

		add(header);
		add(breadCrumblist);
	}

	public void clearCrumbs()
	{
		breadCrumblist.getChildren()
		              .clear();
	}

	public ListItem addCrumb(String crumb)
	{
		return addCrumb(crumb, null);
	}

	public ListItem addCrumb(String crumb, Event event)
	{
		ListItem li = new ListItem();
		if (event != null)
		{
			Link link = new Link<>();
			li.add(link);
			link.setText(crumb);
			link.addEvent(event);
			link.addAttribute(LinkAttributes.HRef, StaticStrings.STRING_HASH);
		}
		else
		{
			li.setText(crumb);
		}
		getBreadCrumblist().add(li);
		return li;
	}

	public List getBreadCrumblist()
	{
		return breadCrumblist;
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (getHeader() != null ? getHeader().hashCode() : 0);
		result = 31 * result + (getBreadCrumblist() != null ? getBreadCrumblist().hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof ContentTop))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		ContentTop that = (ContentTop) o;

		if (getHeader() != null ? !getHeader().equals(that.getHeader()) : that.getHeader() != null)
		{
			return false;
		}
		return getBreadCrumblist() != null ? getBreadCrumblist().equals(that.getBreadCrumblist()) : that.getBreadCrumblist() == null;
	}

	public H1 getHeader()
	{
		return header;
	}
}
