package net.notjustanna.thewolf.stories

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import net.notjustanna.thewolf.stories.view.badGatewayPage
import net.notjustanna.thewolf.stories.view.notFoundPage

@Controller
class StoriesController {
    private val html = "text/html"
    private val text = "text/plain"
    private val json = "application/json"
    private val xml = "application/xml"

    @Get
    fun lostInTheWoods(
        @Header("Accept") acceptHeader: String?,
        @Header("Host") hostHeader: String?
    ): MutableHttpResponse<String> {
        val type = MIMEParse.bestMatch(listOf(html, json, text, xml), acceptHeader ?: text)
        val res = HttpResponse.notFound<String>()
            .contentType(type)

        return when (type) {
            html -> res.body(notFoundPage(hostHeader))
            json -> res.body(
                """{"source": "Traefik", "code": 404, "message": "${
                    if (hostHeader.isNullOrBlank()) {
                        """No \"Host\" Header"""
                    } else {
                        """No routing found for \"Host\" Header with value \"${hostHeader.jsonEscape()}\""""
                    }
                }"}"""
            )
            xml -> res.body(
                """
                    <?xml version="1.0" encoding="UTF-8"?>
                    <error><source>Traefik</source><code>404</code><message>${
                    if (hostHeader.isNullOrBlank()) {
                        """No "Host" Header"""
                    } else {
                        """No routing found for "Host" Header with value "${hostHeader.xmlEscape()}""""
                    }
                }</message></error>
                """.trimIndent()
            )
            else -> res.body(
                if (hostHeader.isNullOrBlank()) {
                    """404 No "Host" Header"""
                } else {
                    """404 No routing found for "Host" Header with value "$hostHeader""""
                }
            )
        }
    }

    @Get("/traefik/502")
    fun aloneInTheWarehouse(
        @Header("Accept") acceptHeader: String?,
        @Header("Host") hostHeader: String?
    ): MutableHttpResponse<String> {
        val type = MIMEParse.bestMatch(listOf(html, json, text, xml), acceptHeader ?: text)
        val res = HttpResponse.status<String>(HttpStatus.BAD_GATEWAY).contentType(type)

        return when (type) {
            html -> res.body(badGatewayPage(hostHeader))
            json -> res.body(
                """{"source": "Traefik", "code": 502, "message": "${
                    if (hostHeader.isNullOrBlank()) {
                        """Bad Gateway"""
                    } else {
                        """Bad Gateway for \"Host\" value \"${hostHeader.jsonEscape()}\""""
                    }
                }"}"""
            )
            xml -> res.body(
                """
                    <?xml version="1.0" encoding="UTF-8"?>
                    <error><source>Traefik</source><code>502</code><message>${
                    if (hostHeader.isNullOrBlank()) {
                        "Bad Gateway"
                    } else {
                        """Bad Gateway for "Host" value "${hostHeader.xmlEscape()}""""
                    }
                }</message></error>
                """.trimIndent()
            )
            else -> res.body(
                if (hostHeader.isNullOrBlank()) {
                    "502 Bad Gateway"
                } else {
                    """502 Bad Gateway for "Host" value "$hostHeader""""
                }
            )
        }
    }

    @Put("/traefik/502")
    fun aloneInTheWarehousePut(
        @Header("Accept") acceptHeader: String?,
        @Header("Host") hostHeader: String?
    ) = aloneInTheWarehouse(acceptHeader, hostHeader)

    @Post("/traefik/502")
    fun aloneInTheWarehousePost(
        @Header("Accept") acceptHeader: String?,
        @Header("Host") hostHeader: String?
    ) = aloneInTheWarehouse(acceptHeader, hostHeader)

    @Patch("/traefik/502")
    fun aloneInTheWarehousePatch(
        @Header("Accept") acceptHeader: String?,
        @Header("Host") hostHeader: String?
    ) = aloneInTheWarehouse(acceptHeader, hostHeader)

    @Delete("/traefik/502")
    fun aloneInTheWarehouseDelete(
        @Header("Accept") acceptHeader: String?,
        @Header("Host") hostHeader: String?
    ) = aloneInTheWarehouse(acceptHeader, hostHeader)
}
