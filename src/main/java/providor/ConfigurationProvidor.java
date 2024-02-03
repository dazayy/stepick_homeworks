package providor;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigurationProvidor {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("config.conf");
    }

    String URL = readConfig().getString("url");


}