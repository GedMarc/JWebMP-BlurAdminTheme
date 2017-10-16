package za.co.mmagon.jwebswing.plugins.bluradmin.layout;

import com.armineasy.injection.GuiceContext;
import com.armineasy.injection.abstractions.GuiceSiteInjectorModule;
import com.armineasy.injection.interfaces.GuiceSiteBinder;
import com.google.inject.servlet.SessionScoped;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.display.ContentTop;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.display.DisplayScreen;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.top.NavToggleButton;
import za.co.mmagon.logger.LogFactory;

import java.util.logging.Logger;

/**
 *
 * @author Marc Magon
 * @since 07 Jun 2017
 */
public class BlurAdminBinder extends GuiceSiteBinder
{
	private static final Logger log = LogFactory.getLog("BlurAdminBinder");
	
	/*
     * Constructs a new BlurAdminBinder
     */
    public BlurAdminBinder()
    {
        //Nothing needed
    }

    @Override
    public void onBind(GuiceSiteInjectorModule module)
    {
        module.bind(BlurAdminHome.class).asEagerSingleton();
        module.bind(BlurAdminBody.class).asEagerSingleton();
        module.bind(BlurAdminLayout.class).asEagerSingleton();
        module.bind(NavToggleButton.class).asEagerSingleton();

        module.bind(ContentTop.class).in(SessionScoped.class);
        module.bind(BlurAdminSessionProperties.class).in(SessionScoped.class);
	
	    module.bind(DisplayScreen.class).toProvider(() ->
	                                                {
            if (!GuiceContext.isBuildingInjector())
            {
                BlurAdminSessionProperties props = GuiceContext.getInstance(BlurAdminSessionProperties.class);
                if (props.getCurrentScreen() == null)
                {
	                log.severe("Set display screen with GuiceContext.getInstance(BlurAdminSessionProperties.class)");
                }
                return props.getCurrentScreen();
            }
            else
            {
                return new DisplayScreen();
            }
        });
    }

}
