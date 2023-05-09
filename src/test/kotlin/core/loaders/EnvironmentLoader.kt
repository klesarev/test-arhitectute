package core.loaders

interface EnvironmentLoader {
    fun loadParameters(file: String = "application.properties"): HashMap<String, String>
}