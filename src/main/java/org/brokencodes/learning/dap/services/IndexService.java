package org.brokencodes.learning.dap.services;

import org.brokencodes.learning.dap.beans.Index;

import java.util.List;

public interface IndexService {

    /**
     * Get a list of all indices for solutions.
     *
     * @return List<Index> all indices.
     */
    List<Index> getAll();

}
