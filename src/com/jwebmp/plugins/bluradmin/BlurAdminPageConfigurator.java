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

package com.jwebmp.plugins.bluradmin;

import com.jwebmp.Page;
import com.jwebmp.PageConfigurator;
import com.jwebmp.base.angular.AngularAttributes;
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.base.html.Div;
import com.jwebmp.base.references.CSSReference;
import com.jwebmp.plugins.PluginInformation;
import com.jwebmp.plugins.bluradmin.console.WebLogAppender;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.plugins.plusastab.PlusAsTabFeature;
import com.jwebmp.utilities.regex.RegularExpressionsDTO;
import za.co.mmagon.logger.LogFactory;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author Marc Magon
 * @since 08 Jun 2017
 */
@PluginInformation(pluginName = "Blur Admin Theme",
		pluginDescription = "Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile first projects on the web.<br/> We are bootstrap 4 ready!",
		pluginUniqueName = "jwebswing-bootstrap",
		pluginVersion = "3.3.7 / 4a6",
		pluginCategories = "bootstrap,ui,web ui, framework",
		pluginSubtitle = "Bootstrap makes front-end web development faster and easier.",
		pluginSourceUrl = "http://getbootstrap.com/",
		pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-BootstrapPlugin/wiki",
		pluginGitUrl = "https://github.com/GedMarc/JWebSwing-BootstrapPlugin",
		pluginIconUrl = "bower_components/bootstrap/bootstrapicon.jpg",
		pluginIconImageUrl = "bower_components/bootstrap/bootstraplogo.jpg",
		pluginOriginalHomepage = "http://getbootstrap.com/",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/BootstrapPlugin.jar/download")
public class BlurAdminPageConfigurator
		extends PageConfigurator
{

	private static final long serialVersionUID = 1L;

	private static BlurAdminReferencePool theme = BlurAdminReferencePool.BootstrapDefaultTheme;

	static
	{
		LogFactory.getInstance()
		          .addLogHandler(new WebLogAppender());
	}

	/*
	 * Constructs a new BlurAdminPageConfigurator
	 */
	public BlurAdminPageConfigurator()
	{
		//Nothing needed
	}

	public static BlurAdminReferencePool getTheme()
	{
		return theme;
	}

	public static void setTheme(BlurAdminReferencePool theme)
	{
		BlurAdminPageConfigurator.theme = theme;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Page configure(Page page)
	{
		if (!page.isConfigured())
		{
			JQueryPageConfigurator.setRequired(true);
			AngularPageConfigurator.setRequired(true);

			PlusAsTabFeature pat = new PlusAsTabFeature(page.getBody()).setKey(13);
			PlusAsTabFeature.setFromComponent(page.getBody());
			page.getBody()
			    .addFeature(pat);

			List bodyChildren = new ArrayList<>(page.getBody()
			                                        .getChildren());

			bodyChildren.add(new Div().addClass("body-bg"));
			bodyChildren.add(0, buildPageLoader());
			page.getBody()
			    .setChildren(new LinkedHashSet<>(bodyChildren));

			page.getBody()
			    .getCssReferences()
			    .add(theme.getCssReference());
			if (theme.isTransparent())
			{
				page.getBody()
				    .addClass("blur-theme badmin-transparent");
			}

			page.getBody()
			    .addDto("regex", new RegularExpressionsDTO().addDefaults());

			page.getBody()
			    .addCssReference(new CSSReference("Blur Override CSS", 1.0, "bluradmintheme/overrides/bluroverrides.css"));
		}
		return page;
	}

	private Div buildPageLoader()
	{
		Div d = new Div();
		d.setID("preloader");
		d.add(new Div());
		d.addAttribute(AngularAttributes.ngShow, "jw.pageLoading");
		return d;
	}

}
