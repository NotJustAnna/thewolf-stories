package net.notjustanna.thewolf.stories

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("net.notjustanna.thewolf.stories")
		.start()
}

