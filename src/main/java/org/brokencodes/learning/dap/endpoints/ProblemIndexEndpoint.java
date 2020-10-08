package org.brokencodes.learning.dap.endpoints;

import org.brokencodes.learning.dap.beans.Index;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/index")
public class ProblemIndexEndpoint {

    @GetMapping("/all")
    public List<Index> completeIndex() {
        return null;
    }

}
