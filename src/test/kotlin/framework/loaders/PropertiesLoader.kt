package framework.loaders

import core.loaders.EnvironmentLoader
import java.util.Properties

class PropertiesLoader: EnvironmentLoader {

    private val properties = HashMap<String, String>()

    override fun loadParameters(file: String): HashMap<String, String> {
        EnvironmentLoader::class.java.classLoader.getResourceAsStream(file).use {
            Properties().apply {
                load(it)
                propertyNames().toList().forEach { property->
                    properties[property.toString()] = this.getProperty(property.toString())
                }
            }
        }

        return properties
    }

}