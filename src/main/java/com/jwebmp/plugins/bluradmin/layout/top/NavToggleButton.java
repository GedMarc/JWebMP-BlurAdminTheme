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

package com.jwebmp.plugins.bluradmin.layout.top;

import com.google.inject.Inject;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.plugins.bluradmin.layout.BlurAdminLayout;
import com.jwebmp.plugins.jqlayout.events.JQLayoutAddToggleButtonFeature;

/**
 * A Default Navigation Toggle Button
 *
 * @author Marc Magon
 * @since 19 Apr 2017
 */
public class NavToggleButton
		extends Link<NavToggleButton>
{

	private static final long serialVersionUID = 1L;

	NavToggleButton()
	{
	}

	/*
	 * Constructs a new NavToggleButton
	 */
	@Inject
	public NavToggleButton(BlurAdminLayout layout)
	{
		addClass("collapse-menu-link fa fa-navicon");
		setID("NavToggleMenuButton");
		JQLayoutAddToggleButtonFeature atbf = new JQLayoutAddToggleButtonFeature(layout.getWest(), this);
		addFeature(atbf);
		//JQLayoutFeature feat = new JQLayoutFeature(layout)
	}
}
