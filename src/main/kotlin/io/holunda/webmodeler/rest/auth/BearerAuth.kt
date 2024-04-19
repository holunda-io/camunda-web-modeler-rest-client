package io.holunda.webmodeler.rest.auth

import org.openapitools.client.Pair
import org.openapitools.client.auth.HttpBearerAuth
import java.net.URI

class BearerAuth(clientId: String, clientSecret: String) : HttpBearerAuth("Bearer") {

    private val jwtManager = JwtManager(clientId, clientSecret)

    override fun applyToParams(
        queryParams: MutableList<Pair>?,
        headerParams: MutableMap<String, String>?,
        cookieParams: MutableMap<String, String>?,
        payload: String?,
        method: String?,
        uri: URI?
    ) {
        headerParams!!["Authorization"] = "Bearer ${jwtManager.getValidToken()}"
    }


}