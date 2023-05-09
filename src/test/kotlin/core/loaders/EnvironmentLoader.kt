package core.loaders

interface EnvironmentLoader {
    fun loadParameters(file: String): HashMap<String, String>
}