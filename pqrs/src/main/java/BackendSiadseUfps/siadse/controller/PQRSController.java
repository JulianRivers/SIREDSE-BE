package BackendSiadseUfps.siadse.controller;

import BackendSiadseUfps.siadse.dto.PQRSDTO;
import BackendSiadseUfps.siadse.service.implementations.PQRSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/public/pqrs")
public class PQRSController {

    @Autowired
    PQRSService pqrsService;

    @PostMapping("/create")
    public ResponseEntity<PQRSDTO> createRequest(@RequestBody PQRSDTO pqrsDTO, @RequestParam Integer semilleroID, @RequestParam Integer tipoPQRSID) {

        PQRSDTO newPQRS = pqrsService.createPQRS(pqrsDTO, semilleroID, tipoPQRSID);

        return ResponseEntity.ok(newPQRS);
    }

}
