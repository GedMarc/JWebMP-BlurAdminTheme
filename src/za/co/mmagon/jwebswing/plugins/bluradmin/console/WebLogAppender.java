package za.co.mmagon.jwebswing.plugins.bluradmin.console;

import com.armineasy.injection.GuiceContext;
import java.util.Set;
import java.util.logging.*;
import org.atmosphere.cpr.AtmosphereResource;
import za.co.mmagon.jwebswing.base.ajax.*;
import za.co.mmagon.plugins.weblogappender.WebLogAppenderAtmosphereAdapter;
import za.co.mmagon.plugins.weblogappender.WebLogAppenderPageConfigurator;
import za.co.mmagon.plugins.weblogappender.annotations.*;

/**
 *
 * @author Marc Magon
 * @since 23 Apr 2017
 */
public class WebLogAppender extends Handler
{

    private static final Logger LOG = Logger.getLogger(WebLogAppender.class.getName());

    @Override
    public void close() throws SecurityException
    {

    }

    @Override
    public void flush()
    {

    }

    @Override
    public void publish(LogRecord record)
    {
        if (GuiceContext.isBuildingInjector())
        {
            return;
        }

        AtmosphereResource resource;
        try
        {
            resource = GuiceContext.getInstance(AtmosphereResource.class);
        }
        catch (Exception e)
        {
            LOG.log(Level.SEVERE, "Can''t find atmosphere resource - {0}", e.getLocalizedMessage());
            return;
        }

        if (WebLogAppenderPageConfigurator.isEnabled() && resource != null)
        {
            if (record.getLevel().equals(Level.INFO))
            {
                AjaxResponse autoUpdate = renderInfoMessage(record);
                if (autoUpdate != null)
                {
                    resource.write(autoUpdate.toString());
                }
            }
            else if (record.getLevel().equals(Level.CONFIG))
            {
                AjaxResponse autoUpdate = renderConfigMessage(record);
                if (autoUpdate != null)
                {
                    resource.write(autoUpdate.toString());
                }
            }
            else if (record.getLevel().equals(Level.WARNING))
            {
                AjaxResponse autoUpdate = renderWarningMessage(record);
                if (autoUpdate != null)
                {
                    resource.write(autoUpdate.toString());
                }
            }
            else if (record.getLevel().equals(Level.SEVERE))
            {
                AjaxResponse autoUpdate = renderSevereMessage(record);
                if (autoUpdate != null)
                {
                    resource.write(autoUpdate.toString());
                }
            }
            else if (record.getLevel().equals(Level.FINE))
            {
                AjaxResponse autoUpdate = renderFineMessage(record);
                if (autoUpdate != null)
                {
                    resource.write(autoUpdate.toString());
                }
            }
            else if (record.getLevel().equals(Level.FINER))
            {
                AjaxResponse autoUpdate = renderFinerMessage(record);
                if (autoUpdate != null)
                {
                    resource.write(autoUpdate.toString());
                }
            }
            else if (record.getLevel().equals(Level.FINEST))
            {
                AjaxResponse autoUpdate = renderFinestMessage(record);
                if (autoUpdate != null)
                {
                    resource.write(autoUpdate.toString());
                }
            }
        }
    }

