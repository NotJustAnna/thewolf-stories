package net.notjustanna.thewolf.stories.view

import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun notFoundPage(host: String?): String {
    return "<!DOCTYPE html>\n" + createHTML().html {
        lang = "en"
        head {
            storiesHead()
            title("· Lost in the woods ·")
        }
        body {
            style = textCenter
            wolfImg()
            h2 {
                title = "Read: \"I can't believe I managed to fuck this up\"-level lost."
                +"You found yourself lost in the woods."
            }
            p {
                +"A "
                span("red") {
                    title = """
                            Read: we're talking about a wolf 1.10m tall and 2m in length.
                            Uhh, that'll be like... 2 eagles tall and 3 washing machines in length?
                            I don't know, I'm not american. Use Google or something.
                        """.trimIndent()
                    +"big, red wolf"
                }
                +" approached you."
            }
            p {
                +"As "
                span("red") {
                    title = """
                            Read: "Your life is flashing before your eyes"-level menacing.
                            You may have crap in your pants now, as well.
                        """.trimIndent()
                    +"menacing"
                }
                +" as it seemed, the red wolf kept its distance from you, its tail as to signal that it was "
                span("red") {
                    title = """
                            "Huh? Why am I not being made into a meal?"
                            "Uhh... is this wolf borked? He's wagging his tail..."
                            "Does he want me to follow him???"
                        """.trimIndent()
                    +"friendly"
                }
                +" to you."
            }
            p {
                +"You eventually decided to "
                span("red") {
                    title = "\"I'm so gonna be eaten alive in like ten more seconds...\""
                    +"follow"
                }
                +" the red wolf. "
                span {
                    title = "Read: two eterneties and a half."
                    +"Soon enough"
                }
                +", you found yourself at the shoulder of a "
                span("red") {
                    title =
                        "You never felt so relieved to be in basically one of the most dangerous places of the country."
                    +"highway"
                }
                +"."
            }
            p {
                +"You looked back to "
                span {
                    title = "\"I mean... he did actually save my life...\""
                    +"thank the strange although kind wolf"
                }
                +", but it had already "
                span {
                    title = "Wooosh."
                    +"vanished into the woods"
                }
                +", leaving a "
                a(classes = "red") {
                    href = musicDisc
                    title = """
                            Does anyone even have a CD player on their car anymore?? I miss them.
                            Also SIAMÉS is a great band, and this song is what inspired me to name my first home-server 'thewolf'.
                        """.trimIndent()
                    +"odd looking disc"
                }
                +" behind."
            }
            p {
                +"After picking the disc up, you decided to drive "
                a(classes = "red") {
                    href = civilization
                    title =
                        "Google is the best definition of the modern civilization that I could think whilst making this."
                    +"back to civilization"
                }
                +"."
            }
            separator()
            p {
                style = systemFontMono
                thewolfServer()
                +" :: "
                traefikProxy()
                +" › "
                span("red") {
                    if (host.isNullOrBlank()) {
                        title = """No "Host" Header."""
                        +"???"
                    } else {
                        title = """No routing found for "Host" Header with value "$host"."""
                        +host
                    }
                }
                +" ["
                span("red") {
                    title = "You are here."
                    +"404"
                }
                +".html]"
            }
        }
    }
}
