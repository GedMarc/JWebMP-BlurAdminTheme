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

import com.jwebmp.core.base.html.Div;

/**
 * @author Marc Magon
 * @since 08 Apr 2017
 */
public class DisplayScreen
		extends Div
{


	private final ContentTop contentTop;
	private final Div contentDiv;

	/*
	 * Constructs a new DisplayScreen
	 */
	public DisplayScreen()
	{
		setID("DisplayScreen");
		addClass("al-content");
		addAttribute("style", "overflow-y:auto;");

		contentTop = new ContentTop();

		contentDiv = new Div();
		contentDiv.addClass("auth-main");
		contentDiv.addAttribute("autoscroll", "true");
		contentDiv.addAttribute("autoscroll-body-top", null);

		add(contentTop);
		add(contentDiv);
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (getContentTop() != null ? getContentTop().hashCode() : 0);
		result = 31 * result + (getContentDiv() != null ? getContentDiv().hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof DisplayScreen))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		DisplayScreen that = (DisplayScreen) o;

		if (getContentTop() != null ? !getContentTop().equals(that.getContentTop()) : that.getContentTop() != null)
		{
			return false;
		}
		return getContentDiv() != null ? getContentDiv().equals(that.getContentDiv()) : that.getContentDiv() == null;
	}

	public ContentTop getContentTop()
	{
		return contentTop;
	}

	public Div getContentDiv()
	{
		return contentDiv;
	}
}
