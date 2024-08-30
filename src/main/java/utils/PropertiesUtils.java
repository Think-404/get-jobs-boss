package utils;


import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import java.util.Properties;

public class PropertiesUtils {

    public static YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
    public static Properties prop;

    public static String getProperty(String name) {
        return (String) prop.get(name);
    }

    public static void initProperties(String path) {
        factory.setResources(new ClassPathResource(path));
        Properties props = factory.getObject();
    }
}
