package core.mappers

interface BaseMapper<I, O> {
    fun map(input: I): O?
}