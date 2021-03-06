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

package com.jwebmp.plugins.bluradmin.layout.sidebar.controllers;

import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.base.angular.services.IAngularControllerScopeStatement;

/**
 * @author GedMarc
 * @since 13 Jun 2017
 */
public class SideBarControllerMethods
		implements IAngularControllerScopeStatement<SideBarControllerMethods>
{

	/*
	 * Constructs a new SideBarControllerMethods
	 */
	public SideBarControllerMethods()
	{
		//Nothing needed
	}

	@Override
	public StringBuilder getStatement()
	{
		return FileTemplates.getFileTemplate(SideBarControllerMethods.class, "sidebarservicecontroller");
	}

	@Override
	public String getReferenceName()
	{
		return "SideBarControllerMethods";
	}

	@Override
	public String renderFunction()
	{
		return null;
	}

	/**
	 * If this page configurator is enabled
	 *
	 * @return if the configuration must run
	 */
	@Override
	public boolean enabled()
	{
		return true;
	}
}
