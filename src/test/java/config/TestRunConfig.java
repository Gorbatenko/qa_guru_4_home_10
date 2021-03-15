package config;

import org.aeonbits.owner.Config;

public interface TestRunConfig extends Config {
    @Key("task")
    @DefaultValue("test")
    String getTask();

}
