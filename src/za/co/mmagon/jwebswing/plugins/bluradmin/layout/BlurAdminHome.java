package za.co.mmagon.jwebswing.plugins.bluradmin.layout;

import com.armineasy.injection.GuiceContext;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.generics.WebReference;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.display.DisplayScreen;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.footer.Footer;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.sidebar.SideBar;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.top.PageTop;

/**
 * The default page for blur Admin theme
 *
 * @author Marc Magon
 * @since 07 Jun 2017
 */
public class BlurAdminHome extends Page
{

    private static final long serialVersionUID = 1L;

    /*
     * Constructs a new BlurAdminHome
     */
    protected BlurAdminHome()
    {
        //Literally just to build
        setBody(new BlurAdminBody());
        WebReference.setUseMinAtEndOfExtension(true);
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            setBody(GuiceContext.getInstance(BlurAdminBody.class));
        }
        super.init();
    }

    @Override
    public AjaxResponse onConnect(AjaxCall call, AjaxResponse response)
    {
        response.addComponent(GuiceContext.getInstance(SideBar.class));
        response.addComponent(GuiceContext.getInstance(Footer.class));
        response.addComponent(GuiceContext.getInstance(PageTop.class));
        response.addComponent(GuiceContext.getInstance(DisplayScreen.class));

        return super.onConnect(call, response);
    }
}
