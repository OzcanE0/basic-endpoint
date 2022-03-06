package springframework.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.demo.model.BezDto;
import springframework.demo.services.BezService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;



@RestController
@RequestMapping("/api/v1/bez")
public class BezController {

    private final BezService bezService;

    public BezController(BezService bezService) {
        this.bezService = bezService;
    }

    @GetMapping({"{bezId}"})
    public ResponseEntity<BezDto> gezBez(@PathVariable("bezId") UUID bezId){

        return new ResponseEntity<>(bezService.getBezById(bezId), HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody BezDto bezDto){

        BezDto savedDto = bezService.saveNewBez(bezDto);

        HttpHeaders headers = new HttpHeaders();
       headers.add(headerName:"Location", headerValue:"/api/v1/bez") + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity handleUpdate(@PathVariable("bezId") UUID bezId, @RequestBody BezDto bezDto ){

        bezService.updateBez(bezId, bezDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)


    public void deleteBez(@PathVariable("bezId") UUID bezId){

        bezService.deleteById(bezId);

    }

}
