package za.co.mmagon.jwebswing.plugins.bluradmin.layout.sidebar;

import java.io.Serializable;

/**
 * Called when side bar is ready to be created
 *
 * @author Marc Magon
 * @since 13 Jun 2017
 */
public interface BlurAdminSideBar extends Serializable
{

    /**
     * Called to build the sidebar
     *
     * @param sideBar
     * @param queryParameters
     * @param localStorage
     * @param sessionStorage
     */
    public void buildSideBar(SideBar sideBar, java.util.Map<String, String[]> queryParameters,
            java.util.Map<String, String> localStorage,
            java.util.Map<String, String> sessionStorage);

    /**
     * returns the sort order, boxed for sorting
     *
     * @return
     */
    public Integer sortOrder();
}
