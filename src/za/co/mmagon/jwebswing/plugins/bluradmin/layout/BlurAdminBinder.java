package za.co.mmagon.jwebswing.plugins.bluradmin.layout;

import com.armineasy.injection.GuiceContext;
import com.armineasy.injection.abstractions.GuiceSiteInjectorModule;
import com.armineasy.injection.interfaces.GuiceSiteBinder;
import com.google.inject.Provider;
import com.google.inject.servlet.SessionScoped;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.events.click.ClickAdapter;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.display.ContentTop;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.display.DisplayScreen;
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

        module.bind(ContentTop.class).in(SessionScoped.class);
        module.bind(BlurAdminSessionProperties.class).in(SessionScoped.class);

        module.bind(DisplayScreen.class).toProvider((Provider<DisplayScreen>) () ->
        {
            if (!GuiceContext.isBuildingInjector())
            {
                BlurAdminSessionProperties props = GuiceContext.getInstance(BlurAdminSessionProperties.class);
                if (props.getCurrentScreen() == null)
                {
                    DisplayScreen ds = new DisplayScreen();
                    ds.getContentTop().getHeader().setText("Set Display Screen With <code>GuiceContext.getInstance(BlurAdminSessionProperties.class)</code>");
                    ds.getContentTop().clearCrumbs();
                    ds.getContentTop().addCrumb("Action Required", new ClickAdapter(ds)
                    {
                        @Override
                        public void onClick(AjaxCall call, AjaxResponse response)
                        {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }
                    });
                    ds.getContentTop().addCrumb("Breadcrumbs Not Available");
                    props.setCurrentScreen(ds);
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
