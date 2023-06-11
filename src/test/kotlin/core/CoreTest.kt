package core

import core.loaders.EnvironmentLoader
import java.util.logging.Logger

abstract class CoreTest (
    private val settings: EnvironmentLoader
) {

    /**
     * Settings from EnvironmentLoader
    */
    protected val properties: HashMap<String, String> get() = settings.loadParameters()

    protected val logger: Logger = Logger.getLogger(this::class.simpleName)

}