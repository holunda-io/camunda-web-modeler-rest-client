package io.holunda.webmodeler.rest.exception

/**
 * This exception is thrown when an error during the token retrieval process occurs
 */
class TokenRetrievalException(message: String? = null, cause: Throwable? = null) : Exception(message, cause) {
}