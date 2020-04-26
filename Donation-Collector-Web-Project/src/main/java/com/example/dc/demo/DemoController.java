package com.example.dc.demo;

import com.example.dc.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class DemoController {
    @Autowired
    private DemoService demoService;

    @PostMapping(path="/addAddress") // Map ONLY POST Requests
    public @ResponseBody String addCourse(@RequestBody @NotNull Address address) {
        demoService.addAddress(address);
        return "saved";
    }

    @GetMapping(path="/getAddress")
    public @ResponseBody Iterable<Address> getAllAddress() {
        // This returns a JSON or XML with the users
        return demoService.findAllAddress();
    }
}
