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

package com.jwebmp.plugins.bluradmin.layout;

import com.google.inject.Inject;
import com.jwebmp.core.PlaceHolder;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.plugins.jqlayout.components.BorderLayout;
import com.jwebmp.plugins.jqlayout.enumerations.LayoutResponsiveSize;

/**
 * @author GedMarc
 * @since 07 Jun 2017
 */
@com.google.inject.Singleton
public class BlurAdminLayout
		extends BorderLayout
{


	/*
	 * Constructs a new BlurAdminLayout
	 */
	@Inject
	@SuppressWarnings("")
	public BlurAdminLayout(BlurAdminBody body)
	{
		super();
		getNorth().getContentDiv()
		          .add(new PlaceHolder("PageTop"));
		getWest().getContentDiv()
		         .add(new PlaceHolder("SideBar"));
		getSouth().getContentDiv()
		          .add(new PlaceHolder("PageFooter"));

		getNorth().getOptions()
		          .setTogglerLengthOpen(0)
		          .setTogglerLengthClosed(0)
		          .setSpacingClosed(0)
		          .setSpacingOpen(0)
		          .setMinSize(66);

		getWest().getOptions()
		         .setMaxSize(180);
		getWest().getOptions()
		         .setMinSize(180);
		getWest().getOptions()
		         .getResponsive()
		         .setEnabled(true);
		getWest().getOptions()
		         .setTogglerLengthOpen(0);
		getWest().getOptions()
		         .setTogglerLengthClosed(0);
		getWest().getOptions()
		         .setSpacingClosed(0);
		getWest().getOptions()
		         .setSpacingOpen(0);
		getWest().getOptions()
		         .getResponsive()
		         .setWhen(LayoutResponsiveSize.Medium);

		getSouth().getOptions()
		          .setMaxSize(80);
		getSouth().getOptions()
		          .setMinSize(80);
		getSouth().getOptions()
		          .setTogglerLengthOpen(0);
		getSouth().getOptions()
		          .setTogglerLengthClosed(0);
		getSouth().getOptions()
		          .setSpacingClosed(0);
		getSouth().getOptions()
		          .setSpacingOpen(0);

		Div mainContent = new Div();
		mainContent.addClass("al-main");
		mainContent.add(new PlaceHolder("DisplayScreen"));
		getCenter().getContentDiv()
		           .add(mainContent);

		getCenter().getContentDiv()
		           .addAttribute("style", "height:100%;width:100%;");
	}
}
