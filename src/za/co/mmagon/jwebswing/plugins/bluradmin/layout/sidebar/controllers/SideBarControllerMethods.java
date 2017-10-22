package za.co.mmagon.jwebswing.plugins.bluradmin.layout.sidebar.controllers;

import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.base.angular.controllers.AngularControllerScopeStatement;

/**
 * @author Marc Magon
 * @since 13 Jun 2017
 */
public class SideBarControllerMethods extends AngularControllerScopeStatement
{

	/*
	 * Constructs a new SideBarControllerMethods
	 */
	public SideBarControllerMethods()
	{
		//Nothing needed
	}

	@Override
	public StringBuilder getStatement()
	{
		return FileTemplates.getFileTemplate(SideBarControllerMethods.class, "sidebarservicecontroller");
	}
}
