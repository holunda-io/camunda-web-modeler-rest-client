package io.holunda.webmodeler.rest.auth

import com.fasterxml.jackson.annotation.JsonProperty
import io.holunda.webmodeler.rest.exception.TokenRetrievalException
import jakarta.ws.rs.BadRequestException
import jakarta.ws.rs.client.ClientBuilder
import jakarta.ws.rs.client.Entity
import jakarta.ws.rs.core.MediaType
import java.time.Instant


class JwtManager(private val clientId: String, private val clientSecret: String) {
    private var cachedToken: String? = null
    private var tokenExpirationTime: Instant? = null
    private val oauthAudience = "api.cloud.camunda.io"
    private val grantType = "client_credentials"

    fun getValidToken(): String {
        if (cachedToken == null || tokenExpirationTime!!.isBefore(Instant.now().plusSeconds(60))) {
            refreshJwtToken()
        }

        return cachedToken!!
    }


    private fun refreshJwtToken() {
        val client = ClientBuilder.newClient()

        try {
            val payload = mapOf(
                "client_id" to clientId,
                "client_secret" to clientSecret,
                "grant_type" to grantType,
                "audience" to oauthAudience
            )

            val endpointUrl = "https://login.cloud.camunda.io/oauth/token"

            val response = client.target(endpointUrl)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(
                    Entity.json(payload),
                    SaasAccessTokenResponse::class.java
                )

            this.cachedToken = response.accessToken
            this.tokenExpirationTime = Instant.now().plusSeconds(response.expiry.toLong())
        } catch (e: BadRequestException) {
            throw TokenRetrievalException(e.message, e)
        }
    }

    data class SaasAccessTokenResponse(
        @JsonProperty("access_token") val accessToken: String,
        @JsonProperty("scope") val scope: String,
        @JsonProperty("expires_in") val expiry: Int,
        @JsonProperty("token_type") val tokenType: String
    )
}
