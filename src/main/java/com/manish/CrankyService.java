package com.manish;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

@RestController
public class CrankyService {

    private static final int MAX_DELAY_MILLISECONDS = 2000;

    @ResponseBody
    @RequestMapping(method = {RequestMethod.GET}, value = {"/delay"})
    public ResponseEntity<String> delay(@QueryParam("latency") Long latency) throws Exception {
        latency = (latency != null) ? latency : Math.round(Math.random() * MAX_DELAY_MILLISECONDS);
        TimeUnit.MILLISECONDS.sleep(latency);
        return new ResponseEntity<String>("Latency for this operation is " + latency + " ms.", HttpStatus.OK);
    }

    private static final double FAILURE_RATE = 0.5;
    private static final long DEFAULT_LATENCY_MILLISECONDS = 100;

    @ResponseBody
    @RequestMapping(method = {RequestMethod.GET}, value = {"/brittle"})
    public ResponseEntity<String> brittle(@QueryParam("latency") Long latency, @QueryParam("failureRate") Double failureRate) throws Exception {
        TimeUnit.MILLISECONDS.sleep(latency != null ? latency : DEFAULT_LATENCY_MILLISECONDS);
        failureRate = (failureRate != null) ? failureRate : FAILURE_RATE;
        boolean fail = Math.round(Math.random()) < failureRate;
        if (fail) {
            return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(method = {RequestMethod.GET}, value = {"/css/{file}/{latency}"})
    public ResponseEntity<Resource> css(@PathVariable("file") String file, @PathVariable("latency") Long latency) throws Exception {
        TimeUnit.MILLISECONDS.sleep(latency != null ? latency : DEFAULT_LATENCY_MILLISECONDS);

        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("static/css/" + file);

        InputStreamResource resource = new InputStreamResource(in);

        return ResponseEntity.ok()
                .header("Content-Type", "text/css")
                .body(resource);
    }

    @ResponseBody
    @RequestMapping(method = {RequestMethod.GET}, value = {"/images/{file}/{latency}"})
    public ResponseEntity<Resource> images(@PathVariable("file") String file, @PathVariable("latency") Long latency) throws Exception {
        TimeUnit.MILLISECONDS.sleep(latency != null ? latency : DEFAULT_LATENCY_MILLISECONDS);

        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("static/images/" + file);

        InputStreamResource resource = new InputStreamResource(in);

        return ResponseEntity.ok()
                .header("Content-Type", "image/jpeg")
                .body(resource);
    }

    @ResponseBody
    @RequestMapping(method = {RequestMethod.GET}, value = {"/scripts/{file}/{latency}"})
    public ResponseEntity<Resource> scripts(@PathVariable("file") String file, @PathVariable("latency") Long latency) throws Exception {
        TimeUnit.MILLISECONDS.sleep(latency != null ? latency : DEFAULT_LATENCY_MILLISECONDS);

        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("static/js/" + file);

        InputStreamResource resource = new InputStreamResource(in);

        return ResponseEntity.ok()
                .header("Content-Type", "application/javascript ")
                .body(resource);
    }
}
