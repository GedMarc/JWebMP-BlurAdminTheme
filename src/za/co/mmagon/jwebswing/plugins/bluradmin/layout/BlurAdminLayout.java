package za.co.mmagon.jwebswing.plugins.bluradmin.layout;

import com.google.inject.Inject;
import za.co.mmagon.jwebswing.PlaceHolder;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayout;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.LayoutResponsiveBootstrapSize;

/**
 *
 * @author Marc Magon
 * @since 07 Jun 2017
 */
@com.google.inject.Singleton
public class BlurAdminLayout extends JQLayout
{

    private static final long serialVersionUID = 1L;

    /*
     * Constructs a new BlurAdminLayout
     */
    @Inject
    @SuppressWarnings("")
    public BlurAdminLayout(BlurAdminBody body)
    {
        super(body);
        getNorth().getContentDiv().add(new PlaceHolder("PageTop"));
        getWest().getContentDiv().add(new PlaceHolder("SideBar"));
        getSouth().getContentDiv().add(new PlaceHolder("PageFooter"));

	    getNorth().getOptions().setTogglerLengthOpen(0);
	    getNorth().getOptions().setTogglerLengthClosed(0);
	    getNorth().getOptions().setSpacingClosed(0);
	    getNorth().getOptions().setSpacingOpen(0);
	    getNorth().getOptions().setMinSize(66);

        getWest().getOptions().setMaxSize(180);
        getWest().getOptions().setMinSize(180);
        getWest().getOptions().setResponsive(true);
	    getWest().getOptions().setTogglerLengthOpen(0);
	    getWest().getOptions().setTogglerLengthClosed(0);
	    getWest().getOptions().setSpacingClosed(0);
	    getWest().getOptions().setSpacingOpen(0);
	    getWest().getOptions().setResponsiveWhen(LayoutResponsiveBootstrapSize.Medium);

        getSouth().getOptions().setMaxSize(80);
        getSouth().getOptions().setMinSize(80);
	    getSouth().getOptions().setTogglerLengthOpen(0);
	    getSouth().getOptions().setTogglerLengthClosed(0);
	    getSouth().getOptions().setSpacingClosed(0);
	    getSouth().getOptions().setSpacingOpen(0);

        Div mainContent = new Div();
        mainContent.addClass("al-main");
        mainContent.add(new PlaceHolder("DisplayScreen"));
        getCenter().getContentDiv().add(mainContent);

        getCenter().getContentDiv().addAttribute("style", "height:100%;width:100%;");
    }
}
