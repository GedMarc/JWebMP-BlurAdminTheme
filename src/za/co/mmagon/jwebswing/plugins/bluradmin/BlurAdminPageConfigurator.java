package za.co.mmagon.jwebswing.plugins.bluradmin;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.plugins.PluginInformation;
import za.co.mmagon.jwebswing.plugins.bluradmin.console.WebLogAppender;
import za.co.mmagon.jwebswing.plugins.bootstrap.BootstrapPageConfigurator;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;
import za.co.mmagon.jwebswing.plugins.plusastab.PlusAsTabFeature;
import za.co.mmagon.jwebswing.utilities.RegularExpressionsDTO;
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
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/BootstrapPlugin.jar/download"
)
public class BlurAdminPageConfigurator extends PageConfigurator
{

	private static final long serialVersionUID = 1L;

	private static BlurAdminReferencePool theme = BlurAdminReferencePool.BootstrapDefaultTheme;

	static
	{
		LogFactory.getInstance().addLogHandler(new WebLogAppender());
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
			BootstrapPageConfigurator.setRequired(page.getBody(), true);

			PlusAsTabFeature pat = new PlusAsTabFeature().setKey(13);
			PlusAsTabFeature.setFromComponent(page.getBody());
			page.getBody().addFeature(pat);

			List bodyChildren = new ArrayList<>(page.getBody().getChildren());

			bodyChildren.add(new Div().addClass("body-bg"));
			bodyChildren.add(0, buildPageLoader());
			page.getBody().setChildren(new LinkedHashSet<>(bodyChildren));

			page.getBody().getCssReferences().add(theme.getCssReference());
			if (theme.isTransparent())
			{
				page.getBody().addClass("blur-theme badmin-transparent");
			}

			page.getBody().addDto("regex", new RegularExpressionsDTO().addDefaults());

			page.getBody().addCssReference(new CSSReference("Blur Override CSS", 1.0, "bluradmintheme/overrides/bluroverrides.css"));
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
