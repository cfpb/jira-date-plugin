package ut.com.atlassian.test.plugin;

import org.junit.Test;
import com.atlassian.test.plugin.api.MyPluginComponent;
import com.atlassian.test.plugin.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}