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

import java.io.Serializable;

/**
 * Called when Page Top is ready to be created
 *
 * @author Marc Magon
 * @since 13 Jun 2017
 */
public interface BlurAdminPageTop
		extends Serializable
{

	/**
	 * Called to build the Page Top
	 *
	 * @param pageTop
	 * @param queryParameters
	 * @param localStorage
	 * @param sessionStorage
	 */
	void buildPageTop(PageTop pageTop, java.util.Map<String, String[]> queryParameters, java.util.Map<String, String> localStorage, java.util.Map<String, String> sessionStorage);

	/**
	 * returns the sort order, boxed for sorting
	 *
	 * @return
	 */
	Integer sortOrder();
}
