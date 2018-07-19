package com.jwebmp.plugins.bluradmin.util;

import com.jwebmp.Event;
import com.jwebmp.Feature;
import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.toastr.ToastrFeature;
import com.jwebmp.plugins.toastr.ToastrType;
import org.atmosphere.cpr.AtmosphereResource;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marc Magon
 * @since 28 Jun 2017
 */
public class BlurUtilities
{

	private static final Logger log = LogFactory.getLog(BlurUtilities.class.getName());

	private static final BlurUtilities instance = new BlurUtilities();

	/*
	 * Constructs a new BlurUtilities
	 */
	private BlurUtilities()
	{
		//Nothing needed
	}

	public static BlurUtilities getInstance()
	{
		return instance;
	}

	public void pushToast(ToastrType type, String title, String message)
	{
		try
		{
			AtmosphereResource resource = GuiceContext.getInstance(AtmosphereResource.class);
			AjaxResponse response = new AjaxResponse();
			response.getFeatures()
			        .add(new ToastrFeature(type, title, message).setTiny(true));
			resource.write(response.toString());
		}
		catch (NullPointerException e)
		{
			log.log(Level.SEVERE, "Can't push toast find atmosphere resource", e);
		}
	}

	public void pushUpdate(ComponentHierarchyBase... comp)
	{
		try
		{
			AtmosphereResource resource = GuiceContext.getInstance(AtmosphereResource.class);
			AjaxResponse response = new AjaxResponse();
			for (ComponentHierarchyBase componentHierarchyBase : comp)
			{
				response.addComponent(componentHierarchyBase);
			}
			resource.write(response.toString());
		}
		catch (NullPointerException e)
		{
			log.log(Level.SEVERE, "Can't find push update - atmosphere resource", e);
		}
	}

	public void pushUpdate(Feature... comp)
	{
		try
		{
			AtmosphereResource resource = GuiceContext.getInstance(AtmosphereResource.class);
			AjaxResponse response = new AjaxResponse();
			for (Feature componentHierarchyBase : comp)
			{
				response.getFeatures()
				        .add(componentHierarchyBase);
			}
			resource.write(response.toString());
		}
		catch (NullPointerException e)
		{
			log.log(Level.SEVERE, "Can't push update find atmosphere resource", e);
		}
	}

	public void pushUpdate(Event... comp)
	{
		try
		{
			AtmosphereResource resource = GuiceContext.getInstance(AtmosphereResource.class);

			AjaxResponse response = new AjaxResponse();
			for (Event componentHierarchyBase : comp)
			{
				response.getEvents()
				        .add(componentHierarchyBase);
			}
			resource.write(response.toString());
		}
		catch (NullPointerException e)
		{
			log.log(Level.SEVERE, "Can't find push update for event atmosphere resource - {0}", e);
		}
	}

}