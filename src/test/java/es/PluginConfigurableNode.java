package es;

/**
 * Created by admin on 2017/12/28.
 */

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.InternalSettingsPreparer;
import org.elasticsearch.node.Node;
import org.elasticsearch.plugins.Plugin;

import java.util.Collection;

public class PluginConfigurableNode extends Node {
    public PluginConfigurableNode(Settings preparedSettings, Collection<Class<? extends Plugin>> classpathPlugins) {
        super(InternalSettingsPreparer.prepareEnvironment(preparedSettings, null), classpathPlugins);
    }
}
