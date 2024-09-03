package ar.edu.austral.inf.sd.server.api

import ar.edu.austral.inf.sd.server.model.Signature
import ar.edu.austral.inf.sd.server.model.Signatures
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.beans.factory.annotation.Autowired

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class RelayApiController(@Autowired(required = true) val service: RelayApiService) {


    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/relay"],
        produces = ["application/json"],
        consumes = ["multipart/form-data"]
    )
    fun relayMessage( @RequestPart(value = "message", required = true) message: kotlin.String , @RequestPart(value = "signatures", required = true) signatures: Signatures ): ResponseEntity<Signature> {
        return ResponseEntity(service.relayMessage(message, signatures), HttpStatus.valueOf(202))
    }
}
