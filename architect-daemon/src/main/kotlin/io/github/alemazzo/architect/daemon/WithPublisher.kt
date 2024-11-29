package io.github.alemazzo.architect.daemon

import io.micronaut.context.event.ApplicationEventPublisher
import io.micronaut.runtime.event.annotation.EventListener
import jakarta.inject.Inject

interface WithPublisher<Res> {
	@get:Inject
	val _publisher: ApplicationEventPublisher<Res>? get() = null

	fun publish(event: Res) {
		if (_publisher == null) {
			throw IllegalStateException("Publisher is not available")
		}
		_publisher?.publishEvent(event)
	}
}

interface WithListener<Req> {
	@EventListener
	fun onEvent(event: Req)
}

interface Command<Req, Res> : WithListener<Req>, WithPublisher<Res>

data class HelloCommandRequest(val name: String)
data class HelloCommandResponse(val message: String)

class HelloCommand : Command<HelloCommandRequest, HelloCommandResponse> {
	override fun onEvent(event: HelloCommandRequest) {
		publish(HelloCommandResponse("Hello, ${event.name}!"))
	}
}
