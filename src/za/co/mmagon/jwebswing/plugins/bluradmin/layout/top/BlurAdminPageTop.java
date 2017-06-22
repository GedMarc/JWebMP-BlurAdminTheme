package za.co.mmagon.jwebswing.plugins.bluradmin.layout.top;

import java.io.Serializable;

/**
 * Called when Page Top is ready to be created
 *
 * @author Marc Magon
 * @since 13 Jun 2017
 */
public interface BlurAdminPageTop extends Serializable
{

    /**
     * Called to build the Page Top
     *
     * @param pageTop
     * @param queryParameters
     * @param localStorage
     * @param sessionStorage
     */
    public void buildPageTop(PageTop pageTop, java.util.Map<String, String[]> queryParameters,
            java.util.Map<String, String> localStorage,
            java.util.Map<String, String> sessionStorage);

    /**
     * returns the sort order, boxed for sorting
     *
     * @return
     */
    public Integer sortOrder();
}
