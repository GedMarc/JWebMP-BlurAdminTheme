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

package com.jwebmp.plugins.bluradmin;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.core.utilities.regex.RegularExpressionsDTO;
import com.jwebmp.plugins.plusastab.PlusAsTabFeature;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author GedMarc
 * @since 08 Jun 2017
 */
@PluginInformation(pluginName = "Blur Admin Theme",
		pluginDescription = "Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile first projects on the web.<br/> We are bootstrap 4 ready!",
		pluginUniqueName = "jwebswing-bootstrap",
		pluginVersion = "3.3.7 / 4a6",
		pluginCategories = "bootstrap,ui,web ui, framework",
		pluginSubtitle = "Bootstrap makes front-end web development faster and easier.",
		pluginSourceUrl = "http://getbootstrap.com/",
		pluginWikiUrl = "https://github.com/GedMarc/JWebMP-BootstrapPlugin/wiki",
		pluginGitUrl = "https://github.com/GedMarc/JWebMP-BootstrapPlugin",
		pluginIconUrl = "bower_components/bootstrap/bootstrapicon.jpg",
		pluginIconImageUrl = "bower_components/bootstrap/bootstraplogo.jpg",
		pluginOriginalHomepage = "http://getbootstrap.com/",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/BootstrapPlugin.jar/download")
public class BlurAdminPageConfigurator
		implements IPageConfigurator<BlurAdminPageConfigurator>
{
	/**
	 * If this configurator is enabled
	 */
	private static boolean enabled = true;
	private static BlurAdminReferencePool theme = BlurAdminReferencePool.BootstrapDefaultTheme;

	/*
	 * Constructs a new BlurAdminPageConfigurator
	 */
	public BlurAdminPageConfigurator()
	{
		//Nothing needed
	}

	/**
	 * Method isEnabled returns the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @return the enabled (type boolean) of this AngularAnimatedChangePageConfigurator object.
	 */
	public static boolean isEnabled()
	{
		return BlurAdminPageConfigurator.enabled;
	}

	/**
	 * Method setEnabled sets the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @param mustEnable
	 * 		the enabled of this AngularAnimatedChangePageConfigurator object.
	 */
	public static void setEnabled(boolean mustEnable)
	{
		BlurAdminPageConfigurator.enabled = mustEnable;
	}

	public static BlurAdminReferencePool getTheme()
	{
		return BlurAdminPageConfigurator.theme;
	}

	public static void setTheme(BlurAdminReferencePool theme)
	{
		BlurAdminPageConfigurator.theme = theme;
	}

	@NotNull
	@Override
	@SuppressWarnings("unchecked")
	public Page configure(Page page)
	{
		if (!page.isConfigured() && enabled())
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
			    .add(BlurAdminPageConfigurator.theme.getCssReference());
			if (BlurAdminPageConfigurator.theme.isTransparent())
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

	@Override
	public boolean enabled()
	{
		return BlurAdminPageConfigurator.enabled;
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
