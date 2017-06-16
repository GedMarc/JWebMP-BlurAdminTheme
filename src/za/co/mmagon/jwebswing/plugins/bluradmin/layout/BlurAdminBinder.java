package za.co.mmagon.jwebswing.plugins.bluradmin.layout;

import com.armineasy.injection.abstractions.GuiceSiteInjectorModule;
import com.armineasy.injection.interfaces.GuiceSiteBinder;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.top.NavToggleButton;

/**
 *
 * @author Marc Magon
 * @since 07 Jun 2017
 */
public class BlurAdminBinder extends GuiceSiteBinder
{

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
    }
}
