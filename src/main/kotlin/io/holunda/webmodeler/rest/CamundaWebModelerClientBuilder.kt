package io.holunda.webmodeler.rest

import io.holunda.webmodeler.rest.impl.CamundaWebModelerClient
import io.holunda.webmodeler.rest.impl.CamundaWebModelerClientImpl

class CamundaWebModelerClientBuilder {
    private lateinit var clientId: String
    private lateinit var clientSecret: String

    fun clientId(clientId: String): CamundaWebModelerClientBuilder {
        this.clientId = clientId

        return this
    }

    fun clientSecret(clientSecret: String): CamundaWebModelerClientBuilder {
        this.clientSecret = clientSecret

        return this
    }

    fun build(): CamundaWebModelerClient {
        return CamundaWebModelerClientImpl(this.clientId, this.clientSecret)
    }

    companion object {
        @JvmStatic
        fun builder() = CamundaWebModelerClientBuilder()
    }
}