    public AjaxResponse renderInfoMessage(LogRecord record)
    {
        Set<Class<? extends WebLogInfoMessage>> items = GuiceContext.reflect().getSubTypesOf(WebLogInfoMessage.class);
        for (Class<? extends WebLogInfoMessage> item : items)
        {
            try
            {
                WebLogInfoMessage infoMessage = item.newInstance();
                infoMessage.renderMessage(record);
                AjaxResponse ar = new AjaxResponse();
                AjaxComponentUpdates comp = ar.addComponent(infoMessage);
                if (WebLogAppenderPageConfigurator.isInsertAtTop())
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert);
                }
                else
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert_Last);
                }
                return ar;
            }
            catch (InstantiationException | IllegalAccessException ex)
            {
                Logger.getLogger(WebLogAppenderAtmosphereAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public AjaxResponse renderConfigMessage(LogRecord record)
    {
        Set<Class<? extends WebLogConfigMessage>> items = GuiceContext.reflect().getSubTypesOf(WebLogConfigMessage.class);
        for (Class<? extends WebLogConfigMessage> item : items)
        {
            try
            {
                WebLogConfigMessage infoMessage = item.newInstance();
                infoMessage.renderMessage(record);
                AjaxResponse ar = new AjaxResponse();
                AjaxComponentUpdates comp = ar.addComponent(infoMessage);
                if (WebLogAppenderPageConfigurator.isInsertAtTop())
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert);
                }
                else
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert_Last);
                }
                return ar;
            }
            catch (InstantiationException | IllegalAccessException ex)
            {
                Logger.getLogger(WebLogAppenderAtmosphereAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public AjaxResponse renderWarningMessage(LogRecord record)
    {
        Set<Class<? extends WebLogWarningMessage>> items = GuiceContext.reflect().getSubTypesOf(WebLogWarningMessage.class);
        for (Class<? extends WebLogWarningMessage> item : items)
        {
            try
            {
                WebLogWarningMessage infoMessage = item.newInstance();
                infoMessage.renderMessage(record);
                AjaxResponse ar = new AjaxResponse();
                AjaxComponentUpdates comp = ar.addComponent(infoMessage);
                if (WebLogAppenderPageConfigurator.isInsertAtTop())
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert);
                }
                else
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert_Last);
                }
                return ar;
            }
            catch (InstantiationException | IllegalAccessException ex)
            {
                Logger.getLogger(WebLogAppenderAtmosphereAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public AjaxResponse renderSevereMessage(LogRecord record)
    {
        Set<Class<? extends WebLogSevereMessage>> items = GuiceContext.reflect().getSubTypesOf(WebLogSevereMessage.class);
        for (Class<? extends WebLogSevereMessage> item : items)
        {
            try
            {
                WebLogSevereMessage infoMessage = item.newInstance();
                infoMessage.renderMessage(record);
                AjaxResponse ar = new AjaxResponse();
                AjaxComponentUpdates comp = ar.addComponent(infoMessage);
                if (WebLogAppenderPageConfigurator.isInsertAtTop())
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert);
                }
                else
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert_Last);
                }
                return ar;
            }
            catch (InstantiationException | IllegalAccessException ex)
            {
                Logger.getLogger(WebLogAppenderAtmosphereAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public AjaxResponse renderFineMessage(LogRecord record)
    {
        Set<Class<? extends WebLogFineMessage>> items = GuiceContext.reflect().getSubTypesOf(WebLogFineMessage.class);
        for (Class<? extends WebLogFineMessage> item : items)
        {
            try
            {
                WebLogFineMessage infoMessage = item.newInstance();
                infoMessage.renderMessage(record);
                AjaxResponse ar = new AjaxResponse();
                AjaxComponentUpdates comp = ar.addComponent(infoMessage);
                if (WebLogAppenderPageConfigurator.isInsertAtTop())
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert);
                }
                else
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert_Last);
                }
                return ar;
            }
            catch (InstantiationException | IllegalAccessException ex)
            {
                Logger.getLogger(WebLogAppenderAtmosphereAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public AjaxResponse renderFinerMessage(LogRecord record)
    {
        Set<Class<? extends WebLogFinerMessage>> items = GuiceContext.reflect().getSubTypesOf(WebLogFinerMessage.class);
        for (Class<? extends WebLogFinerMessage> item : items)
        {
            try
            {
                WebLogFinerMessage infoMessage = item.newInstance();
                infoMessage.renderMessage(record);
                AjaxResponse ar = new AjaxResponse();
                ar.addComponent(infoMessage);
                return ar;
            }
            catch (InstantiationException | IllegalAccessException ex)
            {
                Logger.getLogger(WebLogAppenderAtmosphereAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public AjaxResponse renderFinestMessage(LogRecord record)
    {
        Set<Class<? extends WebLogFinestMessage>> items = GuiceContext.reflect().getSubTypesOf(WebLogFinestMessage.class);
        for (Class<? extends WebLogFinestMessage> item : items)
        {
            try
            {
                WebLogFinestMessage infoMessage = item.newInstance();
                infoMessage.renderMessage(record);
                AjaxResponse ar = new AjaxResponse();
                AjaxComponentUpdates comp = ar.addComponent(infoMessage);
                if (WebLogAppenderPageConfigurator.isInsertAtTop())
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert);
                }
                else
                {
                    comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
                    comp.setInsertType(AjaxComponentInsertType.Insert_Last);
                }
                return ar;
            }
            catch (InstantiationException | IllegalAccessException ex)
            {
                Logger.getLogger(WebLogAppenderAtmosphereAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
