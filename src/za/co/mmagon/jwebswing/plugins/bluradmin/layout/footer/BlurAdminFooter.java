package za.co.mmagon.jwebswing.plugins.bluradmin.layout.footer;

import java.io.Serializable;

/**
 * Called when side bar is ready to be created or anytime that the page footer is sent back
 *
 * @author Marc Magon
 * @since 13 Jun 2017
 */
public interface BlurAdminFooter extends Serializable
{

    /**
     * Called to build the sidebar
     *
     * @param footer
     * @param queryParameters
     * @param localStorage
     * @param sessionStorage
     */
    public void buildFooter(Footer footer, java.util.Map<String, String[]> queryParameters,
            java.util.Map<String, String> localStorage,
            java.util.Map<String, String> sessionStorage);

    /**
     * returns the sort order, boxed for sorting
     *
     * @return
     */
    public Integer sortOrder();
}
