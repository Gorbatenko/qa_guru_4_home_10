package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:testrun.properties")
public interface TestRunConfig extends Config {
    @Key("task")
    @DefaultValue("test")
    String getTask();
}